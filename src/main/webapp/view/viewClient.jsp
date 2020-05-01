<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="patt/header.jsp"/>
<div>
    <div class="w-50 p-3" >
        <h2>Добавить клиента</h2>
        <form method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" placeholder=${client.name}>
                </div>
                <div class="form-group col-md-6">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname"placeholder=${client.surname}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic"placeholder=${client.patronymic}>
                </div>
                <div class="form-group col-md-4">
                    <label for="gender">Пол</label>
                    <select id="gender" class="form-control" onselect="{client.gender}">
                        <option value="true" >мужчина</option>
                        <option value="false">женщина</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfBirth">Дата Рождения</label>
                    <input type="text" class="form-control" id="dateOfBirth" name="date" placeholder=${client.dateOfBirth}>
                </div>
                <div class="form-group col-md-6">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" placeholder=${client.phoneNumber}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idClient">id</label>
                    <input type="text" class="form-control" id="idClient" placeholder=${client.idClient}>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" placeholder=${client.email}>
            </div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>
    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Разворачиваемая панель #1
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">
                    <jsp:include page="patt/DTDocumentsClient.jsp"/>
                    </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header bg-success" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Разворачиваемая панель #2
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
                    <jsp:include page="patt/DTApartClient.jsp"/>
                </div>
            </div>
        </div>
        <div class="card" >
            <div class="card-header bg-info" id="headingThree">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Разворачиваемая панель #3
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                <div class="card-body">
                    <jsp:include page="patt/DTApartSaleClient.jsp"/>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header bg-success" id="headingFour">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Разворачиваемая панель #4
                    </button>
                </h5>
            </div>
            <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                <div class="card-body">
                    <jsp:include page="patt/DTApartSearchClient.jsp"/>
                </div>
            </div>
        </div>
    </div>

    <button onclick="location.href='./'">Back to main</button>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#tableApart,#tableDocum,#tableApartSale,#tableApartSearch').DataTable();
    } );
    </script>
</body>
</html>