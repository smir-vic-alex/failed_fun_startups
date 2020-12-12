<%--
    Created: Денис 
    Date: 23.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Список аптек"/>
    <tiles:putAttribute name="description" value="Список аптек Аптечная справка Вологда Череповец"/>
    <tiles:putAttribute name="content">
        <div id="listButton" class="buttonPrice buttonCheck">Список</div>
        <div id="mapButton" class="buttonPrice buttonNotCheck shiftButton">Карта</div>
        <grid:table name="${form.data}" uid="listPharmaces" class="tables colorGreen">
            <grid:column href="${path}/viewPharmacy.do" paramId="id" paramProperty="id">
                <div class = "map"></div>
            </grid:column>
            <grid:column property="name" title="Название" href="${path}/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="address" title="Адрес" href="${path}/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="phone" title="Телефон"/>
        </grid:table>
        <div id="workArea">
            <div id="map2"></div>
        </div>
    </tiles:putAttribute>
    <tiles:putAttribute name="script">
        <script type="text/javascript">
            ymaps.ready(init);
            var myMap, myPlacemark, myCollection;
            function init() {
                myMap = new ymaps.Map("map2", {
                    center: [${helper:getCurrentCity(pageContext.request).coordinates}],
                    zoom: 12
                });
                myCollection = new ymaps.GeoObjectCollection({}, {});
                <c:forEach var="pharm" items="${form.data}" >
                myPlacemark = new ymaps.Placemark([${pharm.coordinates}], {
                    balloonContentHeader: '<a class="standardLink" href="${path}/viewPharmacy.do?id=${pharm.id}">${pharm.name}</a>',
                    balloonContentBody: '<p class="usualText">Телефон: ${pharm.phone}</p> '
                });
                myCollection.add(myPlacemark);
                </c:forEach>
                myMap.geoObjects.add(myCollection);
            }
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>