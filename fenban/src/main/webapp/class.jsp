<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/11
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>班级查询</title>
</head>
<body>
<center>
    <h2>欢迎来到考勤管理系统</h2>
    <form action="/UserServlet?action=student" method="post" >
    考勤人员查询：
    <select name="id">
        <option value="0">请选择班级</option>
        <c:forEach items="${list}" var="aa">
            <option value="${aa.classesid}">${aa.classesanem}</option>
        </c:forEach>
    </select>
    <button type="submit">查询</button>
</form>

</center>

</body>
</html>
