jQuery(document).ready(function($){

    var $search =  jQuery("#searchText");

    $search.autocomplete({
        source:function(request, response){
            jQuery.ajax({
                url: path + "/autoComplete.do" ,
                type: "POST",
                data: "searchString=" + $search.val(),
                dataType: "json",
                success: function(data){
                    response(data);
                }
            })},
        select: function( event, ui ) {
            $("#inputID").val(ui.item.id);
        },
        delay: 300,
        minLength: 3
    })
});