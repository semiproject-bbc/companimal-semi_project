$(document).ready(function() {
    function validateForm() {
        let isValid = true;

        let memberId = $('input[name="memberId"]').val();
        if(memberId.length < 6 || memberId.length > 20) {
            $('#modalText').text('아이디는 6자 이상 20자 이하로 입력해주세요.');
            $('#myModal').show();
            isValid = false;
        }

        let memberPwd = $('input[name="memberPwd"]').val();
        if(memberPwd.length < 6 || memberPwd.length > 20) {
            $('#modalText').text('비밀번호는 6자 이상 20자 이하로 입력해주세요.');
            $('#myModal').show();
            isValid = false;
        }

        let passwordCheck = $('.passwordCheckField').val();
        if(memberPwd !== passwordCheck) {
            $('#modalText').text('비밀번호가 일치하지 않습니다.');
            $('#myModal').show();
            isValid = false;
        }

        let memberNickname = $('input[name="memberNickname"]').val();
        if(memberNickname.length < 2 || memberNickname.length > 10) {
            $('#modalText').text('닉네임은 2자 이상 10자 이하로 입력해주세요..');
            $('#myModal').show();
            isValid = false;
        }

        let memberName = $('input[name="memberName"]').val();
        if(memberName.length < 2 || memberName.length > 20) {
            $('#modalText').text('이름은 2자 이상 20자 이하로 입력해주세요.');
            $('#myModal').show();
            isValid = false;
        }

        let memberPhone = $('input[name="memberPhone"]').val();
        let phoneRegex = /^[0-9]{10,11}$/;
        if(!phoneRegex.test(memberPhone)) {
            $('#modalText').text('유효하지 않은 휴대폰 번호입니다.');
            $('#myModal').show();
            isValid = false;
        }


        let memberEmail = $('input[name="memberEmail"]').val();
        let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if(!emailRegex.test(memberEmail)) {
            $('#modalText').text('유효하지 않은 이메일 주소입니다.');
            $('#myModal').show();
            isValid = false;
        }

        updateStatus('formValid', isValid);
    }

    $('.registForm_form input').on('blur', function() {
        validateForm();
    });

});