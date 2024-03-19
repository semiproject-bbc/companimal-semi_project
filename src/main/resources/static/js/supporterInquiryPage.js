/* listbox에서 category를 선택을 하면 */


document.addEventListener("DOMContentLoaded", function() {
    var selectedOption = document.getElementById('optionList');

    // 문의를 보낼때 카테고리코드, 카테고리이름을 보내기 위해서
    selectedOption.addEventListener('change', function(event) {

        var selectedValue = selectedOption.options[selectedOption.selectedIndex];
        var selectedOptionRealValue = parseInt(selectedValue.value);
        console.log('Selected option value : ', selectedOptionRealValue); // 확인용

        var selectedOptionName = "";
        if (selectedOptionRealValue === 1) {
            selectedOptionName = "교환";
        } else if (selectedOptionRealValue === 2) {
            selectedOptionName = "환불";
        } else if (selectedOptionRealValue === 3) {
            selectedOptionName = "질문";
        } else {
            alert("문의 카테고리를 선택해주세요.");
        }
        console.log('Selected inquiry category : ', selectedOptionName); // 확인용

        var sendForm = document.getElementById('myForm');
        sendForm.addEventListener("submit", function(event) {
            event.preventDefault();
            var inputtedText = document.getElementById('textContext').value;
            console.log(inputtedText); // 입력한 값들 확인용

            var hiddenInput = document.createElement('input');
            hiddenInput.type = 'hidden';
            hiddenInput.name = 'inputtedText';
            hiddenInput.value = String(inputtedText);

            sendForm.append(hiddenInput);
            sendForm.querySelector('[name="inqCateName"]').value = selectedOptionName;      // InquiryData로 정보를 바로 보내기 위해서
            sendForm.querySelector('[name="inqCateCode"]').value = selectedOptionRealValue;

            sendForm.submit();
        });
    });
});

// document.addEventListener('DOMContentLoaded', function() {
//     var selectedCoupon = document.getElementById('couponAmountId');         // 쿠폰을 선택할 때 id
//     var preFinalPayment = document.getElementById('finalPaymentAmountId');  // 최종 결제 금액 id
//     // var rewSf = 2500;
//
//     selectedCoupon.addEventListener('change', function(event) {   // 왜 select가 아닌지
//         var selectedCouponOption = selectedCoupon.options[selectedCoupon.selectedIndex];    // 선택한 쿠폰 정보를 가져온다
//         var selectedCouponAmount = parseInt(selectedCouponOption.value);           // 선택한 쿠폰값을 가져온다
//         console.log('Selected coupon amount:', selectedCouponAmount);                       // couponAmount를 잘 선택을 했는지 확인하는 용도
//
//         /* 쿠폰 할인을 뺀 최종 결제 금액값  */
//         var finalPaymentBeforeRewSf = parseInt(preFinalPayment.textContent.replace('원', ''));
//         var finalPaymentAfterCoupon = finalPaymentBeforeRewSf - selectedCouponAmount;    // 최종금액에서 쿠폰값을 뺀 금액
//         console.log("Final payment after coupon : ", finalPaymentAfterCoupon);                   // 확인용
//         preFinalPayment.textContent = finalPaymentAfterCoupon + '원';                             // 출력
//
//         var hiddenInput = document.createElement('input');              // 최종 결제 금액을 보내기 위해서
//         hiddenInput.type = 'hidden';
//         hiddenInput.name = 'totalAmount';
//         hiddenInput.value = String(finalPaymentAfterCoupon);
//
//         var form = document.getElementById('myForm');
//         form.append(hiddenInput);
//     });
// });


// document.addEventListener("DOMContentLoaded", function() {
//     var form = document.getElementById('myForm'); // 안에 있는 전체 내용
//     form.addEventListener("submit", function(event) {
//         event.preventDefault(); // 모든 것들이 이루어져야 내용이 보내진다
//
//         var formData = new FormData(form); // form data를 전부 모은다
//
//
//     });
// });

