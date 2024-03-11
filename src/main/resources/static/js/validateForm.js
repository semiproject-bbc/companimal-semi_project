function validateForm() {
    var isValid = true;
    var emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/; // 간단한 이메일 형식 검사를 위한 정규식

    // 아이디 검사
    if (!$('.idField').val()) {
        isValid = false;
        alert('아이디를 입력해주세요.');
    }

    // 비밀번호 검사
    if (!$('.passwordField').val()) {
        isValid = false;
        alert('비밀번호를 입력해주세요.');
    } else if ($('.passwordField').val() != $('.passwordCheckField').val()) {
        isValid = false;
        alert('비밀번호가 일치하지 않습니다.');
    }

    // 닉네임 검사
    if (!$('.nicknameField').val()) {
        isValid = false;
        alert('닉네임을 입력해주세요.');
    }

    // 이름 검사
    if (!$('.nameField').val()) {
        isValid = false;
        alert('이름을 입력해주세요.');
    }

    // 휴대폰 번호 검사
    if (!$('.phoneNumberField').val()) {
        isValid = false;
        alert('휴대폰 번호를 입력해주세요.');
    }

    // 이메일 형식 검사
    if (!emailRegex.test($('#email').val())) {
        isValid = false;
        alert('올바른 이메일 형식이 아닙니다.');
    }

    // 이메일 인증 번호 검사
    if (!$('.emailCertificationNumberField').val()) {
        isValid = false;
        alert('이메일 인증 번호를 입력해주세요.');
    }

    return isValid;
}
