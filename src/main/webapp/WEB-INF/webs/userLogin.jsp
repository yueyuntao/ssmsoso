<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="/statics/css/bootstrap.css">

</head>
<body>

<form action="/addUserLogin.html" class="form-inline">
    <table class="table" style="max-width:25%;" width="400px" align="center" cellspacing="0" cellpadding="0" >
        <caption><h2 align="center" >用户注册</h2></caption>
        <tr align="center">
            <th class="text-center" colspan="2" align="center">***可选择号码***</th>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <c:forEach var="li" varStatus="i" items="${numberList}">
                    <input class="form-control" type="button" name="myInput" value="${li}"/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th>选择的手机号是：</th>
            <td><input  class="form-control" type="text" placeholder="选择的手机号是" readonly="readonly" name="cardNumber" value=""/></td>
        </tr>
        <tr>
            <th>请选择手机套餐：</th>
            <td>
                <select name="pas.paId"  class="form-control" style="width: 100%">
                    <option  value="0">请选择手机套餐</option>
                    <option  value="1">话痨套餐</option>
                    <option  value="2">网虫套餐</option>
                    <option  value="3">超人套餐</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>请输入姓名：</th>
            <td><input  class="form-control" placeholder="请输入姓名" type="text" name="userName"></td>
        </tr>
        <tr>
            <th>请输入密码：</th>
            <td><input  class="form-control"placeholder="请输入密码" type="text" name="passWord"></td>
        </tr>
        <tr>
            <th>请输入预存话费金额：</th>
            <td><input  class="form-control" placeholder="请输入预存话费金额" type="text" name="money"></td>
        </tr>
        <tr  align="center">
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
<script type="text/javascript">
    $(function () {
        $("input[name='myInput']").click(function () {
            $("input[name='cardNumber']").val(this.value);
        });

        $("input[name='money']").blur(function () {
            checkMoney();
        })

        $("input[value='提交']").click(function () {
            var cardNumber=$("input[name='cardNumber']").val();
            var paId=$("select[name='pas.paId']").val();
            var userName=$("input[name='userName']").val();
            var passWord=$("input[name='passWord']").val();
            var money=$("input[name='money']").val();
            if (cardNumber==null ||cardNumber==""){
                alert("请选择手机号码！！！");
                return false;
            }else if(paId=="0"){
                alert("请选择手机套餐！！！");
                return false;
            }else if(userName==""){
                alert("用户名不能为空！！！");
                return false;
            }else if(passWord==""){
                alert("密码不能为空！！！");
                return false;
            }else if(money=="" || money=="0"){
                alert("预存话费不能为空和0！！！");
                return false;
            }
            return true;
        });
    });

    function checkMoney() {
        var paId=$("select[name='pas.paId']").val();
        var money=$("input[name='money']").val();
        var moneys=0;
        if (paId==1){
            moneys=58;
        } else if(paId==2){
            moneys=68;
        }else{
            moneys=78;
        }
        if (money<moneys){
            alert("预存金额不足以支付所选套餐一个月资费，请重新输入！！！");
            $("input[name='money']").val("");
            return false;
        }
    }
</script>
</html>
