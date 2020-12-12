<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://helper" prefix="helper"%>

<%--
    action - ссылка для отправки данных с формы. Все прификсы и постфиксы уже указаны
--%>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:importAttribute/>


<div id="fieldSearch">
    <html:form action="${action}" method="post">
        <html:hidden  name="form" property="id" styleId="inputID"/>
        <img id = "iconSearch" src="${path}/images/iconSearch.png" alt="лекарство">
        <div id="searchLine" class="colorGreen">
            <p class="additionText bigText">поиск</p>
            <div class="floatLeft">
                <html:text name="form" property="fields(searchInput)" styleId="searchText" styleClass="inputTextSearch" maxlength="40"/>
            </div>
            <input id="searchButton" type="image" src="${path}/images/search.png">
            <p class="additionText smallItalicText">например: <span class="doubleOrange">аспирин</span></p>
        </div>
    </html:form>
</div>