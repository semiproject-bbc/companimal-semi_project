let status = {
    idChecked: false,
    emailVerified: false,
    formValid: false,
    termsChecked: false
};

function updateStatus(key, value) {
    if (status.hasOwnProperty(key)) {
        status[key] = value;
        checkAllCompleted();
    }
}

function checkAllCompleted() {

    const allCompleted = Object.values(status).every(val => val === true);
    if (allCompleted) {
        $('#registSubmitButton').removeClass('disabled').addClass('enabled');
        $('#registSubmitButton').prop('disabled', false);
    } else {
        $('#registSubmitButton').addClass('disabled').removeClass('enabled');
        $('#registSubmitButton').prop('disabled', true);
    }
}