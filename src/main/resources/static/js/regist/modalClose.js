$('.close').click(function() {
    $('#myModal').hide(); // 모달 창 숨기기
});

// 모달 창 바깥 영역 클릭 시 모달 창 숨기기
$(window).click(function(e) {
    if ($(e.target).is('#myModal')) {
        $('#myModal').hide();
    }
});