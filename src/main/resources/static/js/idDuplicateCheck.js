$(".idDuplicateCheckButton").click(function(){
    let id = $(".idField").val();
    $.ajax({
        url: '/member/idDuplicateCheck',
        type: 'GET',
        data: {id: id},
        success: function(isDuplicate) {
            if(isDuplicate) {
                $('#modalText').text('사용할 수 없는 아이디입니다. 다른 아이디를 입력해주세요.');
                $('#myModal').show();

            } else {
                $('#modalText').text('사용 가능한 아이디 입니다.');
                $('#myModal').show();
            }
        },
        error: function() {
            $('#modalText').text('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
            $('#myModal').show();
        }
    });
});