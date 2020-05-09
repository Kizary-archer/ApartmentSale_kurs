$(document).ready( function () {
    var table = $('#tablehouses').DataTable();

    $('#tablehouses tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        $("#house").val(data[0].toString());

        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
});