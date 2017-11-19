<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/9
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>班级列表</title>
</head>
<body>
<center>
    <h3>班级列表</h3>
    <table  border="1">

        <tr>
            <td>班级编号</td>
            <td>班级名称</td>

            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="e">
            <tr>
                <td>${e.cid}</td>
                <td>${e.cname}</td>

                <td><a href="">修改</a>
                    <a href="">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</center>

</body>
</html>
