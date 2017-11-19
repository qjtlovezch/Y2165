<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<form action="/UserInfoServlet?action=login" method="POST">
    用户名：<input type="text" name="uname" class="input" />
    <br />
    密码：<input type="password" name="upwd"  class="input" />
    <br /><br />
    <input name="submit" type="submit" value="登录" class="login" />
</form>
</body>
</html>
