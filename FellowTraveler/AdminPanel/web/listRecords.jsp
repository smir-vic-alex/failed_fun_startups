<%@ page import="hibernateServise.User" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix ="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<table class="tableRecords" c>
    <tr class="tableHeader">
        <td class="place">Удалить</td>
        <td class="place">Откуда </td>
        <td class="place">Куда</td>
        <td class="date">Кто</td>
        <td class="date">День</td>
        <td class="date">Месяц</td>
        <td class="date">Страница ВКонтакте </td>
        <td class="comment">Комментарий</td>
    </tr>

    <logic:iterate id="user" name="Records" property="users">
        <tr>
            <td class="delete" onclick="getDrivers('${pageContext.request.contextPath}/protected/delete.do?id=<bean:write name="user" property="id" format=""/>&table.xml=route', 'post', 'data')"><img src="${pageContext.request.contextPath}/images/delete.jpg"></td>
            <td><bean:write name="user" property="startpoint"/></td>
            <td><bean:write name="user" property="finishpoint"/></td>
            <td>
               <% User userDub = (User)pageContext.getAttribute("user");
                   if (userDub.getWho() == 0){%>
                        Вод
               <% }else {%>
                        Пас
               <% }%>

            </td>
            <td><bean:write name="user" property="day" format=""/> </td>
            <td><bean:write name="user" property="month" format=""/> </td>
            <td><a href="<bean:write name="user" property="vkId"/>"> VK</a></td>
            <td><bean:write name="user" property="information"/></td>
        </tr>
    </logic:iterate>
</table>