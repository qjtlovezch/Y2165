<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/7
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h3>添加图书</h3>
<form action="/BookServlet?action=add" method="post">
    <input name="bookName"/>
    <input name="bookPrice"/>
    <input type="submit" value="添加"/>
</form>

</body>
</html>
