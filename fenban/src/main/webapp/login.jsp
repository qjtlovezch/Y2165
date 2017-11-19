<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
<h2>班级人员管理系统</h2>
<form action="/UserServlet?action=login" method="POST">
    登陆账号：<input type="text" name="uname" placeholder="请输入登录账号" />
    <br /> <br />
    登陆密码：<input type="password" name="upwd"  placeholder="请输入登录密码"/>
    <br /><br />
    <input  type="submit" value="登录" />
    &nbsp;&nbsp;&nbsp;
    <input  type="reset" value="重置" />


</form>
</center>
</body>
</html>
