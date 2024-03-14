// const heartButton = document.querySelector('.heart-button');
// const heartIcon = document.querySelector('.heart-gray-icon');
//
// heartButton.addEventListener('mouseover', function() {
//     heartIcon.src = '/image/heart.png';
// });
//
// heartButton.addEventListener('mouseout', function() {
//     heartIcon.src = '/image/heart-gray.png';
// });
//
// heartButton.addEventListener('click', function() {
//     if (heartIcon.src.includes('heart-gray.png')) {
//         heartIcon.src = '/image/heart.png';
//     } else {
//         heartIcon.src = '/image/heart-gray.png';
//     }
// });

$(document).ready(function toggleImg() {
    document.getElementById("img").src = "./image/heart.png";
});

$(document).ready(function () {
    console.log("ready!");
});

// $(document).ready(function Goods() {
//     this.arrAllGoods = new Array(); // 상품 목록
//     this.arrSelGoods = new Array(); // 선택 상품 목록
//
//     var p = this;
//
//     // 상품 추가 시
//     this.select = function(trgtGoodsId) {
//         var selectedIndex = -1;
//
//         for(var i= 0; i < p.arrSelGoods.length; i++) {
//             if(p.arrSelGoods[i].goodsId == trgtGoodsId) {
//                 selectedIndex = i;
//                 break;
//             }
//         }
//         if(selectedIndex < 0) {
//             for(var j = 0; j < p.arrAllGoods.length; j++) {
//                 if(p.arrSelGoods[j].goodsId == trgtGoodsId) {
//                     p.arrSelGoods.push(p.arrAllGoods[j]);
//                     p.arrSelGoods[p.arrSelGoods.length - 1].cnt = 0;
//                     p.appendChoiceDiv(p.arrAllGoods[j]);
//                     break;
//                 }
//             }
//         } else {
//             alert ("이미 추가한 상품입니다.");
//         }
//         p.afterProc();
//     }
//
//     this.deselect = function(trgtGoodsId) {
//         var selectedIndex = -1;
//
//         for(var i=0;i<p.arrSelGoods.length;i++){
//
//             if(p.arrSelGoods[i].goodsId==trgtGoodsId){
//                 p.removeChoiceDiv(p.arrSelGoods[i]);
//                 p.arrSelGoods.splice(i,1);
//                 break;
//             }
//         }
//         p.afterProc();
//     }
//
//     this.appendChoiceDiv = function(prmtObj){
//
//         var innerHtml = "";
//
//         innerHtml += '<div class="reward-choose1">';
//         innerHtml += '<span>펫슨 홈 본체 + 패브릭 매트(65 * 50 cm)</span><br>';
//         innerHtml += '<span class="op-choose">색상</span>';
//         innerHtml += '<span class="op-choose">기본</span><br>';
//         innerHtml += '<div class="count-price">';
//         innerHtml += '<div class="counts">';
//         innerHtml += '<div class="minus">-</div>';
//         innerHtml += '<div name="" class="number">1</div>';
//         innerHtml += '<div class="plus">+</div>';
//         innerHtml += '</div>';
//         innerHtml += '<div class="price">120,000원</div>';
//         innerHtml += '</div>';
//         $('#container').append(innerHtml);
//     }
//     this.removeChoiceDiv = function(prmtObj){
//         $("#div_"+prmtObj.goodsId).remove();
//     }
//
//     this.plus = function (trgtGoodsId){
//
//         for(var i=0;i<p.arrSelGoods.length;i++){
//
//             if(p.arrSelGoods[i].goodsId==trgtGoodsId){
//                 p.arrSelGoods[i].cnt++;
//                 break;
//             }
//         }
//
//
//         p.afterProc();
//     }
//
//     this.minus = function (trgtGoodsId){
//
//         for(var i=0;i<p.arrSelGoods.length;i++){
//
//             if(p.arrSelGoods[i].goodsId==trgtGoodsId){
//                 if(p.arrSelGoods[i].cnt==0) break;
//                 p.arrSelGoods[i].cnt--;
//                 break;
//             }
//         }
//
//         p.afterProc();
//     }
// })


// $(document).ready(function () {
//     const maxCount = 200;
//     let nowCount = 0;
//
//     $('.reward-1').click(function (e) {
//         e.preventDefault();
//         if(nowCount < maxCount) {
//             nowCount++;
//             $('.reward-choose-list').append(`
//             <div class="reward-choose1">
//                                 <span th:text="${ reward.rewName }">펫슨 홈 본체 + 패브릭 매트(65 * 50 cm)</span><br>
//                                 <span class="op-choose" th:text="${ rewardOpt.rewOptName }>색상</span><br>
//                                 <span class="op-choose" th:text="${ rewardOpt.rewOptVal }">기본</span><br>
//                                 <div class="count-price" >
//                                     <div class="counts">
//                                         <div class="minus">-</div>
//                                         <div name="" class="number">1</div>
//                                         <div class="plus">+</div>
//                                     </div>
//                                     <div class="price" th:text="${ rewardOpt.rewAmount }">120,000원</div>
//                                 </div>
//                             </div>
//         `);
//         }
//     });

    function remove() {
        $(this).parent('.input-list').remove();
        fieldCount--;
    };

//
// $(document).ready(function ()  {
//     document.addEventListener('DOMContentLoaded', function() {
//         const rewardLists = document.querySelectorAll('.reward-list');
//
//         rewardLists.forEach(rewardList => {
//             const rewardOptions = rewardList.querySelectorAll('.reward-1');
//
//             rewardOptions.forEach(rewardOption => {
//                 const limitCount = rewardOption.querySelector('.reward-limitCount span');
//                 const rewardBtn = document.createElement('button');
//                 rewardBtn.innerText = '장바구니에 담기';
//                 rewardBtn.addEventListener('click', function() {
//                     const remainingCount = parseInt(limitCount.innerText);
//                     if (remainingCount > 0) {
//                         limitCount.innerText = remainingCount - 1 + ' 개 남음!';
//                         // 장바구니에 상품 추가하는 AJAX 요청
//                         addToCart(rewardOption); // 해당 상품 정보를 전달하여 장바구니에 추가하는 함수 호출
//                     } else {
//                         alert('재고가 부족합니다.');
//                     }
//                 });
//
//                 rewardOption.appendChild(rewardBtn);
//             });
//         });
//
//         function addToCart(rewardOption) {
//             const rewardTitle = rewardOption.querySelector('.reward-title').innerText;
//             const rewardPrice = rewardOption.querySelector('.reward-price').innerText;
//
//             const data = {
//                 title: rewardTitle,
//                 price: rewardPrice
//                 // 필요한 상품 정보를 추가로 포함시킬 수 있습니다
//             };
//
//             fetch('/addProductToCart', {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json'
//                 },
//                 body: JSON.stringify(data)
//             })
//                 .then(response => {
//                     if (response.ok) {
//                         alert('상품이 장바구니에 추가되었습니다.');
//                     } else {
//                         alert('상품 추가에 실패했습니다.');
//                     }
//                 })
//                 .catch(error => {
//                     console.error('Error:', error);
//                 });
//         }
//
//     });
// });



