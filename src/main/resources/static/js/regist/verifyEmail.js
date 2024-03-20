$(document).ready(function(){
    $(".certificationNumberCheckButton").click(function(){
        let email = $("#email").val();
        if ($("#email2").val() == null) {

        } else {
            email = $("#email").val() + "@" + $("#email2").val();
        }

        let authCode = $(".emailCertificationNumberField").val();
        $.ajax({
            url: '/member/verifyEmail',
            type: 'POST',
            data: {
                email: email,
                authCode: authCode
            },
            success: function(isValid) {
                // 반환 받은 값이 true면 이메일 인증에 대한 상태를 true로 바꿈
                if(isValid) {
                    $('#modalText').text('인증되었습니다.');
                    $('#myModal').show();
                    updateStatus('emailVerified', true);

                } else {
                    $('#modalText').text('인증번호가 일치하지 않습니다.\n 다시 시도해주세요.');
                    $('#myModal').show();
                     updateStatus('emailVerified', false);

                }
            },
            error: function() {
                $('#modalText').text('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
                $('#myModal').show();
            }
        });
    });
});

