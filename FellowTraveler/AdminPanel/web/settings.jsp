<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 30.04.14
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<a href="${pageContext.request.contextPath}/protected/createTable.do">Создать таблицу</a>
<p>Статус:</p>
<p><bean:write name = "Message" property="message"/></p>
<%@include file="footer.jsp"%>
