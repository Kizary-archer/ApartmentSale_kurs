<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="w-50 m-3" >
        <form method="post">
            <h2>Добавить клиента</h2>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder=${client.name}>
                </div>
                <div class="form-group col-md-6">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname" placeholder=${client.surname}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic" placeholder=${client.patronymic}>
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
                    <input type="text" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder=${client.dateOfBirth}>
                </div>
                <div class="form-group col-md-6">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder=${client.phoneNumber}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idClient">id</label>
                    <input type="text" class="form-control" id="idClient" name="idClient" placeholder=${client.idClient} disabled>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder=${client.email}>
            </div>
            <button type="submit" class="btn btn-primary">Обновить</button>
            <button type="button" class="btn btn-primary m-3">Удалить</button>
            <button type="button" class="btn btn-primary">Добавить</button>

        </form>
    </div>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Документы клиента
                    </button>
                    <button class="btn mx-3" type="button">
                       Добавить документы клиента
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTDocumentsClient.jsp"/>
                    </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header bg-success" id="headingTwo"  data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Квартиры клиента
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse multi-collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTApartClient.jsp"/>
                </div>
            </div>
        </div>
        <div class="card" >
            <div class="card-header bg-info" id="headingThree"  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Проданные квартиры клиента
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTApartSaleClient.jsp"/>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header bg-success" id="headingFour" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Поиск квартир
                    </button>
                </h5>
            </div>
            <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTApartSearchClient.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#tableApart,#tableDocum,#tableApartSale,#tableApartSearch').DataTable();
    } );
    </script>
</body>
</html>