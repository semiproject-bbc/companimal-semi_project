// 모달 창을 가져오는 함수
var modal = document.getElementById("rejectionModal");

// 모달 창을 나타내는 함수
function showModal() {
    modal.style.display = "block";
}

// 모달 창을 닫는 함수
function closeModal() {
    modal.style.display = "none";
}

// 반려 사유를 컨트롤러로 전송하는 함수
function sendRejectionReason() {
    let evaNum = document.getElementById("hiddenDiv").textContent;
    let reaRejection = document.getElementById("reaRejection").value;

    // AJAX 요청 보내기
    $.ajax({
        type: "GET",
        url: "/evaluation/manager/return",
        data: {evaNum: evaNum, reaRejection: reaRejection},
        success: function () {
            window.location.href = "/evaluation/evaluationProcessAfter";
        },
        error: function () {
            $('#modalText').text("요청을 보내는 동안 오류가 발생했습니다");
            $('#myModal').show();
        }
    });
}

// 반려 버튼 클릭 시 모달 창을 표시하는 이벤트 핸들러 설정
var returnButton = document.querySelector(".return");
returnButton.addEventListener("click", showModal);

// 모달 창의 닫기 버튼에 이벤트 핸들러 설정
var closeButton = document.querySelector(".close");
closeButton.addEventListener("click", closeModal);

// 모달 창의 반려 버튼에 이벤트 핸들러 설정
var submitButton = document.getElementById("submitRejection");
submitButton.addEventListener("click", sendRejectionReason);