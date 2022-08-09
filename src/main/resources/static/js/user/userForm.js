const saveButton = document.getElementById('createUserButton');
const moveListButton = document.getElementById('moveListButton');

/**
 * 계정 목록 페이지로 이동
 */
moveListPage = () =>{
    window.location.href = '/users/list';
}

/**
 * 계정 등록 정보 가져오기 JSON
 */
getUserData = () => {
    return {
        userId: $('#userId').val(),
        password: $('#password').val(),
        name: $('#name').val(),
        companyName: $('#companyName').val(),
        department: $('#department').val()
    }
}

/**
 * 계정 정보 저장
 * 
 * @param UsersData userData
 * @returns save Result Code
 */
setUsers = (UsersData) => {
    return new Promise((resolve, reject) => {
        $.ajax({
            method: 'POST',
            url: '/users',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(UsersData),
            dataType: 'json',
        }).done(response => {
            resolve(response);
        }).fail((xhr, status, error) => {
            reject(error);
        })
    })
}

/**
 * 저장 버튼 클릭 시
 */
saveButton.addEventListener("click", () => {
    let userData = getUserData();
    setUsers(userData).then(response=>{
        if (response['createResult'] === 200) {
            alert('정상적으로 등록되었습니다.');
            moveListPage();
        }
    })
})

