$(document).ready( function () {
    $('#tablehouses').DataTable();
    $('tr').bind('click', function(){
        var id = $(this).find($("td:first-child")).text();
        $("#house").val(id.toString());
    });

    $('td').bind('click', function(){$("#btnAccord1").click();});
});