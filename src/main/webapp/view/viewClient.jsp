<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
    <style>
        <%@include file='style.css' %>
    </style>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Add new city</title>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top ">
    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-4">

            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Portfolio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Team</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Post</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Contact</a>
            </li>
        </ul>

    </div>
</nav>
<div style="width: 60%">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                Одна из трёх колонок
            </div>
            <div class="col-sm-6">
                Одна из трёх колонок
            </div>
            <div class="col-sm">
                Одна из трёх колонок
            </div>
        </div>
    </div>
        <div>
            <h2>Add city </h2>
            <label>name:
                <label>${client.name}</label><br>
            </label>
            <label><br>surname:
                <label>${client.surname}</label>
            </label>
            <label><br>patronymic:
                <label>${client.patronymic}</label>
            </label>
            <label><br>dateOfBirth:
                <label>${client.dateOfBirth}</label>
            </label>
            <label><br>phoneNumber:
                <label>${client.phoneNumber}</label>
            </label>
            <label><br>email:
                <label>${client.email}</label>
            </label>
            <label>gender:
                <label>${client.gender}</label>
            </label>
    </div>
   <div>
       <table id="table_id" class="display" style="width:100%">
           <thead>
           <tr>
               <th>Column 1</th>
               <th>Column 2</th>
               <th>Column 2</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach var="ApartmentEntity" items="${client.apartmentsByIdClient}">
           <tr>
               <td> <c:out value="${ApartmentEntity.idApartment}"/></td>
               <td> <c:out value="${ApartmentEntity.numberApartment}"/></td>
               <td> <c:out value="${ApartmentEntity.apartmentOwner}"/></td>
           </tr>
           </c:forEach>
           </tbody>
       </table>
   </div>
    <button onclick="location.href='./'">Back to main</button>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#table_id').DataTable();
    } );
    </script>

</body>
</html>