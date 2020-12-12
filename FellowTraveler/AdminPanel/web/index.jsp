<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>Админ панель</title>
</head>
<body>
<div align = "center">
    <div id = "Logon" >
        <form action="${pageContext.request.contextPath}/logon.do" method="post">
            <p>Логин</p>
            <input type="text" name="name">
            <p>Пароль</p>
            <input type="password" name="password">
            <input type="submit" value="Войти">
        </form>
    </div>
</div>

</body>
</html>