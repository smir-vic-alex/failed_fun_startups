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
    <title>Условия соглашения</title>
</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/index.do"><img src="../images/logo.png"></a></div>
            <div class="documentation">
                <ol>
                    <li>Мы не несём никакой ответственности за действия пассажиров или водителей.</li>
                    <li>Садясь в машину к незнакомому человеку, вы понимаете и берёте на себя весь риск.</li>
                    <li>Если Ваши планы изменились, сразу же предупреждайте всех, с кем договаривались.</li>
                    <li>Водитель и пассажир обязуются не обманывать и не "бросать" друг друга.</li>
                </ol>
            </div>
            <%@include file="footer.jsp" %>
