<%--
    Created: Денис 
    Date: 30.12.14.
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
    <tiles:putAttribute name="description" value="выберите лекарство Аптечная справка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchLine" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
        <c:choose>
            <c:when test="${form.length != '0'}">
                <div class="blockResult">

                    <c:set var="isRow1" value="${true}"/>
                    <c:if test="${not empty form.targetMedicament}">
                        <div class="youSearch"><span class="orangeText">искали</span></div>
                        <tiles:insertDefinition name="itemMedicament">
                            <tiles:putAttribute name="medicament" value="${form.targetMedicament.first}"/>
                            <tiles:putAttribute name="countOffer" value="${form.targetMedicament.second}"/>
                            <tiles:putAttribute name="showBackground" value="${isRow1}"/>
                        </tiles:insertDefinition>
                    </c:if>

                    <div class="marginTop30 youSearch orangeText">похожие</div>
                    <c:forEach var="pair" items="${form.data}">
                        <c:set var="isRow1" value="${!isRow1}"/>
                        <tiles:insertDefinition name="itemMedicament">
                            <tiles:putAttribute name="medicament" value="${pair.first}"/>
                            <tiles:putAttribute name="countOffer" value="${pair.second}"/>
                            <tiles:putAttribute name="showBackground" value="${isRow1}"/>
                        </tiles:insertDefinition>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <p class="marginTop30 textAlignCenter fontSize35">По вашему запросу ничего не найдено</p>
            </c:otherwise>
        </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>