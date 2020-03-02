
(function ($) {
    "use strict";


     /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    $('.validate-form').on('submit',function(){
        var check = true;
        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
		var allphone = /^((13[0-9])|(15[0-9])|(18[0-9]))[0-9]{8}$/;	//手机
		var email = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/; //邮箱
        var idcard = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;	//身份证
		var chinese = /^[\u4e00-\u9fa5]+$/; //多个中文
		if($(input).attr('name') == 'user_info_email') {
            if($(input).val().trim().match(email) == null) {
                return false;
            }
        }
		else if($(input).attr('name') == 'user_info_idcard') {
		    if($(input).val().trim().match(idcard) == null) {
		        return false;
		    }
		}
		else if($(input).attr('name') == 'user_info_tel') {
		    if($(input).val().trim().match(allphone) == null) {
		        return false;
		    }
		}
		else if($(input).attr('name') == 'user_info_job'||$(input).attr('name') == 'user_info_addr') {
		    if($(input).val().trim().match(chinese) == null) {
		        return false;
		    }
		}
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);