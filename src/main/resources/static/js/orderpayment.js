/* ------------------------------------------------- 약관 동의 script ------------------------------------------------- */

/* 1. 전체 동의를 누를시 아래 있는 약관들이 check, unchecked 가 된다 */
document.addEventListener("DOMContentLoaded", function click() {

    var agreeToAllConditionsCheckbox = document.querySelector('.agreeToAllCheckbox');
    var subCheckboxes = document.querySelectorAll('.subCheckbox1, .subCheckbox2, .subCheckbox3, .subCheckbox4');
    function handleCheckboxClick() {

        if (agreeToAllConditionsCheckbox.checked) {
            for (const checkbox of subCheckboxes) {
                checkbox.checked = true;
            }
        } else {
            for (const checkbox of subCheckboxes) {
                checkbox.checked = false;
            }
        }

        if (subCheckboxes.checked) {
            agreeToAllConditionsCheckbox.checked;
        } else {
            !agreeToAllConditionsCheckbox.checked;
        }
    }
    handleCheckboxClick(); // 전체 동의 initial check

    agreeToAllConditionsCheckbox.addEventListener('change', handleCheckboxClick);
});

/* ====================================================================================================== */
/* 2. 하나의 subCheck라도 check 안돼있으면 전체동의는 활성화 되어있지 않는다 */
document.addEventListener("DOMContentLoaded", function checkboxConditions() {
    var subCheckboxes = document.querySelectorAll('.subCheckbox1, .subCheckbox2, .subCheckbox3, .subCheckbox4');
    var mainCheckbox = document.querySelector('.agreeToAllCheckbox');

    subCheckboxes.forEach(function(subCheckbox) {
        subCheckbox.addEventListener("change", function() {
            var allChecked = true;
            subCheckboxes.forEach(function(checkbox) {
                if (!checkbox.checked) { // 하나라도 check가 되어있지 않으면 false 값 return -> 전체 동의 checkbox = unchecked
                    allChecked = false;
                }
            });
            mainCheckbox.checked = allChecked; // 기본으로 전체동의 checkbox = true;
        });
    });
});

/* ====================================================================================================== */
/* 3. 모든 checkbox을 선택을 해야 다음 페이지 (결제 page)로 이동이 가능하다 */
document.addEventListener("DOMContentLoaded", function() {
    var allCheckBoxes = document.querySelectorAll('input[type="checkbox"]');
    var ontoPaymentButton = document.querySelector('.ontoPayment');
    var container = document.querySelector('.ontoPaymentPage');

    /* 정보들을 입력하지 않으면 다음 페이지로 넘어가지를 못한다 */
    var rewardGetPersonName = document.querySelector('.rewardGetPersonNameInfo');
    var rewardGetPersonAddress = document.querySelector('.rewardGetPersonAddressInfo');
    var rewardToNotify = document.querySelector('.rewardToNotifyText');

    /* checkbox가 모두 check가 되었는지 확인 */
    function checkAllCheckboxes() {
        var allChecked = true;
        allCheckBoxes.forEach(function(checkbox) {
            if (!checkbox.checked) {
                allChecked = false;
            }
        });
        return allChecked;
    }

    // 모든 checkbox을 check해야 결제하기 button의 색이 바뀐다. 그렇지 않으면 원래 색으로 돌아간다
    function handlePaymentButton() {
        if (checkAllCheckboxes()) { // 모든 checkbox가 check 되어있으면
            ontoPaymentButton.style.backgroundColor = '#FCA652'; // Change button color
            ontoPaymentButton.style.color = 'white';
            // ontoPaymentButton.disabled = false; // enable button (alert를 해야하기 때문에 비활성화)
        } else { // 아니면
            ontoPaymentButton.style.backgroundColor = '#E7E7E7'; // 원래 색으로 되돌린다
            ontoPaymentButton.style.color = 'white';
            // ontoPaymentButton.disabled = true; // Disable button (같은 이유)
        };
    };

    // Event listener for checkbox changes
    allCheckBoxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            handlePaymentButton(); // Call the function to handle button color and enabling/disabling
        });
    });

    // event listener for text input changes
    var allTextInputs = document.querySelectorAll('.rewardDestination-container input[type="text"]');
    allTextInputs.forEach(function(input) {
        input.addEventListener('input', function() {
            handlePaymentButton(); // Call the function to handle button color and enabling/disabling
        });
    });

    // check if all text input fields are filled out
    function checkAllTextInputs() {
        var allFilled = true;
        allTextInputs.forEach(function(input){
           if (!input.value.trim()) {
               allFilled = false;
           }
        });
        return allFilled;
    }

    // Event listener for button click to proceed to payment page
    ontoPaymentButton.addEventListener('click', function(event) {
        if (!checkAllCheckboxes() || !checkAllTextInputs()) {
            event.preventDefault(); // Prevent default action of button only if conditions are not met
            if (!checkAllCheckboxes() && !checkAllTextInputs()) {
                alert("모든 정보를 입력해주세요."); // Alert user to agree to all terms and conditions
            } else if (!checkAllCheckboxes()) {
                alert("체크박스에 체크를 해주세요");
            } else {
                alert("정보를 입력해주세요");
            }
        }
    });
});


/* ====================================================================================================== */
/* 약관동의 보기 */
document.addEventListener('DOMContentLoaded', function() {
    // Get all the buttons with the class "btn"
    var modalButtons = document.querySelectorAll('.btn');

    // Get all the modals
    var modals = document.querySelectorAll('.modal');

    // Attach click event listener to each modal button
    modalButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            // Get the ID of the modal to display from the data-target attribute
            var modalIdToShow = button.dataset.target;

            // Loop through all modals to hide them
            modals.forEach(function(modal) {
                modal.style.display = 'none';
            });

            // Display the modal with the corresponding ID
            var modalToShow = document.getElementById(modalIdToShow);
            if (modalToShow) {
                modalToShow.style.display = 'block';
            }
        });
    });

    // Attach click event listener to close buttons of modals
    var closeButtons = document.querySelectorAll('.close');
    closeButtons.forEach(function(closeButton) {
        closeButton.addEventListener('click', function() {
            // Hide the modal when close button is clicked
            var modal = closeButton.closest('.modal');
            modal.style.display = 'none';
        });
    });
});
