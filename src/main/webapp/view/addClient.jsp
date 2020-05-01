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
                    <input type="text" class="form-control" id="name" placeholder="Имя">
                </div>
                <div class="form-group col-md-6">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname"placeholder="Фамилия">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic"placeholder="Отчество">
                </div>
                <div class="form-group col-md-4">
                    <label for="gender">Пол</label>
                    <select id="gender" class="form-control">
                        <option value="true" selected>мужчина</option>
                        <option value="false">женщина</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfBirth">Дата Рождения</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="date">
                </div>
                <div class="form-group col-md-6">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" placeholder="89994563245">
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" placeholder="example@.com">
            </div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>
</div>
<div>
    <button  type="submit" class="btn btn-primary m-3"  onclick="location.href='./'" >На главную</button>
</div>
</body>
</html>