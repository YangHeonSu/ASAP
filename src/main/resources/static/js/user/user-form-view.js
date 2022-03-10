class UserFormView {
    constructor() {
        this.message = {
            createConfirm: '계정을 등록하시겠습니까?',
            cancelConfirm: '등록을 취소하시겠습니까?\n취소 시 내용이 저장되지 않습니다.',
            successCreate : '정상적으로 등록되었습니다.'
        }
        this.url = {
            list: '/users/list'
        }
    }

    // Id로 찾기
    findById = (id) => {
        return document.getElementById(id);
    }

    // 메세지 출력
    getMessage = (response) => {
        return this.message[response];
    }

    // 계정 목록 페이지로 이동
    moveUserListPage = () => {
        window.location.href = '/users/list';
    }

    // 사용자 Form 데이터  json 형태
    getUserData = () => {
        return {
            userId: $('#userId').val(),
            password: $('#password').val(),
            name: $('#name').val(),
            companyName: $('#companyName').val(),
            department: $('#department').val()
        }
    }


}