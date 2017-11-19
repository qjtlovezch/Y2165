<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/1
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript">
        function tui() {
            window.location.href="/list.do";
        }
    </script>
</head>
<body >
<h1>详细异常</h1>
<c:forEach items="${list}" var="item">
    分类： <span>${item.types.typename}</span>
    <br>
    时间：<span>${item.date}</span>
    <br>
    标题：<span>${item.housedesc}</span>
    <br>
    内容：<textarea name="content" id="content" >${item.content}</textarea>
    <br>
<input  type="button" value="返回" onclick="tui()">
</c:forEach>
</body>
</html>
