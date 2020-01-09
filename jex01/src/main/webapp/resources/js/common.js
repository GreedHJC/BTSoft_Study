
   $('#loginform').on('submit', function () {
      var userid = $('input[name=username]').val();
      var userpw = $('input[name=password]').val();
      var check = $('.check-form-none').length;
      var submitbol;

      $.ajax({
         url: "/logincheck",
         type: "post",
         dataType: 'text',
         data: {userid: userid, userpw: userpw},
         timeout: 10000,
         async: false,
         success: function (res) {
            if (res == "1") {
               submitbol = true;
            }else if(check == 0) {
               $('input[name=password]').after($('<div class="check-form-none">'
                   + '<span>'+res+'</span></div>'));
            }else if(check > 0) {
               $('.check-form-none').remove();
               $('input[name=password]').after($('<div class="check-form-none">'
                   + '<span>'+res+'</span></div>'));
            }
         }
      });

      if(submitbol == true) {
         return true;
      }
      return false;
   });

   $('.message a').click(function(){
      $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
   });
   
   /** 날짜 변환 **/
   function convertDateFormat(data){
	   var date = new Date(data);
	   var year = date.getFullYear();
	   var month = date.getMonth()+1;
	   var day = date.getDate();
	   
	   return year+"-"+month+"-"+day;
   }