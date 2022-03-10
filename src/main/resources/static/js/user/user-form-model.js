class UserFormModel {
    constructor() {
    }

    // 사용자 등록
    createUser = (userFormData) => {
        return new Promise((resolve, reject) => {
            $.ajax({
                method: 'POST',
                url: '/users',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(userFormData),
                dataType: 'json',
            }).done(response => {
                resolve(response);
            }).fail((xhr, status, error) => {
                reject(error);
            })
        })
    }

    // ModifyUser
    modifyUser = (userInfo) => {
        return new Promise((resolve, reject) => {
            const id = userInfo.id;
            $.ajax({
                method: "PUT",
                url: "/users/" + id,
                data: JSON.stringify(userInfo),
                contentType: "application/json; charset=UTF-8",
                dataType: 'JSON'
            }).done(response => {
                resolve(response);
            }).fail((xhr, status, error) => {
                reject(error);
            })
        })
    }

    // Delete User
    deleteUser = (id) => {
        return new Promise((resolve, reject) => {
            $.ajax({
                method: 'DELETE',
                url: '/users/' + id,
                dataType: 'json',
            }).done(response => {
                resolve(response);
            }).fail((xhr, status, error) => {
                reject(error);
            })
        })
    }
}