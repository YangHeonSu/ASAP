class UserDetailController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
        this.UserDetailEventListener(model, view);
    }

    UserDetailEventListener(model, view) {
        const moveListButton = view.findById('moveListButton');
        const saveUserButton = view.findById('saveUserButton');
        const deleteButton = view.findById('deleteButton');

        // moveListButton Click Action
        moveListButton.addEventListener("click", () => {
            if (confirm(view.getMessage('cancelConfirm'))) {
                view.moveUserListPage();
            }
        })

        // saveUserButton Click Action
        saveUserButton.addEventListener("click", () => {
            const userInfo = view.getUserData();
            if (confirm(view.getMessage('saveConfirm')))
                model.modifyUser(userInfo).then(modifyResult => {
                    if (modifyResult['modifyResult'] === 200) {
                        alert(view.getMessage('successModify'));
                        view.moveUserListPage();
                    }
                })
        })

        // deleteButton Click Action
        deleteButton.addEventListener("click", () => {
            const userCode = view.getUserData().id;
            if (confirm(view.getMessage('deleteConfirm'))) {
                model.deleteUser(userCode).then(deleteResult => {
                    if (deleteResult['deleteResult'] === 200) {
                        alert(view.getMessage('successDelete'));
                        view.moveUserListPage();
                    }
                })
            }
        })
    }
}