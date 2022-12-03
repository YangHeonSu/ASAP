/**
 * 저장 버튼 클릭 시
 */
$('#saveUserButton').on("click", function () {
    if (confirm("계정 정보를 수정하시겠습니까?")) {
        let data = getFormData();

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