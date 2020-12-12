<%--
  User: Денис
  Date: 09.11.14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Наши контакты"/>
    <tiles:putAttribute name="description" value="Наши контакты Аптечная справка"/>
    <tiles:putAttribute name="content">
        <div class="colorGreen">
            <p class="bigText">Наши <span class="orangeText">контакты</span></p>
            <p class="fontSize20 usualText marginTop30">Если у вас есть вопросы, пожелания или предложения по работе сервиса,  напишите нам.</p>
            <p class="fontSize20 marginTop10">Почта: <span class="usualText">support@pharmacyref.ru</span></p>
            <p class="fontSize20 marginTop10">Группа в ВК: <a href="https://vk.com/club74409851"><span class="usualText">vk.com/club74409851</span></a></p>
            <p class="fontSize20 marginTop10">Группа в Одноклассниках: <a href="http://ok.ru/group/53499761852533"><span class="usualText">ok.ru/group/53499761852533</span></a></p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>