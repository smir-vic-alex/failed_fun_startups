<%--
    Создано: Денис 
    Дата: 09.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://helper" prefix="helper" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="mapFields" value="${form.fields}"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="client" value="${form.client}"/>

<tiles:insertDefinition name="adminPanel" flush="true">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader" value="Клиент"/>
    <tiles:putAttribute name="content">
        <html:form method="POST" action="/private/${not empty client? 'saveEditClient' : 'saveClient'}.do">
            <html:hidden name="form" property="id"/>
            <table class="colorGreen">
                <tr>
                    <td class="leftColumnDL">Имя:</td>
                    <td><html:text name="form" property="fields(firstName)"
                                   value="${not empty client ? client.firstName : empty mapFields['firstName']? '' : mapFields['firstName']}"
                                   styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Фамилия:</td>
                    <td><html:text name="form" property="fields(secondName)"
                                   value="${not empty client ? client.secondName :  empty mapFields['secondName']? '' : mapFields['secondName']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Отчество:</td>
                    <td><html:text name="form" property="fields(fatherName)"
                                   value="${not empty client ? client.fatherName :  empty mapFields['fatherName']? '' : mapFields['fatherName']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Тефелон:</td>
                    <td><html:text name="form" property="fields(phone)"
                                   value="${not empty client ? client.phone :  empty mapFields['phone']? '' : mapFields['phone']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">E-mail:</td>
                    <td><html:text name="form" property="fields(email)"
                                   value="${not empty client ? client.email :  empty mapFields['email']? '' : mapFields['email']}" styleClass="inputDL"/></td>
                </tr>
                <c:if test="${not empty client}">
                    <tr>
                        <td class="leftColumnDL">Код сети:</td>
                        <td><html:text name="form" property="fields(codeNetwork)"
                                       value="${client.codeNetwork}"
                                       disabled="true" styleClass="inputDL"/></td>
                    </tr>
                </c:if>
                <tr>
                    <td class="leftColumnDL">Логин:</td>
                    <td><html:text name="form" property="fields(login)"
                                   value="${not empty client ? client.login :  empty mapFields['login']? '' : mapFields['login']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Пароль:</td>
                    <td><html:password name="form" property="fields(password1)" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Повторите пароль:</td>
                    <td><html:password name="form" property="fields(password2)" styleClass="inputDL"/></td>
                </tr>

                <tr>
                    <td class="leftColumnDL"></td>
                    <td><html:submit styleClass="submitDL" value="Сохранить"/></td>
                </tr>
            </table>
        </html:form>
    </tiles:putAttribute>
</tiles:insertDefinition>