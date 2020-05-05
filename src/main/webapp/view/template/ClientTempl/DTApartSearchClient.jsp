<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableApartSearch" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Кол.Комнат</th>
        <th>Жилплощадь</th>
        <th>Клиент</th>
        <th>Цена за метр</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="SearchApartmentEntity" items="${client.searchApartmentsByIdClient}">
        <tr>
            <td> <c:out value="${SearchApartmentEntity.idApartment}"/></td>
            <td> <c:out value="${SearchApartmentEntity.countRoom}"/></td>
            <td> <c:out value="${SearchApartmentEntity.livingSpace}"/></td>
            <td> <c:out value="${SearchApartmentEntity.client}"/></td>
            <td> <c:out value="${SearchApartmentEntity.meterPrice}"/></td>
            <td> <c:out value="${SearchApartmentEntity.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>