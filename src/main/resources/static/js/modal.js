let value;

function shipmentModalOpen(proCode) {
    value = proCode;
    console.log(proCode);
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
        // contentType: "application/json; charset=utf-8",
        , data: {
            'estDate' : estDate,
            'proCode' : proCode
        }
        , dataType: 'json'
        , success: function(data) {
            console.log(data);
        }
    });
}