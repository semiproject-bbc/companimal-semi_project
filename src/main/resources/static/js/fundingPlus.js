// function clickCate(proCateCode) {
//     console.log(proCateCode);
//
//     $.ajax({
//         type: 'GET'
//         , url: '/project/fundingPlus'
//         , data: {
//             proCateCode:proCateCode
//         }
//         , success: function() {
//         }
//     });
// }

$(document).ready(function(){
    $(".mainCategory").click(function(){
        $(".subCategory").show();
    });
});

$(document).ready(function(){
    $(".subCategory").click(function(){
        $(".subCategory").hide();
    });
});

$(document).ready(function() {

    $('.mainCategory button').on('click', function(e) {
        console.log(e);
    })

})
// function clickMainMenu(cateMain) {
//     console.log(cateMain);
//
//     $.ajax({
//         type: 'GET'
//         , url: '/project/fundingPlus'
//         , data: {
//             cateMain:cateMain
//         }
//         , success: function() {
//         }
//     });
// }