<%--
    Создано: Денис 
    Дата: 08.02.15.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var = "form" value="${helper:getCurrentForm(pageContext)}"/>
{
<c:forEach items="${form.data}"  var="medicament" varStatus="status">
    "item${status.count}": {"id":"${medicament.id}", "label":"${medicament.name}"}
    <c:if test="${!status.last}">,</c:if>
</c:forEach>
}