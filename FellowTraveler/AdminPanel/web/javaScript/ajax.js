/**
 * Created by Денис on 04.05.14.
 */

function getXmlHttp() {
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function updatePage() {

}
/**
 *
 * @param path  URL запроса
 * @param method Метод запроса (Get или Post)
 * @param id ID блока, куда будет подгружаться страница
 */
function getDrivers(path, method, id) {
    var req = getXmlHttp();
    var statusElem = document.getElementById(id);
    document.getElementById(id).innerHTML= '<img src="images/ajaxloaderblack.gif" >';
    req.onreadystatechange = function () {
        // onreadystatechange активируется при получении ответа сервера
        if (req.readyState == 4) {
            // если запрос закончил выполняться

            statusElem.innerHTML = req.statusText // показать статус (Not Found, ОК..)

            if (req.status == 200) {
                // если статус 200 (ОК) - выдать ответ пользователю
                statusElem.innerHTML = req.responseText;
            }
            // тут можно добавить else с обработкой ошибок запроса
        }

    }

    req.open(method, path, true);
    // req.onreadystatechange = updatePage;
    req.send(null);
  //  statusElem.innerHTML = 'Ожидаю ответа сервера...'
}

