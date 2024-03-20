// 각 term 체크박스들과 selectAll 체크박스의 DOM 요소들을 가져옴
var termCheckboxes = document.querySelectorAll('.termCheckbox');
var selectAllCheckbox = document.getElementById('selectAll');

// 각 term 체크박스의 변경 이벤트에 대한 핸들러 등록
termCheckboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
        updateSelectAllCheckbox();
    });
});

// selectAll 체크박스의 변경 이벤트에 대한 핸들러 등록
selectAllCheckbox.addEventListener('change', function() {
    updateTermCheckboxes(this.checked);
    if (this.checked) {
        updateStatus('termsChecked', true);
        console.log('true')
    } else {
        updateStatus('termsChecked', false);
        console.log('false')
    }
});

// selectAll 체크박스 상태에 따라 term 체크박스들의 상태 업데이트
function updateTermCheckboxes(checked) {
    termCheckboxes.forEach(function(checkbox) {
        checkbox.checked = checked;
    });
}

// term 체크박스 상태에 따라 selectAll 체크박스의 상태 업데이트
function updateSelectAllCheckbox() {
    var allChecked = true;
    termCheckboxes.forEach(function(checkbox) {
        if (!checkbox.checked) {
            allChecked = false;
        }
    });
    if (allChecked) {
        selectAllCheckbox.checked = allChecked;

        // 전체 약관
        updateStatus('termsChecked', true);
        console.log('true');
    } else {
        selectAllCheckbox.checked = allChecked;
        updateStatus('termsChecked', false);
        console.log('false')
    }

}


// 초기 상태 업데이트
updateSelectAllCheckbox();
