var actionUrl = "#";

$(document).ready(function() {

    $.fn.extend({
        submitForm: function() {
            var skill = $(this).find("#skill").val();
            $.ajax({
                url: actionUrl,
                dataType: "json",
                data: skill
            }).done(function(data){
                for(var i = 0; i < data.length; i++) {
                    var person = data[i];
                    $("#resultElement").append("li").append(person);
                }
            });
            return false;
        }
    })

});