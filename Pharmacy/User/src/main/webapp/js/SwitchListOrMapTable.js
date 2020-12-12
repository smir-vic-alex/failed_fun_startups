jQuery(document).ready(function ($) {

    var $list = jQuery("#listButton");
    var $map = jQuery("#mapButton");
    var $table = jQuery(".tables");
    var $workArea = jQuery("#workArea");
    $workArea.css("display","none");




    $list.click(function(){
        if($list.hasClass("buttonNotCheck")){
            $list.removeClass("buttonNotCheck");
            $list.addClass("buttonCheck");
            $map.removeClass("buttonCheck");
            $map.addClass("buttonNotCheck");
            $table.removeAttr("style");
            $workArea.css("display","none");
            $table.insertBefore($workArea);
        }
    });

    $map.click(function(){
        if($map.hasClass("buttonNotCheck")){
            $map.removeClass("buttonNotCheck");
            $map.addClass("buttonCheck");
            $list.removeClass("buttonCheck");
            $list.addClass("buttonNotCheck");
            $workArea.removeAttr("style");
            $table.css("display","none");
            $workArea.insertBefore($table);
        }
    });

});