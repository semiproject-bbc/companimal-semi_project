$(document).ready(function(){
    $("#sendEmail").click(function(){
        const email = $("#email").val();
        $.ajax({
            url: '/member/sendEmail',
            type: 'POST',
            data: {email: email},
            success: function() {
                alert("1")
                $('#modalText').text('인증번호가 발송되었습니다.');
                $('#myModal').show();
            },
            error: function() {
                $('#modalText').text('인증번호 발송에 실패하였습니다. \n다시 시도해주세요.');
                $('#myModal').show();
            }
        });
    });
});
