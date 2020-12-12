<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Аптечная справка"/>
    <tiles:putAttribute name="description" value="Список лекарств Аптечная справка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchLine" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
        <c:choose>
            <c:when test="${form.length != '0'}">
                <tiles:insertDefinition name="resultTable" flush="false">
                    <tiles:putAttribute name="message">
                        <p class="smallItalicText marginBottom10">Лекарство <span class="doubleOrange"> "<bean:write
                                name="form" property="medicament.name"/>"</span> найдено в ${form.length} аптеках
                        </p>
                    </tiles:putAttribute>
                    <tiles:putAttribute name="grid">
                        <div id="listButton" class="buttonPrice buttonCheck">Список</div>
                        <div id="mapButton" class="buttonPrice buttonNotCheck shiftButton">Карта</div>
                        <grid:table uid="price" name="${form.data}" class="tables">
                            <grid:column href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id">
                                <div class = "map"></div>
                            </grid:column>
                            <grid:column property="pharmacy.name" title="Название аптеки"
                                         href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id" class="highlightLink"/>
                            <grid:column property="pharmacy.address" title="Адрес"
                                         href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id" class="highlightLink"/>
                            <grid:column title="Количество">${helper:getAmountMedicament(price.amount)}</grid:column>
                            <grid:column title="Стоимость">${helper:getCostMedicament(price.cost)}</grid:column>
                            <grid:column title="Дата обновления">${helper:getDateUpdate(price.dateUpdate)}</grid:column>
                        </grid:table>
                        <div id="workArea">
                            <div id="map2"></div>
                        </div>
                        <script type="text/javascript">
                            ymaps.ready(init);
                            var myMap, myPlacemark, myCollection;
                            function init() {
                                myMap = new ymaps.Map("map2", {
                                    center: [${helper:getCurrentCity(pageContext.request).coordinates}],
                                    zoom: 12
                                });
                                myCollection = new ymaps.GeoObjectCollection({}, {});
                                <c:forEach var="price" items="${form.data}" >
                                myPlacemark = new ymaps.Placemark([${price.pharmacy.coordinates}], {
                                    balloonContentBody: '<a class="balloonPriceBody standardLink" href=\'${path}/viewPharmacy.do?id=${price.pharmacy.id}\'>${helper:getCostMedicament(price.cost)} руб. </a>',
                                    balloonContentFooter: '<a class="balloonPriceBody standardLink" href=\'${path}/viewPharmacy.do?id=${price.pharmacy.id}\'>${price.pharmacy.name}</a>',
                                    hintContent: '<p class="smallItalicText colorGreen">${helper:getCostMedicament(price.cost)} руб.</p>'

                                });
                                myCollection.add(myPlacemark);
                                </c:forEach>
                                myMap.geoObjects.add(myCollection);
                            }
                            $(document).ready(function(){
                                var $price = jQuery("#price");
                                $price.tablesorter({
                                    sortList: [[4,0]],
                                    headers: {
                                        0: {sorter: false},
                                        1: {sorter: false},
                                        2: {sorter: false},
                                        5: {sorter: false}
                                    },
                                    widgets: ["zebra"],
                                    widgetOptions : {
                                        zebra :[ "row1", "row2" ]
                                    },
                                    sortReset   : true

                                });

                                var $sel = jQuery(".sorter-false");
                                $sel.removeClass("tablesorter-headerUnSorted");

                                $price.bind("sortEnd",function(e, table) {
                                    $sel.removeClass("tablesorter-headerUnSorted");
                                });

                            });
                        </script>
                    </tiles:putAttribute>
                </tiles:insertDefinition>
            </c:when>
            <c:otherwise>
                <p class="marginTop30 textAlignCenter fontSize35">По вашему запросу ничего не найдено</p>
            </c:otherwise>
        </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>
