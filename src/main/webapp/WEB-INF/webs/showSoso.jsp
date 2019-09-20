<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>使用嗖嗖</title>
</head>
<link rel="stylesheet" href="/statics/css/bootstrap.css">
<body>
<form class="form-inline " action="javaScript:void(0);" method="post">
    <table class="table" style="max-width:25%;" width="350" align="center" cellspacing="0" cellpadding="0">
        <caption><h2 align="center">使用嗖嗖</h2></caption>
        <tr>
            <td>手机号码：</td>
            <td>
                <input readonly="readonly"  class="form-control" type="text" name="cardNumber" value="${modile.cardNumber}">
            </td>
        </tr>
        <tr>
            <td>
                <input class="btn btn-success form-control" id="button" value="点击使用嗖嗖">
            </td>
            <td>
                <input class="btn btn-danger form-control" onclick="window.location.href='/index.html'" value="返回首页">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="myDiv" class="text-center">

                </div>
            </td>
        </tr>
    </table>
</form>

</body>

<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
<script>
    $(function () {

        $("#button").click(function () {
            $.get("/showSoso",null,function (result) {
                if (result!=null && result!="") {
                    $("#myDiv").html(result);
                }
            },"JSON");
        });
    });
</script>
</html>
