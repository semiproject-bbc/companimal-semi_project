$(document).ready(function(){
    function checkDirectInput() {
        var select = document.querySelector('.emailSelect');
        var directInput = document.getElementById('directEmail');
        if(select.value === "direct") {
            directInput.style.display = "inline";
        } else {
            directInput.style.display = "none";
        }
    }

    function combineEmail() {
        var emailId = document.getElementById('email').value;
        var select = document.querySelector('.emailSelect');
        var domain = select.value;
        var directInput = document.getElementById('directEmail').value;

        if(domain === "direct") {
            domain = directInput;
        }

        var fullEmail = emailId + "@" + domain;
        alert("완성된 이메일 주소: " + fullEmail); // 실제로는 이 부분에서 이메일 주소를 사용할 수 있도록 적절히 처리
    }

    $("#sendEmail").click(function(){
        const email = $("#email").val();
        $.ajax({
            url: '/member/sendEmail',
            type: 'POST',
            data: {email: email},
            success: function() {
                alert("1")
                $('#modalText').text('인증번호가 발송되었습니다.');
                $('#myModal').show();
            },
            error: function() {
                $('#modalText').text('인증번호 발송에 실패하였습니다. \n다시 시도해주세요.');
                $('#myModal').show();
            }
        });
    });
});
