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

    function remove() {
        $(this).parent('.input-list').remove();
        fieldCount--;
    };


function func1 (event) {
    const eventDiv = event.currentTarget;
    const rewName = eventDiv.getElementsByClassName('reward-title')[0].innerHTML;
    const rewOpt = eventDiv.getElementsByClassName('reward-option')[0].innerHTML;
    const rewValue = eventDiv.getElementsByClassName('reward-value')[0].innerHTML;
    const rewOptAmount = eventDiv.getElementsByClassName('reward-price')[0].innerHTML;

    let rewardExists = false;


    $(".reward-choose-list .title-choose").each(function() {
        if ($(this).text() === rewName && $(this).next().text() === rewOpt && $(this).next().next().text() === rewValue) {
            rewardExists = true;
            return false; // Exit the loop early
        }
    });

    if (!rewardExists) {
        $(".reward-choose-list").append(
            "<div class=\"reward-choose1\">" +
            "<span class=\"title-choose\">" + rewName + "</span><br>" +
            "<span class=\"op-choose\">" + rewOpt + " : </span>" +
            "<span class=\"op-choose\">" + rewValue + "</span>" +
            "<div class=\"count-price\">" +
            "<div class=\"counts\">" +
            "<div class=\"minus\">-</div>" +
            "<div class=\"number\" name='noOfOrder'>1</div>" +
            "<div class=\"plus\">+</div>" +
            "</div>" +
            "<div class=\"price\" name='orderAmount'>" + rewOptAmount + " 원</div>" +
            "</div>" +
            "</div><br>"
        );

        updateTotalAmount();

        $(this).off('click'); // Disable click on current reward-1
    }
};


$(document).ready(function () {

    // $(".reward-1").click(func1 (event));


    $(document).on("click", ".minus", function minus() {
        let quantityElement = $(this).siblings('.number');
        let currentQuantity = parseInt(quantityElement.text());

        if (currentQuantity > 0) {
            quantityElement.text(currentQuantity - 1);

            if (currentQuantity - 1 === 0) {
                $(this).closest(".reward-choose1").remove();
                $(".reward-1").on('click', func1(this)); // Enable clicking on reward-1 again
            }

            updateTotalAmount();
        }
    });

    $(document).on("click", ".plus", function plus() {
        let quantityElement = $(this).siblings('.number');
        let currentQuantity = parseInt(quantityElement.text());
        quantityElement.text(currentQuantity + 1);

        updateTotalAmount();
    });
});




$(document).ready(function () {

    $(".reward-1").click(function (event) {
        const eventDiv = event.currentTarget;
        const rewName = eventDiv.getElementsByClassName('reward-title')[0].innerHTML;
        const rewOpt = eventDiv.getElementsByClassName('reward-option')[0].innerHTML;
        const rewValue = eventDiv.getElementsByClassName('reward-value')[0].innerHTML;
        const rewOptAmount = eventDiv.getElementsByClassName('reward-price')[0].innerHTML;

        let rewardExists = false;


        $(".reward-choose-list .title-choose").each(function() {
            if ($(this).text() === rewName && $(this).next().text() === rewOpt && $(this).next().next().text() === rewValue) {
                rewardExists = true;
                return false; // Exit the loop early
            }
        });

        if (!rewardExists) {
            $(".reward-choose-list").append(
                "<div class=\"reward-choose1\">" +
                "<span class=\"title-choose\">" + rewName + "</span><br>" +
                "<span class=\"op-choose\">" + rewOpt + " : </span>" +
                "<span class=\"op-choose\">" + rewValue + "</span>" +
                "<div class=\"count-price\">" +
                "<div class=\"counts\">" +
                "<div class=\"minus\">-</div>" +
                "<div class=\"number\" name='noOfOrder'>1</div>" +
                "<div class=\"plus\">+</div>" +
                "</div>" +
                "<div class=\"price\" name='orderAmount'>" + rewOptAmount + " 원</div>" +
                "</div>" +
                "</div><br>"
            );

            updateTotalAmount();

            $(this).off('click'); // Disable click on current reward-1
        }
    });


    $(document).on("click", ".minus", function() {
        let quantityElement = $(this).siblings('.number');
        let currentQuantity = parseInt(quantityElement.text());

        if (currentQuantity > 0) {
            quantityElement.text(currentQuantity - 1);

            if (currentQuantity - 1 === 0) {
                $(this).closest(".reward-choose1").remove();
                $(".reward-1").on('click', function() {

                }); // Enable clicking on reward-1 again
            }

            updateTotalAmount();
        }
    });

    $(document).on("click", ".plus", function() {
        let quantityElement = $(this).siblings('.number');
        let currentQuantity = parseInt(quantityElement.text());
        quantityElement.text(currentQuantity + 1);

        updateTotalAmount();
    });
});






