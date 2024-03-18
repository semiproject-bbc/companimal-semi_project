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
/* 5. 약관동의 보기를 누르면 해당 약관동의 page가 현재 page에서 overlay 되면서 현재 화면에 표시가 된다 */
function openCondition(e) {
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

// function closeButton(e) {
//     const closeButton = e.class;
//     window.close();
// }

/* ====================================================================================================== */
/* 6. 쿠폰을 선택을 했을 때 총금액에 쿠폰금액만큼 차감한다 */
document.addEventListener('DOMContentLoaded', function() {
    var selectedCoupon = document.getElementById('couponAmountId');         // 쿠폰을 선택할 때 id
    var preFinalPayment = document.getElementById('finalPaymentAmountId');  // 최종 결제 금액 id
    // var rewSf = 2500;

    selectedCoupon.addEventListener('change', function(event) {   // 왜 select가 아닌지
        var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex];    // 선택한 쿠폰 정보를 가져온다
        var selectedCouponAmount = parseInt(selectedCouponOption.value);           // 선택한 쿠폰값을 가져온다
        console.log('Selected coupon amount:', selectedCouponAmount);                       // couponAmount를 잘 선택을 했는지 확인하는 용도

        /* 쿠폰 할인을 뺀 최종 결제 금액값  */
        var finalPaymentBeforeRewSf = parseInt(preFinalPayment.textContent.replace('원', ''));
        var finalPaymentAfterCoupon = finalPaymentBeforeRewSf - selectedCouponAmount;    // 최종금액에서 쿠폰값을 뺀 금액
        console.log("Final payment after coupon : ", finalPaymentAfterCoupon);                   // 확인용
        preFinalPayment.textContent = finalPaymentAfterCoupon + '원';                             // 출력

        var hiddenInput = document.createElement('input');              // 최종 결제 금액을 보내기 위해서
        hiddenInput.type = 'hidden';
        hiddenInput.name = 'totalAmount';
        hiddenInput.value = String(finalPaymentAfterCoupon);
    });
});


// selectedCoupon.addEventListener('select', function(event) {
//     var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex];          // 선택한 쿠폰의 index를 불러온다
//     var selectedCouponAmount = parseInt(selectedCouponOption.value);                 // 선택한 쿠폰 값을 저장한다
//     console.log('Selected coupon amount : ', selectedCouponAmount);
//
//     preFinalPayment.addEventListener("change", function (event) {
//
//         /* 다음으로 최종 결제 금액에서 차감을 해야하기 때문에 작성하는 코드 */
//         var finalPaymentBeforeRewSf = parseInt(preFinalPayment.textContent.replace('원', ''));
//         var finalPaymentAfterCoupon = finalPaymentBeforeRewSf - selectedCouponAmount; // 배송시를 제외한 최종 결제 금액
//
//         console.log("Final payment after coupon : ", finalPaymentAfterCoupon);
//         preFinalPayment.textContent = finalPaymentAfterCoupon + '원';
//     });
// });

// var selectedCoupon = document.getElementById('couponAmountId');        // 쿠폰 listbox의 id를 가져온다
// var preFinalPayment = document.getElementById('finalPaymentAmountId'); // 배송비, 쿠폰값 적용하기 전 금액

// selectedCoupon.addEventListener('change', function(event) {
//     console.log('Coupon selection changed');
//     var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex]; // 선택한 쿠폰의 index를 불러온다
//     console.log('Selected option : ', selectedCouponOption);
//     var selectedCouponAmount = parseInt(selectedCouponOption.value);                 // 선택한 쿠폰 값을 저장한다
//
//     /* 다음으로 최종 결제 금액에서 차감을 해야하기 때문에 작성하는 코드 */
//     var finalPaymentBeforeRewSf = parseInt(preFinalPayment.textContent.replace('원', ''));
//     var finalPaymentAfterCoupon = finalPaymentBeforeRewSf - selectedCouponAmount; // 배송시를 제외한 최종 결제 금액
//
//     console.log("Final payment after coupon : ", finalPaymentAfterCoupon);
//     preFinalPayment.textContent = finalPaymentAfterCoupon + '원';
// });




/* 7. 쿠폰을 선택을 했으면 couponCode를 넘겨서 DB에서 쿠폰 사용여부를 'y'에서 'n'으로 바꿔야 하기 때문에 작성하는 코드 */
/* user가 선택한 couponCode를 담기 위해서*/
document.addEventListener('submit', function (event) { //
    event.preventDefault();

    var selectedCoupon = document.getElementById('couponAmountId'); // 쿠폰 listbox의 id를 가져온다
    var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex];       // 선택한 쿠폰의 index를 불러온다
    var selectedCouponCode = selectedCouponOption.id;                                      // 쿠폰Code 값을 가져온다

    // couponCode를 잘 담았는지 확인할 것
    console.log('Selected coupon code : ', selectedCouponCode);

    var hiddenInput = document.createElement('input');
    hiddenInput.type = 'hidden';
    hiddenInput.name = 'couponCode';
    hiddenInput.value = selectedCouponCode;

    var form = document.getElementById('myForm'); // form tag에 적용을 하기 위해서
    form.append(hiddenInput);

    form.submit(); // couponCode를 담은 hiddenInput에 form을 보낸다..!
})



/* 쿠폰의 couAmount을 뽑아낸다 */

/* couCode를 선택을 해서 나중에 couCode 사용여부를 바꾸기 위해서 */









// var selectedCoupon = document.getElementById('couponAmountId'); // 선택한 coupon
// var selectedCouponDetails = selectedCoupon.selectedIndex;
// var selectedCouponOption = selectedCoupon.options[selectedCouponDetails];
// var selectedCouponCode = selectedCouponOption.id;
//
// console.log('Selected coupon ID:' , selectedCouponCode);
//
//
// var selectedCoupon = document.getElementById('couponAmountId');     // 쿠폰 list들
// var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex];           // list중에 선택된 coupon의 정보를 가져온다
// var selectedCouponValue = parseInt(selectedCouponOption.value);                    // 쿠폰 값을 받는다
//
// var finalAmountId = document.getElementById('finalPaymentAmountId') // 총금액 (바꾸기 위해서)
//
// let originalFinalAmount = parseInt(finalAmountId.innerText.replace('원','')); // 총금액'원'에서 원을 빼야 값을 int로 저장할 수 있다
//
// // coupon을 선택했을 때 최종 결제 금액이 바뀌겠금 event listener를 추가한다
// finalAmountId.addEventListener('change', function() { // 쿠폰을 선택을 했을 때 finalPayment을 바꿔준다
//
//     var finalAmount = originalFinalAmount - selectedCouponValue; // 총금액 - 배송비값
//     /* 배송비도 포함을 해야한다... */
//
//     finalAmountId.textContent = finalAmount + '원'; // + 바뀐 값을 출력하기 위해서 String 값
// });
//
// /* 7. 사용자가 coupon을 선택을 했을 때 coupon Code를 불러오기 위해서이다 */
// var form = document.querySelector('form'); // form을 불러온다
//
// form.addEventListener('submit', function(event) { // 결제하기를 누르면 선택한 쿠폰의 정보를 보내기 위해서이다
//     // 다른 활동들을 멈추기 위해서
//     event.preventDefault();
//
//     // var selectedOption = document.getElementById('couponAmountId').selectedOptions[0]; /* 첫번째 coupon을 선택을 했을 때 받아온 coupon에 대한 정보를 받아온다 */
//     // var couponCode = selectedOption.getAttribute('data-coupon-code'); // You may need to adjust this depending on how your coupon data is structured
//
//     var selectElement = document.getElementById('couponAmountId');
//     // var selectedOption = selectElement.options[selectElement.selectedIndex];
//     var selectedOption = selectElement.selectedOptions[0];
//     // var couponCode = selectedOption.getAttribute('id');
//     var couponCode = selectedOption.id;
//
//
// // Debugging: Log the selected coupon code
//     console.log('Selected coupon code:', couponCode);
//
//     var hiddenInput = document.createElement('input');
//     hiddenInput.type = 'hidden';
//     hiddenInput.name = 'couponCode';
//     hiddenInput.value = couponCode;
//     document.getElementById('myForm').append(hiddenInput);
// });

// Now you can submit the form with the selected coupon code
// You can do this using AJAX or by setting a hidden input field value and then submitting the form
// For example:
// var hiddenInput = document.createElement('input');
// hiddenInput.type = 'hidden';
// hiddenInput.name = 'selectedCouponCode';
// hiddenInput.value = couponCode;
// form.appendChild(hiddenInput);
// form.submit();
