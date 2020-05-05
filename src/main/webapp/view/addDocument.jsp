<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="w-50 p-3" >
        <h2>Добавить клиента</h2>
        <form method="post">
            <h2>Найти клиента</h2>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="series">Серия</label>
                    <input type="text" class="form-control" id="series" name="series">
                </div>
                <div class="form-group col-md-6">
                    <label for="number">Номер</label>
                    <input type="text" class="form-control" id="number" name="number">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="issued">Выдан:</label>
                    <input type="text" class="form-control" id="issued" name="issued">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfIssue">Дата выдачи</label>
                    <input type="date" class="form-control" id="dateOfIssue" name="dateOfIssue">
                </div>
                <div class="form-group col-md-4">
                    <label for="typeDocument">Тип документа</label>
                    <select id="typeDocument" class="form-control" name="typeDocument" >
                        <option value="" selected>выберите</option>
                        <option value="true" >мужчина</option>
                        <option value="false">женщина</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="idClient">id</label>
                    <input type="text" class="form-control" id="idClient" name="idClient">
                </div>
            </div>
            <button id="b1" type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>
</div>
</body>
</html>