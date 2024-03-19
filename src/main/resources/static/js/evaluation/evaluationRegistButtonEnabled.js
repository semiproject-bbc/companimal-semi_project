function checkFormValidity() {
    console.log("Checking form validity...");

    var allInputsFilled = true;

    // 입력 필드들을 확인하여 값이 있는지 확인
    $('.creatorEvaluationInput').each(function() {
        if ($(this).val() === '') {
            allInputsFilled = false;
            return false; // 각 입력 필드를 순회하다가 값이 비어있으면 반복문 종료
        }
    });

    // 파일 업로드 필드들을 확인하여 값이 있는지 확인
    $('input[type="file"]').each(function() {
        if ($(this).get(0).files.length === 0) {
            allInputsFilled = false;
            return false; // 각 파일 업로드 필드를 순회하다가 파일이 업로드되지 않았으면 반복문 종료
        }
    });

    // 모든 입력 필드와 파일 업로드 필드에 값이 있으면 버튼 활성화
    if (allInputsFilled) {
        $('#submitButton').removeClass('disabled').addClass('enabled');
        $('#submitButton').prop('disabled', false);
    } else {
        $('#submitButton').addClass('disabled').removeClass('enabled');
        $('#submitButton').prop('disabled', true);
    }
}


// 입력 필드나 파일 업로드 필드의 값이 변경될 때마다 확인 함수 호출
$('.creatorEvaluationInput, input[type="file"]').on('change', function() {
    checkFormValidity();
});