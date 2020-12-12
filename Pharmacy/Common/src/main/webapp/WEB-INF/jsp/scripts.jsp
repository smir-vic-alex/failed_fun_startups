<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://helper" prefix="helper" %>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
<script type="text/javascript" src="${path}/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${path}/js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="${path}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${path}/js/SwitchListOrMapTable.js"></script>
<script type="text/javascript" src="${path}/js/autoComplete.js"></script>
<script type="text/javascript" src="${path}/js/checkCity.js"></script>