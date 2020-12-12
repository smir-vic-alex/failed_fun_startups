<%--
    Создано: Денис 
    Дата: 04.01.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="template" value="onlyFon"/>
<c:if test="${empty path}">
    <c:set var="template" value="main"/>
</c:if>
<tiles:insertDefinition name="${template}" flush="true">
    <tiles:putAttribute name="title" value="Ошибка"/>
    <tiles:putAttribute name="content">
        <div class="errorBlock colorGreen">
            К сожалению, произошла ошибка. Повторите попытку позже.
            <p><a href="${helper:getPath(pageContext)}/index.do"><span class="orangeText">На главную</span></a></p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>