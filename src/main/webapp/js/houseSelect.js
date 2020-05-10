$(document).ready( function () {




    $("#formSearchHouse").submit(function(event) {
        event.preventDefault();
        var res;
        var formData = $("#formSearchHouse").serialize();
       /*  $.post('./searchHouse',formData,function(data) {
            res = jQuery.parseJSON(data);

        });*/


        $('#tablehouses').DataTable( {
            'processing': true,
            'serverSide': true,
            'ajax': {
                'type': 'POST',
                'url': './searchHouse',
                "dataSrc": ""

            },
            "columns": [
                { "data": "idHouse" },
                { "data": "numberHouse" },
                { "data": "nameSeries" },
                { "data": "nameStreet" },
                { "data": "nameDistrict" },
                { "data": "nameCity" }
            ]
        });
    });
   /* var table = $('#tablehouses').DataTable();

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
    });*/
});