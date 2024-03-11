$(document).ready(function(){
    $("#sendEmail").click(function(){
        const email = $("#email").val();
        $.ajax({
            url: '/member/sendEmail', // 이메일 인증을 처리하는 서버의 URL
            type: 'POST',
            data: {email: email},
            success: function() {
                alert('인증번호가 발송되었습니다..');
            },
            error: function() {
                alert('인증번호 발송에 실패하였습니다. 다시 시도해주세요.');
            }
        });
    });
});
