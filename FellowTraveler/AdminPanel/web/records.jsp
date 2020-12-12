<%@include file="header.jsp"%>
<input type="button" onclick="getDrivers('${pageContext.request.contextPath}/protected/getallrecords.do', 'post', 'data')" value="Просмотр всех записей">
<div id = "data"></div>
<%@include file="footer.jsp"%>