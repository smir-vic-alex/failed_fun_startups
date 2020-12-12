<%--
    Создано: Денис
    Дата: 04.01.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

<tiles:insertDefinition name="onlyFon" flush="true">
    <tiles:putAttribute name="title" value="Личный кабинет"/>
    <tiles:putAttribute name="content">
        <div id="formDL">
            <c:if test="${!form.correctLoginAndPassword}">
                <p class="errorMessage">Направильно введён логин или пароль</p>
            </c:if>
            <form method="POST" enctype="multipart/form-data" action="${helper:getPath(pageContext)}/login.do">
                <table class="tableDL">
                    <tr>
                        <td class="leftColumnDL">Логин:</td>
                        <td><input type="text" name="fields(login)" class="inputDL"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL">Пароль:</td>
                        <td><input type="password" name="fields(password)" class="inputDL"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL"></td>
                        <td><input type="submit" class="submitDL" value="Войти"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>