<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 14.07.14
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <title>О проекте</title>
</head>
<body>
<div id = "basis">
    <div id = "mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/index.do"><img src="../images/logo.png"></a></div>
            <div class="documentation">
                <p>Здравствуйте!</p>
                <p>Цель нашего проекта "Попутчик" - возможность добраться из одного города в другой.</p>
                <p>Как это работает? У многих есть автомобили, но у многих их и нет. Водители, готовые подвести незнакомого человека, заносят свой маршрут
                    на сайт. Потенциальные пассажиры находят их. Пассажир и водитель просматривают профиль друг друга в соц сетях. Если они устраивают друг друга, то
                    списываются и едут.</p>
            </div>
            <%@include file="footer.jsp" %>
