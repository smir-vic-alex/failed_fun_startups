<%--
    Created: Денис 
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<%--
    title - заголовок страницы
    content - контент
--%>
<tiles:importAttribute/>

<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="isNotViewChangeCityPopUp" value="${!helper:isViewChangeCityPopUp(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <meta name="description" content="<tiles:getAsString name="description"/>">
    <meta name="keywords" content="аптечная справка,аптечная справка Вологда, купить лекарства, где купить лекарства, аптеки вологды">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.css"/>
    <link rel="shortcut icon" href="${path}/favicon.ico" type="image/x-icon"/>
    <title><tiles:getAsString name="title"/></title>
    <script>var path = '${path}';</script>
    <jsp:include page="../jsp/scripts.jsp"/>
</head>
<body>
<c:if test="${isNotViewChangeCityPopUp}">
    <div id="toner" class="windowMarker">
        <div id="popUpSelectCityBig" class="windowMarker colorGreen">
            <div class="textAlignRight">
                <img class="popUpChangeCityCross" src="${path}/images/cross.png">
            </div>
            <c:forEach items="${helper:getListCities()}"  var="city">
                <p class="popUpSelectCityBigCity" id="${city.id}">${city.name}</p>
            </c:forEach>
        </div>
    </div>
</c:if>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header class="headerUser">
                <div id="logo" class="floatLeft">
                    <a href="${path}/index.do">
                        <img src="${path}/images/logo.png" alt="Аптечная справка">
                    </a>
                </div>
                <tiles:insertDefinition name="menu"/>
                <div id="selectCityArea">
                    <div class="displayInliveBlock colorGreen">Город:</div>
                    <c:set var="cityName" value="${helper:getCurrentCity(pageContext.request).name}"/>
                    <div class="displayInliveBlock" id="selectCity"><span class="orangeText" id="currentCity">${cityName}</span>
                        <div id="popUpSelectCity">
                            <table>
                                <c:forEach items="${helper:getListCities()}"  var="city">
                                    <tr>
                                        <td class="changeCityLink" id="${city.id}">${city.name}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <c:if test="${isNotViewChangeCityPopUp}">
                    <div id="popUpCheckCity" class="windowMarker colorGreen">
                        <div class="textAlignRight">
                            <img class="popUpChangeCityCross" src="${path}/images/cross.png">
                        </div>
                        <div class="popUpChangeCityHeader">Ваш город</div>
                        <div class="popUpChangeCityCity">${cityName}</div>
                        <div id="popUpChangeCityAnswerNo" class="popUpChangeCityAnswers">
                            <span>Выбрать другой</span>
                        </div>
                        <div id="popUpChangeCityAnswerYes" class="popUpChangeCityAnswers marginLeft20">
                            <span class="orangeText">Да, всё верно</span>
                        </div>
                    </div>
                </c:if>
                <div class="clear"></div>

            </header>
            <div class="clearRight"></div>
            <div id="content">
                ${content}
            </div>
        </div>
        <%--Слова для поисковых систем--%>
        <div class="displayNone">
            <p>Адрес: г.Вологда</p>
            <p>Индекс: 160000</p>
            <p>Аптечная справка</p>
            <p>Аптечная справка Вологда</p>
            <p>Аптечная справка.рф</p>
            <p>Аптечная справка.рф Вологда</p>
            <p>Вологда Аптечная справка</p>
            <p>Вологда</p>
            <p>аптеки вологды</p>
            <p>антей аптека вологда</p>
        </div>
    </div>
</div>
<footer>
    <div id="script">
        ${script}
        <jsp:include page="../jsp/yandexMetrica.jsp"/>
    </div>
</footer>
</body>
</html>