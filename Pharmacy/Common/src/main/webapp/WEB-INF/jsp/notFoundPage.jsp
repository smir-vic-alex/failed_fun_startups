<%--
    Создано: Денис 
    Дата: 05.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<!DOCTYPE html>

<tiles:insertDefinition name="onlyFon" flush="true">
    <tiles:putAttribute name="title" value="Ошибка 404: Страница не найдена"/>
    <tiles:putAttribute name="content">
        <div class="notFoundPage textAlignCenter">
            <p class="fontSize35">Ошибка 404: Страница не найдена</p>
            <p class="fontSize50"><a href="${helper:getPath(pageContext)}/index.do"><span class="orangeText">На главную</span></a></p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>