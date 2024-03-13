function uploadFile() {
    let fullPath = $('#fileInput').val();
    let fileName = fullPath.split('\\').pop();
    $('.productPlanInput').val(fileName);
}

function uploadFile2() {
    let fullPath = $('#fileInput2').val();
    let fileName = fullPath.split('\\').pop();
    $('.productPortfolioInput').val(fileName);
}

function uploadFile3() {
    let fullPath = $('#fileInput3').val();
    let fileName = fullPath.split('\\').pop();
    $('.creatorImgInput').val(fileName);
}