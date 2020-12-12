<%--
    Created: Денис 
    Date: 16.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:importAttribute ignore="true"/>

<p class="bigText marginBottom30 colorGreen">Аптека <span class="orangeText"><tiles:insertAttribute name="name"/></span></p>
<div class="leftColumn">
    <p class="bigText marginBottom30"><span class="orangeText">Контактная</span> информация</p>
    <p>Адрес: <span class="usualText"><tiles:insertAttribute name="address"/></span></p>
    <c:set var = "time" ><tiles:insertAttribute name="workTime" ignore="true"/></c:set>
    <c:if test="${not empty time}">
        <p>Время работы:</p>
        <c:forEach var="days" items="${helper:splitString(time, ';')}">
            <p class="marginLeft20"><span class="usualText">${days}</span></p>
        </c:forEach>
    </c:if>
    <p>Телефон: <span class="usualText"><tiles:insertAttribute name="phone"/></span></p>
    <c:set var="inform"><tiles:insertAttribute name="additionalInformation"/></c:set>
    <c:if test="${not empty inform}">
        <p>Доп. информация: <span class="usualText"></span></p>
    </c:if>
</div>
<div class="workArea">
    <p class="bigText marginBottom30">Карта</p>

    <div id="map"></div>
    <script type="text/javascript">
        ymaps.ready(init);
        var myMap, myPlacemark;

        function init(){
            myMap = new ymaps.Map("map", {
                center: [${coordinates}],
                zoom: 16
            });

            myPlacemark = new ymaps.Placemark([${coordinates}], {
                hintContent: '${name}',
                balloonContent: '${address}'
            });

            myMap.geoObjects.add(myPlacemark);
        }
    </script>
</div>
