<%--
  User: Денис
  Date: 05.01.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>
<c:set var="pharmacy" value="${form.pharmacy}"/>

<tiles:insertDefinition name="clientPanel" flush="true">
    <tiles:putAttribute name="title" value="Информация об аптеке"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="viewPharmacy">
            <tiles:putAttribute name="name" value="${pharmacy.name}"/>
            <tiles:putAttribute name="address" value="${pharmacy.address}"/>
            <tiles:putAttribute name="phone" value="${pharmacy.phone}"/>
            <tiles:putAttribute name="coordinates" value="${pharmacy.coordinates}"/>
            <tiles:putAttribute name="workTime" value="${pharmacy.workTime}"/>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>
