var actionUrl = "#";

var dummyData = ["Anders", "Vegard", "Runar"];

$(document).ready(function() {

    $.fn.extend({
        submitForm: function() {
            var skill = $(this).find("#skill").val();
            $.ajax({
                url: actionUrl,
                dataType: "json",
                data: skill
            }).done(function(data){
                $.printResult(dummyData, skill);
            });
            return false;
        },
        
        printResult: function(data, skillName) {
            $("#resultElement").empty();
            for(var i = 0; i < data.length; i++) {
                var person = data[i];
                $("#skillName").text(skillName);
                $("#resultElement").append("<li>" + person + "</li>");
            }
        }
    })
    
    //$("body").printResult(dummyData, "neo4j");

});