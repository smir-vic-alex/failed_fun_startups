<%--
    Created: Денис
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Аптечная справка"/>
    <tiles:putAttribute name="description" value="Поиск лекарства в сервисе Аптечная справка Вологда Череповец"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchTool" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>