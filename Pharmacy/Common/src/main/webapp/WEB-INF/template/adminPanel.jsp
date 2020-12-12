<%--
    Создано: Денис 
    Дата: 04.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:importAttribute/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="errorMessage" value="${helper:getErrorMessage(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <jsp:include page="../jsp/scriptsProtected.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.css"/>
    <link rel="shortcut icon" href="${path}/favicon.ico" type="image/x-icon"/>
    <title>${title}</title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header class="headerAdmin">
                <div id="logo">
                    <a href="${path}/private/welcomePage.do">
                        <img src="${path}/images/logo.png">
                    </a>
                </div>
                <div class="clear"></div>
            </header>
            <div id="content">
                <p class="bigText colorGreen">Личный <span class="doubleOrange">кабинет</span></p>
                <p><span class="doubleOrange">Добро пожаловать, Админ!</span></p>
                <div class="twoColumn">
                    <div class="leftColumnAdmin">
                        <a href="${path}/private/viewPharmacies.do"><p class="leftMenu">Аптеки</p></a>
                        <a href="${path}/private/createPharmacy.do"><p class="leftSubMenu">Создать</p></a>
                        <a href="${path}/private/listClient.do"><p class="leftMenu">Клиенты</p></a>
                        <a href="${path}/private/createClient.do"><p class="leftSubMenu">Создать</p></a>
                        <a><p class="leftMenu">Статистика</p></a>
                        <a href="${path}/private/listStatisticPharmacy.do"><p class="leftSubMenu">Аптеки</p></a>
                        <a href="${path}/private/statisticMedicament.do"><p class="leftSubMenu">Лекарства</p></a>
                        <a href="#"><p class="leftMenu">Настройки</p></a>
                        <a href="${path}/private/exit.do"><p class="leftMenu">Выход</p></a>
                    </div>
                    <div class="wrapperAdmin">
                        <div class="workAreaAdmin">
                            <p class="contentHeaderAdminPanel">${contentHeader}</p>
                            <c:if test="${not empty errorMessage}">
                                <p class="errorMessage marginBottom10">${errorMessage}</p>
                            </c:if>
                            ${content}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div id="script">
        ${script}
    </div>
</footer>
</body>
</html>