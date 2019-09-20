<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>嗖嗖移动用户菜单</title>
</head>
<link rel="stylesheet" href="/statics/css/bootstrap.css">
<body>

<div class="container">
    <div class="row">
        <div class="row col-md-12 col-xs-12">
            <p align="center">
            <h2 class="text-center">嗖嗖移动用户菜单</h2></p>
        </div>
        <div class="list-group col-md-2 col-xs-12">
            <ul class="input-group text-center">
                <li class="list-group-item">
                    <button class="btn btn-default" type="button" name="myInput" value="本月账单查询">本月账单查询</button>
                </li>
                <li class="list-group-item">
                    <button class="btn btn-danger" type="button" name="myInput" value="套餐余额查询">套餐余额查询</button>
                </li>
                <li class="list-group-item">
                    <button class="btn btn-success" type="button" name="myInput" value="打印消费详单">打印消费详单</button>
                </li>
                <li class="list-group-item">
                    <button class="btn btn-warning" style="width: 100%" type="button" name="myInput" value="套餐变更">套餐变更</button>
                </li>
                <li class="list-group-item">
                    <button class="btn btn-primary" style="width: 100%" type="button" name="myInput" value="办理退网">办理退网</button>
                </li>
            </ul>
        </div>
        <div class="col-md-10 col-xs-12">
            <table class="table text-center" align="center">
                <tr align="center">
                    <th colspan="10" align="center"><h3 id="myH" class="text-center">***用户套餐信息***</h3></th>
                    <th colspan="10" align="right"><input class="btn btn-danger" style="width: 100%" type="button"
                                                          onclick="window.location.href='/index.html'" value="返回首页">
                    </th>
                    <th colspan="10" align="right"><input class="btn btn-primary" style="width: 100%" type="button"
                                                          onclick="window.location.href='/doLogin.html'" value="返回登录">
                    </th>
                </tr>
                <tr>
                    <td>
                        <div id="divMy">

                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
<script>
    var paId=0;
    function getValue1() {
        paId=$(".myButton1").val();
        if (paId==${modile.pas.paId}){
            alert("对不起，您已经是该套餐用户，无需变更套餐！！！");
            return false;
        }else{
            showAjx(paId);
        }
    }
    function getValue2() {
        paId=$(".myButton2").val();
        if (paId==${modile.pas.paId}){
            alert("对不起，您已经是该套餐用户，无需变更套餐！！！");
            return false;
        }else{
            showAjx(paId);
        }
    }
    function getValue3() {
        paId=$(".myButton3").val();
        if (paId==${modile.pas.paId}){
            alert("对不起，您已经是该套餐用户，无需变更套餐！！！");
            return false;
        }else{
            showAjx(paId);
        }

    }

    $(function () {
        $("#myDiv").css("display", "block");
        $("button[name='myInput']").click(function () {
            $("#myH").html("***" + this.value + "***");
            $.get("/showUser", {name: this.value}, function (result) {
                if (result != null || result != '') {
                    $("#divMy").html(result);
                    return false;
                }
            }, "JSON");
        });


    });

    function showAjx(paId) {
        $.get("/updPas", {paId:paId}, function (result) {
            if (result != null || result != '') {
                $("#divMy").append(result);
            }
        }, "JSON");
    }

</script>
</html>
