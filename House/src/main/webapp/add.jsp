<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/30
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>发布房源</title>
</head>
<body>

<center>
<h2>发布房源</h2>
    <form action="${pageContext.request.contextPath}/type" method="post">
    <a href="${pageContext.request.contextPath}/dolist">返回首页</a><br>
    房屋描述：<input name="housedesc"/>

    <br>

    户型：
    <select name="typeid">
        <c:forEach items="${list}" var="aaa">
            <option value="${aaa.typeid}">${aaa.typename}</option>
        </c:forEach>
    </select>

    <br>
    租金：<input name="monthlyrent"/>元/月
    <br>
    <input type="submit"/>
    <input type="reset"/>
    </form>
</center>
</body>
</html>
