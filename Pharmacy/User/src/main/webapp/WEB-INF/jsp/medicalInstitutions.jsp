<%--
    Создано: Денис 
    Дата: 12.04.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Мед учреждения"/>
    <tiles:putAttribute name="content">
        <div class="textAlignCenter">
            <p class="fontSize35 colorGreen">Раздел находится на этапе наполнения.</p>
            <p class="fontSize50"><a href="${path}/index.do"><span class="orangeText">На главную</span></a></p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>