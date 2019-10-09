<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="/statics/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="text-center table table-hover">
            <tr class="table-striped">
                <td><label><h2>欢迎登录</h2></label></td>
            </tr>
            <form class="form-inline" action="javaScript:void(0);" method="post">
                <label>手机号：</label><input class="form-control" name="cardNumber" placeholder="请输入手机号"/>
                <br>
                <br>
                <label>密&nbsp;&nbsp;&nbsp;码：</label><input class="form-control " type="password" name="passWord"
                                                           placeholder="请输入密码"/>
                <div class="form-inline" style="margin-top: 10px;">
                    <button class="btn btn-success" style="width: 11%;" type="submit">登录</button>
                    <button class="btn btn-danger" style="width: 11%" onclick="window.location.href='/index.html'">返回
                    </button>
                </div>
                <br>
                <p><a href="/userLogin.html">没有注册吗？点击注册！！！</a></p>
            </form>
        </div>
    </div>
</div>

</body>

<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        $("button[type='submit']").click(function () {
            var cardNumber = $("input[name='cardNumber']").val();
            var passWord = $("input[name='passWord']").val();

            if (cardNumber == null || cardNumber == '') {
                alert("手机号码不能为空！！！");
                return false;
            } else if (passWord == null || passWord == '') {
                alert("密码不能为空！！！");
                return false;
            } else if (passWord.length < 6) {
                alert("密码不能低于6位数！！！");
                return false;
            }
            $.get("/doLogin", {cardNumber: cardNumber, passWord: passWord}, function (result) {
                //alert(111);
                if ("erorrs" == result) {
                    alert("用户名或密码错误！！！");
                    return false;
                }
                if (result != null) {
                    window.location.href = "/index.html";
                }
            }, "JSON");
            return true;

        });
    });

</script>
</html>
