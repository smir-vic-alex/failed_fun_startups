<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="loaderPanel" flush="true">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader">
        Загрузка <span class="orangeText">файла</span>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <div id="formDL">
            <form method="POST" enctype="multipart/form-data" action="${path}/private/save.do">
                <table class="tableDL">
                    <tr>
                        <td class="leftColumnDL">Файл для загрузки:</td>
                        <td><input type="file" name="upfile"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL"></td>
                        <td><input type="submit" class="submitDL" value="Отправить"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>