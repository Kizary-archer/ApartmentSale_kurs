<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="p-3">
        <h2>Новая сделка</h2>
        <div class="w-50 p-3" >
            <form method="post" id = "formApartSale">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="apartment">Квартира</label>
                        <input type="text" class="form-control" id="apartment" name="apartment" readonly>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ownerApartment">Владелец </label>
                        <input type="text" class="form-control" id="ownerApartment" name="ownerApartment" >
                    </div>
                    <div class="form-group col-md-4">
                        <label for="buyer">Покупатель</label>
                        <input type="text" class="form-control" id="buyer" name="buyer" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="agent">Агент</label>
                        <input type="text" class="form-control" id="agent" name="agent" >
                    </div>
                    <div class="form-group col-md-3">
                        <label for="date">Дата продажи</label>
                        <input type="date" class="form-control" id="date" name="date">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="price">Цена продажи</label>
                        <input type="text" class="form-control" id="price" name="price">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="./addApartmentSale">Добавить</button>
            </form>
        </div>
        <c:if test="${isApartmentSaleAdded == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
                <strong>Сделка добавлена</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isApartmentSaleAdded == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
                <strong>Сделка не добавлена</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="accordion" id="accordion">
            <div class="card">
                <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    <h5 class="mb-0">
                        <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                            Квартира
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <div class="p-3">
                            <h2>Список квартир</h2>
                            <div class="w-50 p-3" >
                        <form method="post" id = "formApart">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="numberApartment">Номер квартиры</label>
                                    <input type="text" class="form-control" id="numberApartment" name="numberApartment" placeholder="Номер квартиры">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="countRoom">Количество комнат</label>
                                    <input type="text" class="form-control" id="countRoom" name="countRoom" placeholder="Количество комнат" >
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="livingSpace">Жилплощадь</label>
                                    <input type="text" class="form-control" id="livingSpace" name="livingSpace" placeholder="Жилплощадь">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="meterPrice">цена за кв.метр</label>
                                    <input type="text" class="form-control" id="meterPrice" name="meterPrice" placeholder="цена за кв.метр" >
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="idApartment">id квартиры</label>
                                    <input type="text" class="form-control" id="idApartment" name="idApartment" >
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Найти</button>
                        </form>
                            </div>
                        </div>
                        <table id="DTApart" class="display">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>Номер квартиры</th>
                                <th>Кол.комнат</th>
                                <th>Жилплощадь</th>
                                <th>Дом</th>
                                <th>Владелец</th>
                                <th>цена за метр</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header bg-success" id="headingTwo"  data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    <h5 class="mb-0">
                        <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Покупатель
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
                           Агент
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <jsp:include page="template/ClientTempl/DTApartSaleClient.jsp"/>
                    </div>
                </div>
            </div>
        </div>
</div>
    <script type="text/javascript" charset="utf8">
        <%@include file='./../js/multiSelect.js' %>
    </script>
</body>
</html>