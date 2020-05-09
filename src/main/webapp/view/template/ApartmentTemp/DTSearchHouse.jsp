<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<div class="p-3">
    <h2>Найти дом</h2>
    <div class="w-50 p-3" >
        <form method="post">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="idHouse">id Дома</label>
                    <input type="text" class="form-control" id="idHouse" name="idHouse" placeholder="id Дома">
                </div>
                <div class="form-group col-md-4">
                    <label for="numberHouse">Номер дома</label>
                    <input type="text" class="form-control" id="numberHouse" name="numberHouse" placeholder="Номер дома">
                </div>
                <div class="form-group col-md-4">
                    <label for="seriesName">стр.серия</label>
                    <input type="text" class="form-control" id="seriesName" name="seriesName" placeholder="стр.серия">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="streetName">Название улицы</label>
                    <input type="text" class="form-control" id="streetName" name="streetName" placeholder="Название улицы">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./addClient">Найти</button>
        </form>
    </div>
</div>
<table id="tablehouses" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Номер дома</th>
        <th>стр.серия</th>
        <th>Название улицы</th>
        <th>Название района</th>
        <th>Название города</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="house" items="${houseEntityList}">
        <tr>
            <td><c:out value="${house.idHouse}"/></td>
            <td><c:out value="${house.numberHouse}"/></td>
            <td><c:out value="${house.nameSeries}"/></td>
            <td><c:out value="${house.nameStreet}"/></td>
            <td><c:out value="${house.nameDistrict}"/></td>
            <td><c:out value="${house.nameCity}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>