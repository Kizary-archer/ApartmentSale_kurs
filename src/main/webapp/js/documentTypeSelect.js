$(document).ready( function () {
    $('#tableDocumentType').DataTable();
    $('tr').bind('click', function(){
        var id = $(this).find($("td:first-child")).text();
        $("#typeDocument").val('' + id);
    });

    $('td').bind('click', function(){$("#btnAccord1").click();});
});