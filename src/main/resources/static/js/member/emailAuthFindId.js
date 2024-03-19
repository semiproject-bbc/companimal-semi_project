$(document).ready(function () {

    $("#sendEmail").click(function () {
        let email = $("#email").val();
        let memName = $("input[name='memName']").val()
        let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(email)) {
            $('#modalText').text('유효하지 않은 이메일 주소입니다.');
            $('#myModal').show();
            updateStatus('formValid', false);
        } else {
            $.ajax({
                url: '/member/registeredEmailCheckByName',
                type: 'POST',
                data: {email: email, memName: memName},
                success: function (registeredCheck) {
                    if (registeredCheck) {
                        updateStatus('formValid', true);

                        $.ajax({
                            url: '/member/sendEmail',
                            type: 'POST',
                            data: {email: email},
                            success: function () {
                                $('#modalText').text('인증번호가 발송되었습니다.');
                                $('#myModal').show();
                            },
                            error: function () {
                                $('#modalText').text('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
                                $('#myModal').show();
                            }
                        });
                    } else {
                        $('#modalText').text('일치하는 정보가 없습니다. 다시 시도해주세요.');
                        $('#myModal').show();
                    }

                },
                error: function () {
                    $('#modalText').text('인증 과정 중 오류가 발생했습니다. 다시 시도해주세요.');
                    $('#myModal').show();
                }

            })

        }
    });
});
