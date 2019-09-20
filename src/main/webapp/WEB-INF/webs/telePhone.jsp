<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>话费充值</title>
</head>
<link rel="stylesheet" href="/statics/css/bootstrap.css">
<body>
<form class="form-inline " action="/updMoney.html" method="post">
    <table class="table" style="max-width:25%;" width="350" align="center" cellspacing="0" cellpadding="0">
        <caption><h2 align="center">话费充值</h2></caption>
        <tr>
            <th>需要充值的手机号：</th>
            <td><input class="form-control" type="text" readonly="readonly" name="cardNumber" value="${modile.cardNumber}"/></td>
        </tr>
        <tr>
            <th>请输入充值金额：</th>
            <td><input class="form-control" type="text" name="money" placeholder="请输入充值金额"></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input class="btn btn-success"style="width: 49%"  type="submit" value="提交">
                <input class="btn btn-danger" style="width: 49%" type="button" onclick="window.location.href='/index.html'" value="返回">
            </td>
        </tr>
    </table>
</form>
</body>
<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
<script>
    $(function () {
        $("input[value='提交']").click(function () {
            var money=$("input[name='money']").val();
            if (money==0 ||money==""){
                alert("请输入充值金额！！！");
                return false;
            }else if(isNaN(money)){
                alert("请输入合法数字！！！");
                return false;
            }else if(money<=-1){
                alert("请输入余额不能为负数！！！");
                return false;
            }else if(money<50){
                alert("充值余额最低为50元！！！");
                return false;
            }
            return true;
        });
    })
</script>
</html>
