$('#email, #email2').on('input', function() {
    var email1 = $('#email').val();
    var email2 = $('#email2').val();
    $('input[name="memberEmail"]').val(email1 + '@' + email2);
});