"use strict";
$(document).ready(function() {
    var elemmedium = document.querySelector('.js-small');
    var switchery = new Switchery(elemmedium, {
        color: '#4099ff',
        jackColor: '#fff',
        size: 'small'
    });
});