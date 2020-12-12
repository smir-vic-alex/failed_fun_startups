<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:importAttribute/>

<div id="searchTool">
    <table id="startSearch">
        <tr>
            <td><img src="${helper:getPath(pageContext)}/images/bigArrow.png" alt="Найти лекарство просто"></td>
            <td style="width: 720px;">
               <tiles:insertDefinition name="searchLine" flush="false">
                   <tiles:putAttribute name="action" value="${action}"/>
               </tiles:insertDefinition>
            </td>
        </tr>
    </table>
</div>