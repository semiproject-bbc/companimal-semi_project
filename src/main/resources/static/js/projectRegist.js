
/* 등록 시 모든 1페이지 외 모든 페이지 안보이게하는 js */
window.onload = function () {

    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "none";
}

/* summernote 설정 js */
// $(document).ready(function (){
//     $('#summernote').summernote('insertText');
//     $('#summernote').summernote('disable');
//     $('#summernote').summernote('enable');
//     $('#summernote').summernote('reset');
//     $('#summernote').summernote('undo');
//     $('#summernote').summernote('redo');
// });



/* 등록 시 이전, 다음 버튼으로 페이지 이동하는 것처럼 보이는 화면 구현 js */
function regist1() {

    document.getElementById("regist1").style.display = "flex";
    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "none";
};

function regist2() {

    document.getElementById("regist1").style.display = "none";
    document.getElementById("regist2").style.display = "flex";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "none";
};

function regist3() {

    document.getElementById("regist1").style.display = "none";
    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "flex";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "none";
};

function regist4() {

    document.getElementById("regist1").style.display = "none";
    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "flex";
    document.getElementById("regist5").style.display = "none";
};

function regist5() {

    document.getElementById("regist1").style.display = "none";
    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "flex";
};

/* regist side-bar 버튼 안눌리게 하는 설정 */
$(document).ready(function () {
    $('#side1').attr('disabled', true);
    $('#side2').attr('disabled', true);
    $('#side3').attr('disabled', true);
    $('#side4').attr('disabled', true);
    $('#side5').attr('disabled', true);
});

/* 리워드 옵션 추가시 동작하는 js */
$(document).ready(function () {
    const maxFields = 11;
    let fieldCount = 1;

    $('#plus').click(function adding(e) {
        e.preventDefault();
        if(fieldCount < maxFields) {
            fieldCount++;
            $('#input-wrap').append(`
        <div class="input-list" id="input-list">
            <input name="rewOptName" type="text" class="input-number" placeholder="옵션 (예시 : 색상)">
            <input name="rewOptLimit" type="text" class="input-number" placeholder="제한 수량">
            <input name="rewAmount" type="text" class="input-number" placeholder="리워드 금액">
            <input name="rewOptVal" type="text" class="input-value" placeholder="옵션값 (예시 : 블랙, 화이트, 레드)">
            <button type="button" class="plus" id="plus">+</button>
            <button type="button" class="remove">x</button><br>
        </div>
        `);
        }
    });

        const removeBtns = document.querySelectorAll('.remove');
        removeBtns.forEach(btn => {
            btn.addEventListener('click', function () {
                const parentDiv = this.parentElement;
                parentDiv.remove();
            });
        });

        fieldCount--;
});

/* 시작, 종료일 지정 js */
const startDateInput = document.getElementById('startDateInput');
const endDateInput = document.getElementById('endDateInput');
const regist = document.getElementById('regist');
startDateInput.addEventListener('change', function() {
    // 사용자가 선택한 날짜
    const selectedDate = startDateInput.value;
    console.log('사용자가 선택한 시작 날짜:', selectedDate);
});

endDateInput.addEventListener('change', function() {
    // 사용자가 선택한 날짜
    const selectedDate = endDateInput.value;
    console.log('사용자가 선택한 종료 날짜:', selectedDate);
});

// 전송 버튼 클릭 시 서버로 선택한 날짜 전송
regist.addEventListener('click', function() {
    const selectedDate = startDateInput.value;
    // AJAX 요청을 통해 서버로 선택한 날짜 전송
    const xhr = new XMLHttpRequest();
    xhr.open('POST'
            , '/project/projectRegist'
            , true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    // 서버로 보낼 데이터 설정
    const data = JSON.stringify({ startDate: selectedDate });

    xhr.send(data);

    // 서버 응답 처리
    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 400) {
            console.log('서버 응답:', xhr.responseText);
        } else {
            console.error('서버 오류 발생');
        }
    };
});


/* 리워드 추가 버튼 클릭 시 리워드 리스트 입력칸 추가되는 js */
$(document).ready(function () {
        // 버튼 요소
        const btnReward = document.querySelector('.btn-reward');
        // 부모 컨테이너 요소
        const rewardContainer = document.getElementById('reward-container');
        // 인덱스 변수 초기화
        let index = 0;

        // 리워드 추가 버튼 클릭 시 동적으로 필드 추가
        btnReward.addEventListener('click', function() {
        index++; // 인덱스 증가

        // 새로운 리워드 입력 필드 생성
        const newRewardDiv = document.createElement('div');
        newRewardDiv.classList.add('input-wrap');
        newRewardDiv.setAttribute('data-index', index);

        newRewardDiv.innerHTML = `
            <p class="sub-title">리워드 추가</p>
            <input name="rewardList[${index}].rewName" type="text" class="input-name" placeholder="리워드명 (최대 30자)">
            <input name="rewardList[${index}].rewSf" type="number" class="input-number" placeholder="배송비"><br>
            <br>
            <textarea name="rewardList[${index}].rewExplain" class="input-text" placeholder="리워드 설명 (최대 50자)"></textarea>
            <div class="option-add">
                <div class="input-list" id="input-list-${index}">
                    <input name="rewardList[${index}].rewardOpt[0].rewOptName" type="text" class="input-number" placeholder="옵션 (예시 : 색상)">
                    <input name="rewardList[${index}].rewardOpt[0].rewOptLimit" type="text" class="input-number" placeholder="제한 수량">
                    <input name="rewardList[${index}].rewardOpt[0].rewAmount" type="text" class="input-number" placeholder="리워드 금액">
                    <input name="rewardList[${index}].rewardOpt[0].rewOptVal" type="text" class="input-value" placeholder="옵션값 (예시 : 블랙, 화이트, 레드)">
                </div>
                <button type="button" class="plus" id="plus-${index}">+</button>
            </div>
        `;

        rewardContainer.appendChild(newRewardDiv);
    });

        // 부모 컨테이너에 이벤트 위임하여 '+' 버튼 클릭 시 옵션 추가
        rewardContainer.addEventListener('click', function(e) {
        if (e.target.classList.contains('plus')) {
        const index = e.target.id.split('-')[1];
        const inputList = document.getElementById(`input-list-${index}`);
        const newOptionDiv = document.createElement('div');
        newOptionDiv.innerHTML = `
                <input name="rewardList[${index}].rewardOpt[${inputList.children.length}].rewOptName" type="text" class="input-number" placeholder="옵션 (예시 : 색상)">
                <input name="rewardList[${index}].rewardOpt[${inputList.children.length}].rewOptLimit" type="text" class="input-number" placeholder="제한 수량">
                <input name="rewardList[${index}].rewardOpt[${inputList.children.length}].rewAmount" type="text" class="input-number" placeholder="리워드 금액">
                <input name="rewardList[${index}].rewardOpt[${inputList.children.length}].rewOptVal" type="text" class="input-value" placeholder="옵션값 (예시 : 블랙, 화이트, 레드)">
            `;
        inputList.appendChild(newOptionDiv);
    }
    });

});



