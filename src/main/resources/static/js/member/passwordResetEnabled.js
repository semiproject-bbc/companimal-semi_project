let status = {
    formValid: false,
    emailVerified: false,
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
        $('#resetPasswordSubmitButton').removeClass('disabled');
        $('#resetPasswordSubmitButton').prop('disabled', false);
    } else {
        $('#resetPasswordSubmitButton').addClass('disabled');
        $('#resetPasswordSubmitButton').prop('disabled', true);
    }
}
