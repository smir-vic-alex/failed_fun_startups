<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 09.04.2015
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://helper" prefix="helper"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="path" value="${helper:getPath(pageContext)}"/>
<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Наши контакты"/>
    <tiles:putAttribute name="description" value="пост от Аптечная справка"/>
    <tiles:putAttribute name="content">
        <table class="tablePost">
            <tr>
                <td class="smallPost">
                    <a href="${path}/MythsAboutAntibiotics.do">
                        <img src="${path}/images/postImages/MythsAboutAntibiotics.jpg"  class="imageSmallPost">
                    </a>
                    <div class="textSmallPost">
                        <a href="${path}/MythsAboutAntibiotics.do">
                            <h1 class="headerTextPost usualText">Мифы и правда об антибиотиках</h1>
                        </a>
                        <p class="textSmallPost usualText ">Разбираемся с наиболее популярными мифами об антибиотиках</p>
                    </div>
                </td>
                <td class="smallPost">
                    <a href="${path}/pharmacyFacts.do">
                    <img src="${path}/images/postImages/pharmacyFacts.jpg"  class="imageSmallPost">
                    </a>
                    <div class="textSmallPost">
                        <a href="${path}/pharmacyFacts.do">
                            <h1 class="headerTextPost usualText">10 фактов об аптеке</h1>
                        </a>
                        <p class="textSmallPost usualText ">Когда ты болеешь, то думаешь об аптеке как о месте, где тебе помогут. Так было всегда, во все времена — официальная история аптеки насчитывает тысячелетия, а неофициальная может быть приравнена к возрасту цивилизации — в первых городах человечества могло не быть стен, но аптеки уже существовали.</p>
                    </div>
                </td>
                <td class="smallPost">
                    <a href="${path}/timeToThrowMedicament.do">
                    <img src="${path}/images/postImages/timeToThrowMedicament.jpg"  class="imageSmallPost">
                    </a>
                    <div class="textSmallPost">
                        <a href="${path}/timeToThrowMedicament.do">
                            <h1 class="headerTextPost usualText">Когда лекарство пора выбросить</h1>
                        </a>
                        <p class="textSmallPost usualText ">Часто случается такое, что инструкция попросту потерялась. Чтобы оградить себя от некачественных и опасных препаратов, нужно помимо прочего обращать внимание на внешние характеристики.</p>
                    </div>
                </td>
            </tr>

        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>