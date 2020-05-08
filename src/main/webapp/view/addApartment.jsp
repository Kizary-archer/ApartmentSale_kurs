<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="p-3">
        <h2>Добавить квартиру</h2>
        <div class="w-50 p-3" >
            <form method="post">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="numberApartment">Номер квартиры</label>
                        <input type="text" class="form-control" id="numberApartment" name="numberApartment" placeholder="Номер квартиры">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="countRoom">Количество комнат</label>
                        <input type="text" class="form-control" id="countRoom" name="countRoom" placeholder="Количество комнат">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="livingSpace">Жилплощадь</label>
                        <input type="text" class="form-control" id="livingSpace" name="livingSpace" placeholder="Жилплощадь">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="meterPrice">цена за кв.метр</label>
                        <input type="text" class="form-control" id="meterPrice" name="meterPrice" placeholder="цена за кв.метр">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="apartmentOwner">id владельца</label>
                        <input type="text" class="form-control" id="apartmentOwner" name="apartmentOwner" readonly value=${requestScope.apartmentOwner}>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="house">id дома</label>
                        <input type="text" class="form-control" id="house" name="house" readonly>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="./addClient">Добавить</button>
            </form>
        </div>
        <c:if test="${isDocumentAdded == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ добавлен</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isDocumentAdded == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ не добавлен</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" id="btnAccord1" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Выберите дом
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ApartmentTemp/DTSearchHouse.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf8">
    <%@include file='./../js/houseSelect.js' %>
</script>
</body>
</html>