<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new city</title>
</head>

<body>
<div>
    <div>
        <div>
            <h2>Add city </h2>
            <%
                if (request.getAttribute("client") != null) {
                    out.println("<p>Клиент '" + request.getAttribute("client")+": заполните все поля</p>");
                }
            %>
        </div>

        <form method="post">
            <label>name:
                <input type="text" name="name"><br />
            </label>
            <label>surname:
                <input type="text" name="surname"><br />
            </label>
            <label>patronymic:
                <input type="text" name="patronymic"><br />
            </label>
            <label>dateOfBirth:
                <input type="text" name="dateOfBirth"><br />
            </label>
            <label>phoneNumber:
                <input type="text" name="phoneNumber"><br />
            </label>
            <label>email:
                <input type="text" name="email"><br />
            </label>
            <label>
                <input type="radio" value="true" checked name="gender"/>мужской
                <input type="radio" value="false" checked name="gender"/>женский
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='./'">Back to main</button>
</div>
</body>
</html>