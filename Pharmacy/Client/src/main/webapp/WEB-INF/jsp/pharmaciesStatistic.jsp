<%--
    Создано: Денис 
    Дата: 08.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://helper" prefix="helper"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

<tiles:insertDefinition name="clientPanel" flush="true">
    <tiles:putAttribute name="title" value="Информация об аптеке"/>
    <tiles:putAttribute name="contentHeader">
        Статистика <span class="orangeText">посещаемости</span>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <grid:table name="${form.data}" class="colorGreen">
            <grid:column property="pharmacy.name" title="Аптека"/>
            <grid:column property="countVisitOverDay" title="За день" />
            <grid:column property="countVisitOverWeek" title="За 7 дней"/>
            <grid:column property="countVisitOverMonth" title="За 30 дней"/>
        </grid:table>
    </tiles:putAttribute>
</tiles:insertDefinition>