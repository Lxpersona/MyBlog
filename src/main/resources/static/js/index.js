$(function () {

    $("#loginDialog").on("show.bs.modal", function (event) {
        $("#loginForm").on("submit",function () {
            $.ajax({
                url: "/userLogin",
                data:$("#loginForm").serialize(),
                type: "POST",
                success: function (data) {
                    if (data==='success'){
                        window.location.reload();
                    }
                    else {
                        $("#loginInfo").empty().append("登陆失败，用户名或密码错误").css("color","red");
                    }
                }
            })
            return false;
        })
    })

    $("#contactEmailImg").on("mouseover",function () {
        $(".contactInfo").toggle();
        $("#contactEmailImg").toggle();
    })
    $(".contactInfo").on("mouseleave",function () {
        $("#contactEmailImg").toggle();
        $(".contactInfo").toggle();
    })
    $("#userImage").on("mouseover",function () {
        $(".userInfoBoard").toggle();
    })
    $(".userInfoBoard").on("mouseleave",function () {
        $(".userInfoBoard").toggle();
    })
 /*   $("#userImage").on("mouseleave",function () {
        $(".userInfoBoard").toggle();
    })*/
})