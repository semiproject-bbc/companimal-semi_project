let value;

// 배송 예정일
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
        , dataType: 'json'
        , success: function() {
            const shipmentModal = document.getElementById('shipmentModal');

            shipmentModal.classList.remove('showmodal');
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
        , url: "/order/updatePurchaseStatus"
        , data : {
            orderCode : orderCode
        }
        , success: function() {
            const purchaseModal = document.getElementById('purchaseModal');

            purchaseModal.classList.remove('showmodal');
        }
    });
}