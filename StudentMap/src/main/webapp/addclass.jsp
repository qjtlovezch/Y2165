<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/9
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级</title>
</head>
<body>

<form action="/UserServlet?action=addclass" method="post">
    班级编号：
    <input name="cid"/>
    <br>
    <br>
    班级名称：
    <input name="cname"/>
    <br>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
