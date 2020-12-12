/**
 * Created by Виктор on 28.03.2015.
 */
var $popUpCheckCity;
/**
 * Инициализация всплывашки уточнения города
 */
function initPopUp(){

    $(".popUpChangeCityCross").click(function(){
        var $this= $(this);
        var window = $this.parents(".windowMarker");
        window.hide();
    });
    $("#popUpChangeCityAnswerYes").click(function(){
        $popUpCheckCity.hide();
    });
    $popUpCheckCity.animate({
        opacity:1
    }, 900);

    $("#popUpChangeCityAnswerNo").click(function(){
        $popUpCheckCity.hide();
        var $toner = $("#toner");
        var win_h = $("html").height();
        $toner.height(win_h);
        $toner.show();
    });
}

function sendRequestOnChangeCity(changeCity){
    var id = changeCity.attr("id");
    $.ajax({
        url: path + "/changeCity.do" ,
        type: "POST",
        data: "id=" + id,
        dataType: "json",
        success: function(data){
            if(data.success){
                $("#currentCity").html(changeCity.html());
            }
        }
    })
}

jQuery(document).ready(function () {
    var changeCity;
    $(".changeCityLink").click(function(){
        sendRequestOnChangeCity($(this));
    });
    $(".popUpSelectCityBigCity").click(function(){
        var $changeCity = $(this);
        sendRequestOnChangeCity($changeCity);
        var window = $changeCity.parents(".windowMarker");
        window.hide();
    });
    $popUpCheckCity = $("#popUpCheckCity");
    initPopUp();

});