$(document).ready(function(){
    $(".certificationNumberCheckButton").click(function(){
        const email = $("#email").val();
        let authCode = $(".emailCertificationNumberField").val();
        $.ajax({
            url: '/member/verifyEmail',
            type: 'POST',
            data: {
                email: email,
                authCode: authCode
            },
            success: function(isValid) {
                if(isValid) {
                    alert('인증되었습니다.');
                } else {
                    alert('인증 번호가 일치하지 않습니다. 다시 시도해주세요.');
                }
            },
            error: function() {
                alert('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
            }
        });
    });
});
