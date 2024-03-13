$(document).ready(function() {

    $('#memberId').blur(function() {
        validateMemberId();
    });

    $('#memberPwd').blur(function() {
        validateMemberPwd();
    });

    $('#passwordCheck').blur(function() {
        validatePasswordCheck();
    });

    $('#memberNickname').blur(function() {
        validateMemberNickname();
    });

    $('#memberName').blur(function() {
        validateMemberName();
    });

    $('#memberPhone').blur(function() {
        validateMemberPhone();
    });
});

function validateMemberId() {
    let memberId = $('#memberId').val();
    if (memberId.length < 6 || memberId.length > 20) {
        $('#modalText').text('아이디는 6자 이상 20자 이하로 입력해주세요.');
        $('#myModal').show();
        updateStatus('formValid', false);
    } else {
        updateStatus('formValid', true);
    }
}

function validateMemberPwd() {
    let memberPwd = $('#memberPwd').val();
    if(memberPwd.length < 6 || memberPwd.length > 20) {
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
        updateStatus('formValid', false);
    } else {
        updateStatus('formValid', true);
    }
}

function validateMemberNickname() {
    let memberNickname = $('#memberNickname').val();
    if(memberNickname.length < 2 || memberNickname.length > 10) {
        $('#modalText').text('닉네임은 2자 이상 10자 이하로 입력해주세요..');
        $('#myModal').show();
        updateStatus('formValid', false);
    } else {
        updateStatus('formValid', true);
    }
}

function validateMemberName() {
    let memberName = $('#memberName').val();
    if(memberName.length < 2 || memberName.length > 20) {
        $('#modalText').text('이름은 2자 이상 20자 이하로 입력해주세요.');
        $('#myModal').show();
        updateStatus('formValid', false);
    } else {
        updateStatus('formValid', true);
    }
}

function validateMemberPhone() {
    let memberPhone = $('#memberPhone').val();
    let phoneRegex = /^[0-9]{10,11}$/;
    if(!phoneRegex.test(memberPhone)) {
        $('#modalText').text('유효하지 않은 휴대폰 번호입니다.');
        $('#myModal').show();
        updateStatus('formValid', false);
    } else {
        updateStatus('formValid', true);
    }
}



