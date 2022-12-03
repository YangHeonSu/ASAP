$(document).ready(function () {
    getUser();
})
/**
 * 등록 버튼 클릭 시
 */
$('#moveForm').on("click", function () {
    location.href = "/users"; // 사용자 등록 페이지로 이동
})

/**
 * 검색 버튼 클릭 시
 */
$('#userSearchButton').on("click", function () {
    
})

/**
 * 사용자 Grid에서 항목 클릭 시 상세 페이지로 이동
 */
userGrid.on("click", function (ev) {
    if (ev.targetType !== 'cell') {
        return false;
    } else {
        const userId = userGrid.getFormattedValue(ev.rowKey, 'id'); // User PK
        moveDetailPage(userId);
    }
})

/**
 * 사용자 상세 페이지로 이동
 * @param userId id (pk)
 */
function moveDetailPage(userId) {
    location.href = '/users/detail/' + userId;
}
