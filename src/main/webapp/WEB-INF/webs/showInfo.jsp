<%@ page import="org.springframework.mock.web.MockHttpSession" %>
<%@ page import="cn.bdqn.pojo.Modile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
    <link rel="stylesheet" href="/statics/css/bootstrap.css">
</head>
<body>

<div class="container">
    <div class="row">
        <h1 style="color: ${modile!=null?'red':null}">Hello:${modile.userName}</h1>
        <div class="row col-md-12 col-xs-12">
            <p align="center"><h2 class="text-center">欢迎使用搜搜移动业务大厅</h2></p>
        </div>
        <div class="list-group col-md-1 col-xs-12">
            <ul class="input-group text-center">
                <li class="list-group-item  btn-info">
                    <a href="/doLogin.html">用户登录</a>
                </li>
                <li class="list-group-item  btn-success">
                    <a href="/userLogin.html">用户注册</a>
                </li>
                <li class="list-group-item  btn-primary">
                    <a href="/showSoso.html">使用嗖嗖</a>
                </li>
                <li class="list-group-item  btn-warning">
                    <a href="/telePhone.html">充值话费</a>
                </li>
                <li class="list-group-item  btn-default">
                    <a href="/description.html">资费说明</a>
                </li>
                <li class="list-group-item  btn-danger">
                    <a href="javaScript:void(0);" onclick="sysClose();">退出系统</a>
                </li>
            </ul>
        </div>
        <div class="col-md-11 col-xs-12">
            <table class="table text-center" align="center">
                <tr align="center">
                    <th colspan="10" align="center"><h2 class="text-center"><a href="/showUser.html">用户信息</a></h2></th>
                    <th colspan="10"  align="right"><input class="btn btn-success"  style="width: 100%" type="button" onclick="window.location.href='/index.html' " value="刷新页面"></th>
                </tr>
                <tr align="center">
                    <th>编号</th>
                    <th>手机号</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>套餐名称</th>
                    <th>余额</th>
                    <th>已使用余额</th>
                    <th>已使用通话时间</th>
                    <th>已使用短信条数</th>
                    <th>已使用流量</th>
                </tr>
                <c:forEach var="li" items="${lists}">
                    <tr align="center"  class="form-inline">
                        <td>${li.id}</td>
                        <td>${li.cardNumber}</td>
                        <td>${li.userName}</td>
                        <td>${li.passWord}</td>
                        <td>${li.pas.name}</td>
                        <td>${li.money}元</td>
                        <td>${li.sonsumAmount}元</td>
                        <td>${li.realTalkTime}(分钟)</td>
                        <td>${li.realSMSCount}(条数)</td>
                        <td>${li.realFlow}(GB)</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row col-md-12 col-xs-12">
                <p align="center" style="color: red">${mess}</p>
            </div>
        </div>
    </div>
</div>
</body>

<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
<script type="text/javascript">
    function sysClose() {
        if (confirm("确定退出嘛？")){
            $.get("/exitSystem",null,function (result) {
                if (result>0) {
                    window.opener;
                    window.open('',"_self");
                    window.close();
                }
            },"JSON");

        }
    }
</script>
</html>
