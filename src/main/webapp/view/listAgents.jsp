<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 m-3" >
        <form method="post">
            <h2>Найти Агента</h2>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group col-md-4">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname">
                </div>
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="percent">Процент с продаж</label>
                    <input type="text" class="form-control" id="percent" name="percent">
                </div>
                <div class="form-group col-md-4">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
                <div class="form-group col-md-2">
                    <label for="idAgent">id</label>
                    <input type="text" class="form-control"  id="idAgent" name="idAgent">
                </div>
            </div>

            <button type="submit" class="btn btn-primary m-2" formaction="./listAgents">найти</button>
        </form>
    </div>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Список агентов
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/AgentTempl/DTAgents.jsp"/>
                    </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#tableAgent').DataTable();
    } );
    </script>
</body>
</html>