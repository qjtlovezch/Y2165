<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/27
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>类型转换</h1>
<form action="${pageContext.request.contextPath }/one" method="post">
    出生日期:<input name="birthday" value="${birthday}"/><br/><br/>
    年龄:<input name="age" value="${age}"/><br/><br/>
    <input type="submit" value="注册"/>
</form>

</body>
</html>
