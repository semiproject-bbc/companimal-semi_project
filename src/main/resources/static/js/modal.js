// 배송 예정일
let value;

function shipmentModalOpen(proCode) {
    value = proCode;
    const shipmentModal = document.getElementById('shipmentModal');

    shipmentModal.classList.add('showmodal');
}

function shipmentModalClose() {
    const shipmentModal = document.getElementById('shipmentModal');

    shipmentModal.classList.remove('showmodal');
}

function updateShipment() {
    var proCode = value;
    console.log(proCode);

    var estDate = $('#shipmentValue').val().replaceAll('.', '-');
    console.log(estDate);

    $.ajax({
        type: 'post'
        , url: "/project/updateShipment"
        , data: {
            'estDate' : estDate,
            'proCode' : proCode
        }
        , success: function() {
            location.reload();
        }
    });
}

// 구매 확정
var purchaseValue;
function purchaseModalOpen(orderCode) {
    purchaseValue = orderCode;
    console.log(orderCode);
    const purchaseModal = document.getElementById('purchaseModal');

    purchaseModal.classList.add('showmodal');
}

function purchaseModalClose() {
    const purchaseModal = document.getElementById('purchaseModal');

    purchaseModal.classList.remove('showmodal');
}

function updatePurchase() {
    var orderCode = purchaseValue;

    $.ajax({
        type: 'POST'
        , url: "/member/updatePurchaseStatus"
        , data : {
            orderCode : orderCode
        }
        , success: function() {
            location.reload();
        }
    });
}

// 최종 정산 승인 신청
var finalCalProCode;
function calModalOpen(proCode) {
    finalCalProCode = proCode;
    console.log("최종 정산 승인 신청 프로젝트 번호 : " + proCode);
    const finalCalModal = document.getElementById('finalCalModal');

    finalCalModal.classList.add('showmodal');
}

function finalCalModalClose() {
    const finalCalModal = document.getElementById('finalCalModal');

    finalCalModal.classList.remove('showmodal');
}

function insertCalculationList() {
    var proCode = finalCalProCode;

    $.ajax({
        type: 'POST'
        , url: "/project/insertCalculationList"
        , data: {
            proCode : proCode,
        }
        , success: function() {
            location.reload();
        }
    });
}

// 후원금 최종 정산 심사
var evaCalProCode;
function evaCalModalOpen(proCode) {
    evaCalProCode = proCode;
    console.log(proCode);
    const evaCalModal = document.getElementById('evaCalModal');

    evaCalModal.classList.add('showmodal');
}

function evaCalModalClose() {
    const evaCalModal = document.getElementById('evaCalModal');

    evaCalModal.classList.remove('showmodal');
}

function updateCalAppDate() {
    var proCode = evaCalProCode;

    $.ajax({
        type: 'POST'
        , url: "/evaluation/updateCalAppDate"
        , data : {
            proCode : proCode
        }
        , success: function() {
            location.reload();
        }
    });
}