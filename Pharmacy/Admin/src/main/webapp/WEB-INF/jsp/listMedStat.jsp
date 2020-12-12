<%--
    Создано: Денис 
    Дата: 05.04.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>
${pageContext.response.setHeader("Content-Disposition", "attachment; filename=Statistic.html")}
<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset = UTF-8"/>
        <meta http-equiv="Content-language" content="ru"/>
        <title>Статистика запросов</title>
        <style>
            .header{
                font-size: 20px;
                font-weight: bold;
                text-align: center;
            }

            .table{
                border: 1px #aaa solid;
                padding: 0;
                margin: 0;
                border-spacing: 0;
            }
            .textAlignCenter{
                text-align: center;
            }
            .padding{
                padding: 5px 10px;
            }
        </style>
    </head>
    <body>
        <table class="table" border="1">
            <tr>
                <td class="header padding">Название</td>
                <td class="header padding">Количество запросов</td>
            </tr>
            <c:forEach var="medStat" items="${form.data}">
                <tr>
                    <td class="padding">${medStat.name}</td>
                    <td class="textAlignCenter padding">${medStat.countRequest}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>