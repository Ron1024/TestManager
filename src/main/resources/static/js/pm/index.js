$(function(){

    $('#login').click(function(){
        var user = $('#username').val();
        var pwd = $('#password').val();
        if(user == ''|| pwd== '')
        {
            $('#username').focus();
            $('#erromsg').css('display','block');
            $('#erromsg').html("<strong>用户名或密码不能为空<strong>");
            return false;
        }else{
            $.ajax({
                url: "/login",
                data:{'userName':user,'password':pwd},
                type: "POST",
                dataType:'json',
                success:function(data){
                    if(data.result == 'success'){
                        window.location.href = "/main/gotoMainPage.shtm";
                    }else {
                        $('#erromsg').css('display','block');
                        $('#erromsg').html("<strong>用户名或密码错误！<strong>");
                    }

                },
                error : function(data) {
                    alert("出错：" + data.code);
                }
            });
        }
    });

});