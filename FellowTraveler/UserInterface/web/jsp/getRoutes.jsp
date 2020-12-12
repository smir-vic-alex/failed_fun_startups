<%@ page import="hibernateServise.RecordsForm" %>
<%@ page import="hibernateServise.User" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="tableRecords">
    <tr class="tableHeader">
        <td class="place">Откуда</td>
        <td class="place">Куда</td>
        <td class="inform">День</td>
        <td class="inform">Месяц</td>
        <td class="inform">Страница ВКонтакте</td>
        <td class="comment">Комментарий</td>
    </tr>
    <logic:iterate id="user" name="Records" property="users">
        <tr>
            <td><bean:write name="user" property="startpoint"/></td>
            <td><bean:write name="user" property="finishpoint"/></td>
            <td>
                <%
                    User userDub = (User) pageContext.getAttribute("user");
                    if (userDub.getDay() > 0) {%>
                <bean:write name="user" property="day" format=""/><%
            }else {
            %>Любой<%
                }
            %>
            </td>
            <td><bean:write name="user" property="month" format=""/></td>
            <td><a href="<bean:write name="user" property="vkId"/>"> VK</a></td>
            <td><bean:write name="user" property="information"/></td>
        </tr>
    </logic:iterate>
</table>