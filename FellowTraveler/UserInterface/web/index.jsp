<%-- Created by Денис --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <title>Поиск попутчиков</title>
</head>
<body>
<div id = "basis">
    <div id = "mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/index.do"><img src="images/logo.png"></a></div>
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/addRouter.do"><img src="images/addRouter.png"></a></div>
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/findMan.do"><img src="images/findMan.png"></a></div>
<%@include file="jsp/footer.jsp" %>