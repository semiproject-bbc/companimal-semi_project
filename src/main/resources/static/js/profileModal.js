const $modals = document.getElementsByClassName('modal');
const $modalBtns = document.getElementsByClassName('modalbtn');
const $cancelBtns = document.getElementsByClassName('cancelBtn');

for(let i = 0; i < $modalBtns.length; i++) {
    $modalBtns[i].addEventListener('click', function() {
        $modals[i].classList.add('showmodal');
    })
}

for(let i = 0; i < $cancelBtns.length; i++) {
    $cancelBtns[i].addEventListener('click', function() {
        $modals[i].classList.remove('showmodal');
    })
};