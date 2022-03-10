window.addEventListener('DOMContentLoaded', () => {
    const model = new UserFormModel();
    const view = new UserFormView();
    const controller = new UserFormController(model, view);
})