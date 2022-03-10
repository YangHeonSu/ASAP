window.addEventListener('DOMContentLoaded', () => {
    const view = new UserDetailView();
    const model = new UserFormModel();
    const controller = new UserDetailController(model, view);
})

