$(".idDuplicateCheckButton").click(function(){
    let id = $(".idField").val();
    $.ajax({
        url: '/member/idDuplicateCheck',
        type: 'GET',
        data: {id: id},
        success: function(isDuplicate) {
            // 반환받은 값이 true면 중복된 아이디가 있다는 것이므로, 아이디 확인 상태의 값을 false로 바꿈
            if(isDuplicate) {
                $('#modalText').text('사용할 수 없는 아이디입니다. 다른 아이디를 입력해주세요.');
                $('#myModal').show();
                updateStatus('idChecked', false);
            // 반환 받은 값이 false면 사용할 수 있는 아이디이므로, 아이디 확인 상태의 값을 true로 바꿈
            } else {
                $('#modalText').text('사용 가능한 아이디 입니다.');
                $('#myModal').show();
                updateStatus('idChecked', true);
            }
        },
        error: function() {
            $('#modalText').text('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
            $('#myModal').show();
        }
    });
});

