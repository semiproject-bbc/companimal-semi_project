function rejectModalOpen() {
    const rejectModal = document.getElementById('rejectModal');

    rejectModal.classList.add('showmodal');

    // updateProjectEvaReject();
}

function updateProjectEvaReject() {
    let evaNum = document.getElementById("evaNum").innerText;
    let reaRejection = document.getElementById("reaRejection").value;

    $.ajax({
        type: 'GET'
        , url: "/evaluation/updateProjectEvaReject"
        , data: {
            evaNum: evaNum
            ,reaRejection: reaRejection
        }
        ,success: function () {
            window.location.href = "/evaluation/projectEvaluationList";
        }
    });
}

function rejectModalClose() {
    const rejectModal = document.getElementById('rejectModal');

    rejectModal.classList.remove('showmodal');
}

function approveModalOpen() {
    const approveModal = document.getElementById('approveModal');

    approveModal.classList.add('showmodal');

    updateProjectEva();

}
function updateProjectEva() {
    let evaNum = document.getElementById("evaNum").innerText;

    $.ajax({
        type: 'GET'
        , url: "/evaluation/updateProjectEva"
        , data: {
            evaNum : evaNum
        }
        ,success: function () {
            window.location.href = "/evaluation/projectEvaluationList";
        }
    });
}

function approveModalClose() {
    const approveModal = document.getElementById('approveModal');

    approveModal.classList.remove('showmodal');
}