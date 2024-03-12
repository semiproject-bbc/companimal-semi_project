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
        let email = $("#email").val() + "@" + $("#email2").val();
        let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(email)) {
            $('#modalText').text('유효하지 않은 이메일 주소입니다.');
            $('#myModal').show();
            updateStatus('formValid', false);
        } else {
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
                    $('#modalText').text('인증번호 발송에 실패하였습니다. \n다시 시도해주세요.');
                    $('#myModal').show();
                }
            });
        }
    });
});
