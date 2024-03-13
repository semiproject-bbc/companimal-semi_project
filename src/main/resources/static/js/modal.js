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
        type: 'POST'
        , url: "/project/updateShipment"
        // contentType: "application/json; charset=utf-8",
        , data: {
            'estDate' : estDate,
            'proCode' : proCode
        }
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
    // console.log(proCode);
    //
    // let nowDate = new Date();
    // let month;
    // let day;
    // let hour;
    // let minute;
    // let second;
    // if((nowDate.getMonth() + 1) < 10) {
    //     month = '0' + (nowDate.getMonth() + 1)
    // }else {
    //     month = nowDate.getMonth() + 1;
    // }
    // if(nowDate.getDay < 10) {
    //     day = '0' + nowDate.getDay();
    // }else {
    //     day = nowDate.getDay();
    // }
    // if(nowDate.getHours() < 10) {
    //     hour = '0' + nowDate.getHours();
    // }else {
    //     hour = nowDate.getHours();
    // }
    // if(nowDate.getMinutes < 10) {
    //     minute = '0' + nowDate.getMinutes();
    // }else {
    //     day = nowDate.getMinutes();
    // }
    // if(nowDate.getSeconds < 10) {
    //     second = '0' + nowDate.getSeconds();
    // }else {
    //     second = nowDate.getSeconds();
    // }
    //
    // let purchaseDate = nowDate.getFullYear()
    //             + "-" + month
    //             + "-" + day
    //             + " " + nowDate.getHours()
    //             + ":" + nowDate.getMinutes()
    //             + ":" + nowDate.getUTCSeconds();
    // console.log(purchaseDate);
    //
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