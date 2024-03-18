$(document).ready(function () {

    $(".emailSelect").change(function () {
        let selectedDomain = $(this).val();
        if (selectedDomain === "direct") {
            $("#email2").prop('disabled', false).val('').focus();
        } else {
            $("#email2").val(selectedDomain).prop('disabled', true);
        }
    });

    $("#sendEmail").click(function () {
        let email = $("#email").val();
        let memId = $("input[name='memId']").val()
        let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(email)) {
            $('#modalText').text('유효하지 않은 이메일 주소입니다.');
            $('#myModal').show();
        } else {
            $.ajax({
                url: '/member/registeredEmailCheckById',
                type: 'POST',
                data: {email: email, memId: memId},
                success: function (registeredCheck) {
                    if (registeredCheck) {
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
