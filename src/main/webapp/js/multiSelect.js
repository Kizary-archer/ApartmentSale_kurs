$(document).ready( function () {

    $("#formApart").submit(function(event) {
        event.preventDefault();

      var table = $('#DTApart').DataTable( {
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTApart',
                "dataSrc": "",
                "data": function ( d ) {
                    d.idApartment = $('#idApartment').val();
                    d.numberApartment = $('#numberApartment').val();
                    d.countRoom = $('#countRoom').val();
                    d.livingSpace = $('#livingSpace').val();
                    d.meterPrice = $('#meterPrice').val();
                }
            },
            "columns": [
                { "data": "idApartment" },
                { "data": "numberApartment" },
                { "data": "countRoom" },
                { "data": "livingSpace" },
                { "data": "house" },
                { "data": "apartmentOwner" },
                { "data": "meterPrice" }
            ]
        });
        $('#tableApart tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#apartment").val(data.idHouse.toString());

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
});