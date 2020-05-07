<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="w-50 p-3" >
        <h2>Добавить документ клиента</h2>
        <form method="post">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="series">Серия</label>
                    <input type="text" class="form-control" id="series" name="series" value=${documentEntity.series}>
                </div>
                <div class="form-group col-md-6">
                    <label for="number">Номер</label>
                    <input type="text" class="form-control" id="number" name="number" value=${documentEntity.number}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="issued">Выдан:</label>
                    <input type="text" class="form-control" id="issued" name="issued" value=${documentEntity.issued}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfIssue">Дата выдачи</label>
                    <input type="date" class="form-control" id="dateOfIssue" name="dateOfIssue" value=${documentEntity.dateOfIssue}>
                </div>
                <div class="form-group col-md-3">
                    <label for="idClient">id клиента</label>
                    <input type="text" class="form-control" id="idClient" name="idClient" readonly value=${documentEntity.client}>
                </div>
            </div>
            <button id="b1" type="submit" class="btn btn-primary" >Добавить</button>
        </form>
    </div>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Тип документа
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/DocumentTempl/DTDocumentType.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready( function () {
        $('#tableDocumentType').DataTable();
    } );
</script>
</body>
</html>