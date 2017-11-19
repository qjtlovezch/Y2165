<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/9
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
</head>
<body>
<form method="post" action="/UserServlet?action=updatstudent&sid=${score.sid}">
    学生姓名<input name="sname" value="${score.sname}"/>
    学生成绩<input name="score" value="${score.score}"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
