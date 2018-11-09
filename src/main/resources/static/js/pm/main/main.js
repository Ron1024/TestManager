$(function(){
        //加载当前登录人员信息

        //获取当前目录列表
        var menulist = document.getElementById("side-menu");
        //创建新目录项
        var newLi = document.createElement("li");
        //通过函数调用目录，并添加到目录项中
        newLi.innerHTML="<a class=\"J_menuItem\" href=\"layouts.html\"><i class=\"fa fa-home\"></i> <span\n" +
            "                            class=\"nav-label\">主页</span></a>";
        //将目录项添加到目录列表中
        menulist.appendChild(newLi);

        //目录更新完成后加载首页到主页框中

});