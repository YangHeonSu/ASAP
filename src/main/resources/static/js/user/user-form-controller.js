class UserFormController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
        this.userFormEventListener(model, view);
    }

    userFormEventListener(model, view) {
        const createUserButton = view.findById('createUserButton'); // 등록 버튼
        const cancelButton = view.findById('cancelButton'); // 취소 버튼

        // 등록 버튼 클릭 시
        createUserButton.addEventListener("click", () => {
            if (confirm(view.getMessage('createConfirm'))) {
                let userFormData = view.getUserData();
                model.createUser(userFormData).then(response => {
                    if (response['createResult'] === 200) {
                        alert(view.getMessage('successCreate'));
                        view.moveUserListPage();
                    }
                })
            }
        })
        // 취소 버튼 클릭 시
        cancelButton.addEventListener("click", () => {
            if (confirm(view.getMessage('cancelConfirm'))) {
                view.moveUserListPage();
            }
        });
    }
}