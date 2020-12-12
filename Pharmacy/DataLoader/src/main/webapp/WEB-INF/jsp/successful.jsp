<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 03.11.2014
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="loaderPanel" flush="true">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader">
        <p class="bigText marginBottom10">Загрузка <span class="orangeText">файла</span></p>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <p class="bigText marginBottom10">Файл отправлен</p>
    </tiles:putAttribute>
</tiles:insertDefinition>