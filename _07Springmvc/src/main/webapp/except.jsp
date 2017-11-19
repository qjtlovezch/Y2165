
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>系统异常</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/two" method="post">
    姓名:<input name="name"/><br/><br/>
    年龄:<input name="age"/><br/><br/>
    <input type="submit" value="注册"/>
</form>

</body>
</html>
