<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/9
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>成绩查看</title>
</head>
<body>
<center>
    <h3>成绩查看</h3>
    <table  border="1">

        <tr>
            <td>姓名</td>
            <td>成绩</td>
            <td>班级</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="e">
            <tr>
                <td>${e.sname}</td>
                <td>${e.score}</td>
                <td>${e.cid}</td>
                <td><a href="/UserServlet?action=setstu&idss=${e.sid}">修改</a>
                    <a href="/UserServlet?action=deletestudent&ids=${e.sid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</center>

</body>
</html>
