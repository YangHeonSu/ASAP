/**
 * 저장 버튼 클릭 시
 */
$('#saveUserButton').on("click", function () {
    resetFormValidMessage();
    if (confirm("계정 정보를 수정하시겠습니까?")) {
        let data = getFormData();
        saveUser(data);
    }
})

/**
 * 목록 버튼 클릭 시
 */
$('#moveListButton').on("click", function () {
    if (confirm("사용자 목록 페이지로 이동하시겠습니까?" + '\n' + "이동 시 입력 내용은 저장되지 않습니다.")) {
        window.location.href = '/users/list';
    }
})

/**
 * 삭제 버튼 클릭 시
 */
$('#deleteButton').on("click", function () {
    if (confirm("해당 계정을 삭제하시겠습니까?" + '\n' + "삭제 시 복구할 수 없습니다.")) {
        let id = getFormData().id;
        deleteUser(id);
    }
})

/**
 * 사용자 정보 가져오기
 * @returns {{companyName: (*|string|jQuery), name: (*|string|jQuery), id: (*|string|jQuery), department: (*|string|jQuery), userId: (*|string|jQuery)}}
 */
function getFormData() {
    return {
        id: $('#id').val(),
        userId: $('#userId').val(),
        name: $('#name').val(),
        department: $('#department').val(),
        companyName: $('#companyName').val()
    }
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
 * 사용자 계정정보 저장
 * @param userData userFormData
 */
function saveUser(userData) {
    $.ajax({
        method : 'POST',
        url : '/users',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(userData),
        dataType: 'json',
    }).done(function (response) {
        if (response['saveResult'] === 200) {
            alert('정상적으로 저장되었습니다.');
            location.href = '/users/list';
        } else {
            setFormValidationMessage(response);
        }
    })
}

/**
 * 계정 삭제
 * @param id
 */
function deleteUser(id) {
    $.ajax({
        method : 'DELETE',
        url : '/users/'+ id ,
        contentType: 'application/json; charset=UTF-8',
        data: {"id" : id},
        dataType: 'json',
    }).done(function (response) {
        if (response['deleteResult'] === 200) {
            alert('정상적으로 삭제되었습니다.');
            location.href = '/users/list';
        } 
    })
}