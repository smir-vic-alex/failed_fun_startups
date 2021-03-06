<%--
    Создано: Денис 
    Дата: 08.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="adminPanel" flush="true">
    <tiles:putAttribute name="title" value="Список аптек"/>
    <tiles:putAttribute name="contentHeader" value="Аптеки"/>
    <tiles:putAttribute name="content">
        <grid:table name="${form.data}" class="colorGreen">
            <grid:column value="Ред" href="${path}/private/editPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="name" title="Название" href="${path}/private/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="address" title="Адрес"/>
            <grid:column property="codeNetwork" title="Код сети"/>
            <grid:column property="phone" title="Телефон"/>
        </grid:table>
    </tiles:putAttribute>
</tiles:insertDefinition>