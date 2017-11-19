<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/11
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学员考勤</title>
</head>
<body>
<center>
    <h2>学员考勤</h2>
    <table>
        <tr>
            <td>学员姓名</td>
            <td>考勤时间</td>
            <td>出勤状态</td>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.stu.studentname}</td>
                <td>${datetimes}</td>
                <td>${item.att.attendancename}</td>
            </tr>
        </c:forEach>
    </table>
</center>


</body>
</html>
