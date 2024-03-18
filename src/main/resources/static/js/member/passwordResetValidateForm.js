$(document).ready(function () {
    $('#memberPwd').blur(function () {
        validateMemberPwd();
    });

    $('#passwordCheck').blur(function () {
        validatePasswordCheck();
    });

    function validateMemberPwd() {
        let memberPwd = $('#memberPwd').val();
        if (memberPwd.length < 6 || memberPwd.length > 20) {
            $('#modalText').text('비밀번호는 6자 이상 20자 이하로 입력해주세요.');
            $('#myModal').show();
            updateStatus('formValid', false);
        } else {
            updateStatus('formValid', true);
        }
    }

    function validatePasswordCheck() {
        let memberPwd2 = $('#memberPwd').val();
        let passwordCheck = $('#passwordCheck').val();
        if (memberPwd2 !== passwordCheck) {
            $('#modalText').text('비밀번호가 일치하지 않습니다.');
            $('#myModal').show();
            updateStatus('passwordCheck', false);
        } else {
            updateStatus('passwordCheck', true);
            console.log('form true')
        }
    }
});