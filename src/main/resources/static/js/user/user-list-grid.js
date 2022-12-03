function getUser() {
    $.ajax({
        method: 'GET',
        url:'/users',
        dataType : 'JSON',
        success : function (response) {
            userGrid.resetData(response);
        }
    })
};

let userGrid = new tui.Grid( {
    el: document.getElementById('userGrid'),
    scrollX: false,
    scrollY: false,

    columns: [
        {
            header: '코드',
            name : 'id',
            hidden : true
        },{
            header: '아이디',
            name: 'userId',
        }, {
            header: '이름',
            name: 'name',
        }, {
            header: '회사명',
            name: 'companyName'
        }, {
            header: '권한',
            name: 'department'
        }
    ]
});
