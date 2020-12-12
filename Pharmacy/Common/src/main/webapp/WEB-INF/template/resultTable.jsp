<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%--
    medicament - название лекарства
    count - количество наденных записей
    grid - грид
--%>

<tiles:importAttribute/>

<div class="blockResult">
<p class="bigText marginBottom10">Результаты <span class="doubleOrange">поиска</span></p>
<p class="smallItalicText marginBottom10"><tiles:insertAttribute name="message"/></p>
<tiles:insertAttribute name="grid"/>
</div>