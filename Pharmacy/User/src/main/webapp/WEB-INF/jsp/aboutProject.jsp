<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 09.04.2015
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Сервис Аптечная справка"/>
    <tiles:putAttribute name="description" value="Сервис Аптечная справка"/>
    <tiles:putAttribute name="content">
        <p class="fontSize20 usualText marginTop30 textAlignCenter">Сервис "Аптечная справка" содержит список аптек и цены на лекарства.</p>
        <p class="fontSize20 usualText marginTop30 textAlignCenter">Мы поможем найти любое лекарство в ближайших аптеках по оптимальной цене, не выходя из дома.</p>
        <p class="fontSize20 usualText marginTop30 textAlignCenter">Вам больше не придётся тратить время на обход нескольких аптек для поиска лучшего предложения.</p>
    </tiles:putAttribute>
</tiles:insertDefinition>