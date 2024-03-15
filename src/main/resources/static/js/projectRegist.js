
/* 등록 시 모든 1페이지 외 모든 페이지 안보이게하는 js */
window.onload = function () {

    document.getElementById("regist2").style.display = "none";
    document.getElementById("regist3").style.display = "none";
    document.getElementById("regist4").style.display = "none";
    document.getElementById("regist5").style.display = "none";
}

/* summernote 설정 js */
$(document).ready(function (){

    $('#summernote').summernote({
        placeholder: '안녕하세요. 스토리 작성을 시작한 크리에이터님 환영해요!\n&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;' +
            '쉽게 작성할 수 있도록 안내 문구를 제공하고 있어요!\n&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;' +
            '\n&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;' +
            '*스토리를 모두 작성하셨다면,\n' +
            ' 제출 전 안내 문구들을 반드시 지워주세요!\n' +
            '\n' +
            '*스토리는 최대 5000자 작성가능합니다.\n' +
            '\n' +
            '이 프로젝트를 준비하게 된 배경\n' +
            '• 후원금을 모금하는 목적, 제품을 준비하게 된 배경에 대해 설명해주세요.\n' +
            '\n' +
            '이번에 선보이는 프로젝트의 스토리\n' +
            '• 해당 프로젝트의 핵심 목표와 준비한 리워드에 대해 설명해주세요.\n' +
            '• 리워드의 사진을 보여주며 설명해주세요.\n' +
            '• 다른 제품과의 차별점을 설명해주세요.\n' +
            '\n' +
            '크리에이터 소개\n' +
            '• 크리에이터님에 대한 소개글을 작성해주세요.\n' +
            '\n' +
            '컴패니멀을 선택한 이유\n' +
            '• 많은 크라우드 펀딩 서비스 중 컴패니멀에서 프로젝트를 진행하는 이유를 알려주세요.\n' +
            '\n' +
            '스토리를 모두 작성했다면 [다음] 버튼을 눌러 추가 정보들을 작성해주세요.',
        tabsize: 2,
        height: 500,
        toolbar: [
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
            ['color', ['forecolor', 'color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']]
        ],
        fontNames: ['Arial',
            'Arial Black',
            'Comic Sans MS',
            'Courier New',
            '맑은 고딕',
            '궁서',
            '굴림체',
            '굴림',
            '돋움체',
            '바탕체'],
        fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18',
            '20', '22', '24', '26', '28',
            '30', '36', '46', '50', '72']
    });

    $('#summernote').summernote('insertText');
    $('#summernote').summernote('disable');
    $('#summernote').summernote('enable');
    $('#summernote').summernote('reset');
    $('#summernote').summernote('undo');
    $('#summernote').summernote('redo');
});

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

/* summernote 에디터 저장 js */
$(document).ready(function () {
    $('#summernote').summernote({
        height: 500,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
        callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload: function (files, editor, welEditable) {
                for(var i = files.length - 1; i--;) {
                    uploadSummernoteImageFile(files[i], this);
                }
            },
            onPaste: function (e) {
                var clipboardData = e.originalEvent.clipboardData;
                if (clipboardData && clipboardData.items && clipboardData.items.length) {
                    var item = clipboardData.items[0];
                    if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                        e.preventDefault();
                    }
                }
            }
        }
    });
});

/**
 * 이미지 파일 업로드
 */
function uploadSummernoteImageFile(file, editor) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data: data,
        type: "POST",
        url: "/uploadSummernoteImageFile",
        // dataType: "JSON",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        success: function (data) {
            //항상 업로드된 파일의 url이 있어야 한다.
            $(editor).summernote('insertImage', data.url);
        }
    });
};

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



