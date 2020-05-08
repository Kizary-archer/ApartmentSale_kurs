<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/view/template/header.jsp"/>
<div>
    <h1>Super app!</h1>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='./addClient'">add users</button>
        <button onclick="location.href='./addDocument?idClient=3'">view</button>
    </div>
    <c:if test="${isDocumentdel == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ удалён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isClientdel == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Клиент удалён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
</div>
</body>
</html>