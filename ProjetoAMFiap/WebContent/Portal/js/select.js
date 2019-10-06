"use strict";
$(document).ready(function () {
    $(function () {
        $('select').each(function () {
            $(this).select2({
                theme: 'bootstrap4',
                width: 'style',
                allowClear: true,
                placeholder: "Choose..."
            });
        });
    });
});