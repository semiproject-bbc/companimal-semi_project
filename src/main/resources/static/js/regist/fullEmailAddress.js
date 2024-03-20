/* #enail과 #email2에 입력을 받으면 컨트롤러로 값을 보낼 입력필드에 두 값이 합쳐져서 저장 됨 */
$('#email, #email2').on('input', function() {
    var email1 = $('#email').val();
    var email2 = $('#email2').val();
    $('input[name="memberEmail"]').val(email1 + '@' + email2);
});
