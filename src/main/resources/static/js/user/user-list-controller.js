class UserListController {
    constructor(view) {
        this.view = view;
        this.userListAddEventListener(view);
    }

    userListAddEventListener(view) {
        const moveFormButton = document.getElementById('moveForm'); // 등록 버튼

        // 등록 버튼 클릭 시
        moveFormButton.addEventListener("click", () => {
            view.moveUserFormPage();
        })

        // UserGrid 클릭 시
        userGrid.on('click', (ev) => {
            if (ev.targetType !== 'cell') {
                return false;
            }
            const userId = userGrid.getFormattedValue(ev.rowKey, 'id'); // User PK
            view.moveUserDetailPage(userId);
        })
    }
}