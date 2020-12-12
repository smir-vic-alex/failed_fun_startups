<%--
    Создано: Денис 
    Дата: 28.03.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://helper" prefix="helper"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

{
    "success": ${form.status}
}