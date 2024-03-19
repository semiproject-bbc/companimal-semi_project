let status = {
    emailVerified: false,
    formValid: false,
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
        $('#findIdSubmitButton').removeClass('disabled');
        $('#findIdSubmitButton').prop('disabled', false);
    } else {
        $('#findIdSubmitButton').addClass('disabled');
        $('#findIdSubmitButton').prop('disabled', true);
    }
}
