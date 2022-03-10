class UserDetailView {
    constructor() {
        this.message = {
            saveConfirm: '계정정보를 수정하시겠습니까?',
            cancelConfirm: '계정목록 페이지로 이동하시겠습니까?\n이동 시 내용이 저장되지 않습니다.',
            deleteConfirm: '계정정보를 삭제하시겠습니까?\n삭제 시 해당 정보를 복구할 수 없습니다. ',
            successModify: '정상적으로 수정되었습니다.',
            successDelete: '정상적으로 삭제되었습니다.',
            errorMessage : '관리자에게 문의하시길 바랍니다.'
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

    // 목록 페이지로 이동
    moveUserListPage = () => {
        return window.location.href = '/users/list'
    }

    // 계정정보
    getUserData = () => {
        return {
            id: $('#id').val(),
            userId: $('#userId').val(),
            password: $('#password').val(),
            name: $('#name').val(),
            department: $('#department').val(),
            companyName: $('#companyName').val()
        }
    }
}