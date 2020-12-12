<%--
    Создано: Денис 
    Дата: 05.04.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://helper" prefix="helper"%>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

<tiles:insertDefinition name="adminPanel" flush="true">
    <tiles:putAttribute name="title" value="Статистика по запрашиваемым лекарствам"/>
    <tiles:putAttribute name="contentHeader">
        Статистика по <span class="orangeText">Лекарствам</span>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <p class="description">Выберите временной промежуток для просмотра статистики</p>
        <form id="formMedStat" action="${path}/private/listStatisticMedicament.do" method="post">
            <input type="text" id="startDay" class="dateInput" name="filters(startDay)" placeholder="Дата начала">
            <input type="text" id="endDay" class="dateInput" name="filters(endDay)" placeholder="Дата конца">
            <input type="button" id="submitMedStat" class="button" value="Просмотреть">
        </form>
    </tiles:putAttribute>
    <tiles:putAttribute name="script">
        <script>
            $(document).ready(function(){
                $(".dateInput").datepicker();
                var $button = $("#submitMedStat");
                $button.button();
                $button.click(function(){
                    var $startDate = $("#startDay");
                    var $endDate = $("#endDay");
                    if($startDate.val() != '' && $endDate.val() !=''){
                        $("#formMedStat").submit();
                    }
                });
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>