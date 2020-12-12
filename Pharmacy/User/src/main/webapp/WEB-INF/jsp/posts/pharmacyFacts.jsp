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

            <h1 class="headerTextPost headerViewPost ">10 фактов об аптеке</h1>

            <img src="${path}/images/postImages/pharmacyFacts.jpg" class="imageViewPost">

            <p class="smallHeader">Когда ты болеешь, то думаешь об аптеке как о месте, где тебе помогут. Так было
                всегда, во все времена — официальная история аптеки насчитывает тысячелетия, а неофициальная может быть
                приравнена к возрасту цивилизации — в первых городах человечества могло не быть стен, но аптеки уже
                существовали.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class="usualText"><span class="headerExplanation">1</span>Существует несколько видов аптек, согласно
            современному законодательству стран СНГ: аптека, аптечный пункт, аптечный киоск, аптечный магазин, аптеки
            дистанционных продаж.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">2</span> Впервые аптеки стали регулироваться
                государством в 8-м веке, в Багдаде. До этого моменты аптечный бизнес был сугубо частным, однако после в
                арабских странах, осознав важность аптек, стали требовать соблюдения определенных норм от аптек.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">3</span> В конце 18-го века в России насчитывалось
                всего 100 аптек на всю страну. Собственно, потому народная медицина и процветала — найти аптеку можно
                было далеко не везде, и не всем посещение таковой была по карману. В конце 19-го века управление
                аптеками было передано министерству внутренних дел.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">4</span> Официально работникам аптек запрещено
                консультировать покупателей — можно лишь отвечать на вопросы относительно лекарств, но заниматься
                рекламой и тем более назначением лекарств ни в коем случае. Однако по-прежнему самый популярный вопрос в
                аптеках: «подскажите что-нибудь от…».
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">5</span> У аптекарей есть свои святые покровители (в
                православной христианской традиции) — братья Косма и Дамиан, чудотворцы и врачеватели. Исторически их
                существование оспаривается — по меньшей мере, существуют три пары таких святых, живших в разное время,
                но… Не у каждой профессии есть свой святой.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">6</span> Корректное название профессии аптекаря —
                фармацевт (среднее специальное медицинское образование) или провизор (высшее медицинское образование).
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">7</span> Coca-Cola своим происхождением обязана
                аптеке. Изобретателем напитка стал аптекарь Джон Пембертон. Другие знаменитые аптекари: Фридрих
                Сертюрнер, выделивший морфин; Джон Даун, впервые описавший синдром Дауна.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">8</span> Символы аптеки — сосуд Гигеи и посох
                Асклепия. Асклепий — бог медицины и врачевания у древних греков, Гигея его дочь. Змея используется в
                обоих символах — по легенде, она приносила своим хозяевам чудодейственные травы.
            </p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">9</span> В древности аптеки соседствовали либо с
                храмами, либо с винодельнями. Объединяло их активное использование трав — порой то, что не годилось для
                воскуривания богам, помогало лечить людей, а пары вина и прочие отходы производства виноделия так же
                помогали сохранять здоровье.</p>

            <p class="smallHeader"><span class="headerExplanation"></span></p>

            <p class=" usualText "><span class="headerExplanation">10</span> Долгое время аптеки, точнее, та их часть,
                что посвящена экспериментам и работе с травами, были центрами развития химии как науки. Здесь ставили
                эксперименты многие химики Средневековья, создавая новую науку, постепенно вышедшую из-под влияния
                фармацевтики.</p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>