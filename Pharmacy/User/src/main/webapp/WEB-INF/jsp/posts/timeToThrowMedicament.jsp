<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 09.04.2015
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://helper" prefix="helper" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Наши контакты"/>
    <tiles:putAttribute name="content">
        <div class="viewPost">

            <h1 class="headerTextPost headerViewPost ">Когда лекарство пора выбросить</h1>

            <img src="${path}/images/postImages/timeToThrowMedicament.jpg" class="imageViewPost">

            <p class="smallHeader">Если человек внимательно читает инструкцию, то он знает, что у каждого лекарства есть
                внешние характеристики (цвет, консистенция, плотность, блеск и др.) Часто случается такое, что
                инструкция попросту потерялась. Чтобы оградить себя от некачественных и опасных препаратов, нужно помимо
                прочего обращать внимание на внешние характеристики.
            </p>

            <p class="smallHeader"><span class="headerExplanation">1. Мази</span></p>

            <p class="usualText">В них не должно наблюдаться комков, зернистости, водянистости, повышенной текучести.
                Если вы знаете, какой цвет обычно имеет мазь, обратите на этот фактор внимание.
            </p>

            <p class="smallHeader"><span class="headerExplanation">2. Таблетки</span></p>

            <p class="usualText"> Цвет должен быть точно такой, как указано в инструкции. Таблетки не должны крошиться,
                трескаться.
            </p>

            <p class="smallHeader"><span class="headerExplanation"> 3. Капсулы</span></p>

            <p class="usualText"> Не должны слипаться между собой. Не должны быть мягкими или видоизмененной формы. Не
                должны быть разрушенными.
            </p>

            <p class="smallHeader"><span class="headerExplanation"> 4. Капли</span></p>

            <p class="usualText"> Не должно быть осадка на дне, помутнения. Изменение запаха и цвета также говорит о
                том, что препарат нужно выбросить.
            </p>

            <p class="smallHeader"><span class="headerExplanation"> 5. Свечи</span></p>

            <p class="usualText"> Не должны быть потрескавшимися или с повреждениями.
            </p>

            <p class="usualText"> Если обнаружены указанные признаки, то препарат не подлежит употреблению, от него
                нужно срочно избавиться. Следует знать, что такие медикаменты не только не приносят пользы, но и
                представляют собой угрозу здоровью.
            </p>

            <p class="smallHeader"><span class="headerExplanation">Рекомендации по условиям хранения</span></p>

            <p class="usualText"> Многие лекарства нужно хранить в холодильнике, это всегда обозначено в инструкции и на
                упаковке. Кроме температурных условий, следует позаботиться о следующем:
                - лекарства должны храниться на отдельной полке в холодильнике;
                - они не должны контактировать с едой;
                - для хранения предпочтительно использовать отдельный пакет;
                - медикаменты не должны замораживаться, а лишь охлаждаться.

                Лекарственные препараты чувствительны к температурным перепадам, поэтому при перевозке нужно
                использовать медицинский термоконтейнер. В домашних условиях его можно заменить бутылкой с ледяной водой
                или льдом. Это касается тех препаратов, которые необходимо хранить в холодильнике. Если лекарство
                некоторое время хранилось в неправильных условиях, применять его нельзя, так как последствия могут быть
                самыми разными.
            </p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>