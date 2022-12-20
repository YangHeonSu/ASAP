/**
 * 등록 버튼 클릭 시
 */
$('#createUserButton').on("click", function () {
    resetFormValidMessage();
    if (confirm("등록하시겠습니까?")) {
        let userFormData = getUserData();
        setUsers(userFormData);
    }
})

/**
 * 취소 버튼 클릭 시
 */
$('#cancelButton').on("click", function () {
    if (confirm("사용자 목록 페이지로 이동하시겠습니까?" + '\n' + "이동 시 입력 내용은 저장되지 않습니다.")) {
        window.location.href = '/users/list';
    }
})


/**
 * 계정 등록 정보 가져오기 JSON
 */
function getUserData() {
    return {
        userId: $('#userId').val(),
        password: $('#password').val(),
        name: $('#name').val(),
        companyName: $('#companyName').val(),
        department_name: $('#department').val()
    }
}

/**
 * 등록 버튼 클릭 시
 * Form ValidationMessage 초기화
 */
function resetFormValidMessage() {
    $('#userIdValidMessage').html("");
    $('#passwordValidMessage').html("");
    $('#nameValidMessage').html("");
    $('#companyNameValidMessage').html("");
    $('#departmentValidMessage').html("");
}

/**
 * 입력 값에 대한 validationMessage 설정
 * @param validationMessage validationMessage
 */
function setFormValidationMessage(validationMessage) {
    $.each(validationMessage, function (index, item) {
        $('#' + index + "ValidMessage").html(item);
    })
}

/**
 * 계정 정보 저장
 * @param UsersData userData
 * @returns save Result Code
 */
function setUsers(UsersData) {
    $.ajax({
        method: 'POST',
        url: '/users',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(UsersData),
        dataType: 'json',
    }).done(function (response) {
        if (response['saveResult'] === 200) {
            alert('정상적으로 등록되었습니다.');
            location.href = '/users/list';
        } else {
            setFormValidationMessage(response);
        }
    })
}