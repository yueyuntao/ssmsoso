<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>资费说明</title>
</head>
<link rel="stylesheet" href="/statics/css/bootstrap.css">
<body>
<div align="center">
    <h1 style="font-weight: bolder">资费说明</h1>
    <c:forEach var="li" items="${list}">
        <p>${li}</p>
    </c:forEach>
    <input class="btn btn-danger" style="width: 15%" type="button" value="返回" onclick="window.location.href='/index.html'">
</div>
</body>
<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/bootstrap.js"></script>
</html>
