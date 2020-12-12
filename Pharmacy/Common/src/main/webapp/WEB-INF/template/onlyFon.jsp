<%--
    Создано: Денис
    Дата: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<%--
    title - заголовок страницы
    content - контент
--%>
<tiles:importAttribute/>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link rel="shortcut icon" href="${path}/favicon.ico" type="image/x-icon"/>
    <jsp:include page="../jsp/scripts.jsp"></jsp:include>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <div id="content">
                ${content}
            </div>
        </div>
    </div>
</div>
<footer>
    <div id="script">
        <tiles:putAttribute name="script"/>
    </div>
</footer>
</body>
</html>