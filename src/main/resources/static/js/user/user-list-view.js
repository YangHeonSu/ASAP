class UserListView{
    constructor() {
        this.url ={
            userForm : '/users/form',
            userDetail : '/users/detail'

        }
    }

    // 등록 페이지로 이동
    moveUserFormPage = ()=>{
        window.location.href = '/users';
    }

    // User ID(PK)를 통해 상세페이지로 이동
    moveUserDetailPage = (userId) =>{
        window.location.href = '/users/detail/' + userId;
    }

}