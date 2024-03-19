let status = {
    emailVerified: false,
    formValid: false,
    passwordCheck: false
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
        $('#findIdSubmitButton').removeClass('disabled').addClass('enabled');
        $('#findIdSubmitButton').prop('disabled', false);
    } else {
        $('#findIdSubmitButton').addClass('disabled').removeClass('enabled');
        $('#findIdSubmitButton').prop('disabled', true);
    }
}
