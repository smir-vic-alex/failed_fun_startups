/**
 * Created by Виктор on 24.05.2014.
 */

function isConsistOfRussianLetters(s) {
    var i;

    for (i = 0; i < s.length; i++) {
        if ('а'.charCodeAt(0) <= s.charCodeAt(i) && s.charCodeAt(i) <= 'я'.charCodeAt(0) ||
            'А'.charCodeAt(0) <= s.charCodeAt(i) && s.charCodeAt(i) <= 'Я'.charCodeAt(0)) {

        } else {
            return false;
        }
    }
    return true;
}
/**
 * Проверка на пустоту
 * @param s
 * @returns {boolean}
 */
function recordIsCorrect(s) {
    if (s != "" && s != null) {
        return true;
    }
    return false;
}
/**
 *  Проверка корректности даты
 * @param day
 * @param month
 * @returns {boolean}
 */
function dateIsCorrect(day, month) {
    if (month != null) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (0 <= day && day <= 31) {
                    return true;
                }
                return false;
            case 4:
            case 6:
            case 9:
            case 11:
                if (0 <= day && day <= 30) {
                    return true;
                }

                return false;
            case 2:
                if (0 <= day && day <= 28) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
    return false;
}
/**
 * Проверка корректности адреса на страницу ВК
 * @param vkId
 * @returns {boolean}
 */
function recordVKidIsCorrect(vkId) {
    if (vkId.indexOf("http://vk.com/") == 0 || vkId.indexOf("vk.com/") == 0) {
        return true;
    }
    return false;
}
/**
 * Не превышает
 * @param s
 * @param length
 * @returns {boolean}
 */
function doesNotExceed(s, length) {
    if (s.length <= length) {
        return true;
    }
    return false;
}
/**
 * Совпадает
 * @param s
 * @param expectedValue
 * @returns {boolean}
 */
function isCoincides(s, expectedValue) {
    if (s != null && s == expectedValue) {
        return true;
    }
    return false;
}
/**
 * Печатает сколько символов осталось для ввода
 * @param commentField
 * @param idMessage
 */
function showNumberCharacters(commentField, idMessage) {

    var i = 100 - commentField.value.length;
    if (i <= 30) {
        idMessage.innerHTML = "Осталось " + i + " символов";
    } else if (30 < i && i <= 100) {
        idMessage.innerHTML = "";
    }
}
/**
 *  Проверка на корректность всех полей формы пассажира
 * @param fromId
 * @param whereId
 * @param dateId
 * @param monthId
 * @param agreeId
 * @returns {boolean}
 */
function passengerFormIsCorrect(fromId, whereId, dateId, monthId, agreeId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var day = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    if (recordIsCorrect(from.value) && recordIsCorrect(where.value) &&
        dateIsCorrect(parseInt(day.value), parseInt(month.value)) && isCoincides(agree.value, 'true')) {
        return true;
    }
    return false;
}
/**
 * Проверка на корректность всех полей формы водителя
 * @param fromId
 * @param whereId
 * @param dateId
 * @param monthId
 * @param agreeId
 * @param vkIdId
 * @param commentId
 * @returns {boolean}
 */
function driverFormIsCorrect(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var date = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    var vkId = document.getElementById(vkIdId);
    var comment = document.getElementById(commentId);
    if (recordIsCorrect(from.value) && recordIsCorrect(where.value) && dateIsCorrect(parseInt(date.value), parseInt(month.value))
        && recordVKidIsCorrect(vkId.value) && doesNotExceed(comment.value, 100) && isCoincides(agree.value, 'true')) {
        return true;
    }
    return false;
}
/**
 * Анализ корректности формы пассажира
 * @param fromId
 * @param whereId
 * @param dateId
 * @param monthId
 * @param agreeId
 * @param buttonId
 */
function checkPassengerForm(fromId, whereId, dateId, monthId, agreeId, buttonId) {
    if (document.getElementById(agreeId).checked) {
        document.getElementById(agreeId).value = 'true';
    } else {
        document.getElementById(agreeId).value = '';
    }
    passengerFormIsCorrect(fromId, whereId, dateId, monthId, agreeId) ?
        document.getElementById(buttonId).disabled = false : document.getElementById(buttonId).disabled = true;
}
/**
 * Анализ корректности формы водителя
 * @param fromId
 * @param whereId
 * @param dateId
 * @param monthId
 * @param agreeId
 * @param vkIdId
 * @param commentId
 * @param buttonId
 */
function checkDriverForm(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId, buttonId, idTest) {
    showNumberCharacters(document.getElementById(commentId), document.getElementById(idTest)); // Прописал явно, т.к. только так работает
    if (document.getElementById(agreeId).checked) {
        document.getElementById(agreeId).value = 'true';
    } else {
        document.getElementById(agreeId).value = '';
    }
    driverFormIsCorrect(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId) ?
        document.getElementById(buttonId).disabled = false : document.getElementById(buttonId).disabled = true;
}