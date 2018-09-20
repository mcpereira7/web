$(document).ready(function () {
    console.log("Hello World, Olá mundo!");

    $("#pmin").on('input', function () {
        let min = $("#pmin").val();
        $('#minimo').html(min);
        console.log(`preço minimo: ${min}`);
    });
});
