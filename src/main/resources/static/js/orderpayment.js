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
        event.preventDefault(); // Prevent default action of button
        if (checkAllCheckboxes() && checkAllTextInputs()) {
            window.location.href = "/kakaoPay"; // Redirect to payment page
        } else if (checkAllCheckboxes() && !checkAllTextInputs()) {
            alert("정보를 입력해주세요");
        } else if (!checkAllCheckboxes() && checkAllTextInputs()) {
            alert("체크박스에 체크를 해주세요");
        } else {
            alert("모든 정보를 입력해주세요."); // Alert user to agree to all terms and conditions
        }
    });
});

/* ====================================================================================================== */
/* 4. 모두 다 입력을 해야 다음 결제 화면으로 이동이 가능하다 */

// document.addEventListener("DOMContentLoaded", function() {
//     document.addEventListener("submit", function() {
//         var rewardGetPersonName = document.querySelector('.rewardGetPersonNameInfo');
//         var rewardGetPersonAddress = document.querySelector('.rewardGetPersonAddressInfo');
//         var rewardToNotify = document.querySelector('.rewardToNotifyText');
//
//         if(!rewardGetPersonName.value || !rewardGetPersonAddress.value || !rewardToNotify.value) {
//             alert('필수 정보들을 입력해주세요.');
//         } else {
//             window.location.href= "/kakaoPay";
//         }
//     });
// });

// window.addEventListener('DOMContentLoaded', function () {
//     document.querySelector('.ontoPaymentPage').addEventListener('submit', function (event) {
//         var nameInput = document.querySelector('.rewardGetPersonNameInfo');
//         var addressInput = document.querySelector('.rewardGetPersonAddressInfo');
//
//         if (!nameInput.value || !addressInput.value) {
//             event.preventDefault(); // Prevent form submission
//             alert('수취인명과 주소를 입력하세요.'); // Display an alert or handle the validation message in your preferred way
//         }
//     });
// });


/* ====================================================================================================== */
/* 5. 약관동의 보기를 누르면 해당 약관동의 page가 현재 page에서 overlay 되면서 현재 화면에 표시가 된다 */
function openCondition(e) {

    /*/!* 보기들 *!/
    const condition1box = document.getElementById('condition1');
    const condition2box = document.getElementById('condition2');
    const condition3box = document.getElementById('condition3');
    const condition4box = document.getElementById('condition4');
    /!* 약관 보기 page들 *!/
    const seeCondition1box = document.getElementById('seeCondition1');
    const seeCondition2box = document.getElementById('seeCondition2');
    const seeCondition3box = document.getElementById('seeCondition3');
    const seeCondition4box = document.getElementById('seeCondition4');*/
    const targetId = e.id // click한 id를 가져와
    const num = targetId.substring(9); // id의 뒤에 있는 번호 No를 가져오고
    const test2 = document.getElementById("seeCondition" + num); // 약관동의와 일치하게 만들어. 쉽잖아?
    // 다음으로,,, 눌렀을 때 일치하면 hidden을 끌 수 있겠금 coding읋 하면 끝이잖아?
    test2.classList.remove('display-hidden');
    // document.querySelector('.display-hidden').remove('display-hidden');

    const modalBlock = document.getElementById('modal1');
    const modalBlock2 = document.getElementById('modal2');
    /*console.log(e.id);
    if (targetId === 'condition1') {
    if (condition1box.onclick) {
        seeCondition1box.classList.add('showmodal');

    } else if (targetId === 'condition2') {
        test2.classList.remove('display-hidde');
    } else if (targetId === 'condition3') {
        test2.classList.remove('display-hidde');
    } else if (targetId === 'condition4') {
        test2.classList.remove('display-hidde');
    }
*/
    modalBlock.classList.remove('display-hidden');
    modalBlock2.classList.remove('display-hidden');
};

/* ====================================================================================================== */
/* 각 약관들의 close-button을 누르면 창을 닫는다 */

function closeButton(e) {
    const closeButton = e.class;
    window.close();
}


/* ====================================================================================================== */