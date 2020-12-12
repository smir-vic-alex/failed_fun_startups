<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 07.05.2014
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="/jsp/header.jsp" %>
    <script type="text/javascript" src="../javaScript/ajax.js"></script>
    <script type="text/javascript" src="../javaScript/checkForm.js"></script>
    <title>Я пассажир</title>


</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/index.do"><img src="../images/logo.png"></a></div>
            <div class="form">
                <form>
                    <p>Ищу
                        <input type="radio"  name="who" value="0" checked> <span class="who"> Водителя</span>
                        <input type="radio"  name="who" value="1"><span class="who"> Пассажира</span>
                    </p>
                    <p>Откуда* <input id="from" class="textInput" type="text" name="startpoint"
                                      onkeyup="checkPassengerForm('from','where','date','month','agree','button')"
                                      onkeypress="checkPassengerForm('from','where','date','month','agree','button')"
                                      onchange="checkPassengerForm('from','where','date','month','agree','button')"
                                      placeholder="Город отправления"
                                      maxlength="25"> </p>

                    <p>Куда* <input id="where" class="textInput" type="text" name="finishpoint"
                                    onkeyup="checkPassengerForm('from','where','date','month','agree','button')"
                                    onkeypress="checkPassengerForm('from','where','date','month','agree','button')"
                                    onchange="checkPassengerForm('from','where','date','month','agree','button')"
                                    placeholder="Город прибытия"
                                    maxlength="25"></p>
                    <p>Месяц*
                        <select class="date" name="month" id="month"
                                onkeyup="checkPassengerForm('from','where','date','month','agree','button')"
                                onkeypress="checkPassengerForm('from','where','date','month','agree','button')"
                                onchange="checkPassengerForm('from','where','date','month','agree','button')">
                            <option value="0"></option>
                            <option value="1">Янв</option>
                            <option value="2">Фев</option>
                            <option value="3">Март</option>
                            <option value="4">Апр</option>
                            <option value="5">Май</option>
                            <option value="6">Июн</option>
                            <option value="7">Июл</option>
                            <option value="8">Авг</option>
                            <option value="9">Сен</option>
                            <option value="10">Окт</option>
                            <option value="11">Ноя</option>
                            <option value="12">Дек</option>
                        </select>
                    </p>
                    <p>День
                        <select class="date" name="day" id="date"
                                onkeyup="checkPassengerForm('from','where','date','month','agree','button')"
                                onkeypress="checkPassengerForm('from','where','date','month','agree','button')"
                                onchange="checkPassengerForm('from','where','date','month','agree','button')">
                            <option value="0"></option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>
                    </p>


                    <p class="agreement">
                        <input type="checkbox" id="agree" name="agree" onclick="checkPassengerForm('from','where','date','month','agree','button')"  >
                        <a href="${pageContext.request.contextPath}/agreement.do">Принимаю условия соглашения*</a>
                    </p>
                    <input id="button" type="button" class="textInput" value="Поехали" disabled="disabled" onclick="postAjax('${pageContext.request.contextPath}/getRecords.do',document.forms[0],'serverAnswer')">
                </form>
                <p style="font-size: 12pt; color: black;">* - поля обязательные для заполнения</p>
                <div id="serverAnswer" onchange="check()"></div>
            </div>
            <%@include file="/jsp/footer.jsp" %>
