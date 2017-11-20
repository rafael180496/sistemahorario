$(document).ready(function () {

           $('select').material_select();
      
                    // for HTML5 \"required\" attribute\n" +
                    $("select[required]").css({
                        display: "inline",
                        position: "absolute",
                       height: 0,
                    padding: 0,
                        width: 0
                    });
                });