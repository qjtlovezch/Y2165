<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/UserServlet?action=login" method="POST">
    用户名：<input type="text" name="uname" class="input" />
    <br />
    密码：<input type="password" name="upwd"  class="input" />
    <br /><br />
    <input  type="submit" value="登录" class="login" />
</form>
</body>
</html>
