document.addEventListener("DOMContentLoaded", function() {
    // 약관 전체 동의 체크박스
    const selectAllCheckbox = document.getElementById('selectAll');

    // 각각의 약관 체크박스
    const individualCheckboxes = document.querySelectorAll('.individualCheckbox');

    // 약관 전체 동의 체크박스가 변경될 때 발생하는 이벤트
    selectAllCheckbox.addEventListener('change', function() {
        const isChecked = selectAllCheckbox.checked;

        // 각각의 약관 체크박스 상태 변경
        individualCheckboxes.forEach(function(checkbox) {
            checkbox.checked = isChecked;
        });
    });

    // 각각의 약관 체크박스가 변경될 때 발생하는 이벤트
    individualCheckboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            const allChecked = Array.from(individualCheckboxes).every(function(cb) {
                return cb.checked;
            });
            // 약관 전체 동의 체크박스 상태 변경
            selectAllCheckbox.checked = allChecked;
        });
    });
});
