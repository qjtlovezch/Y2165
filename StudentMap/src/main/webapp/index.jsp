<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>成绩系统</title>
</head>
<body>
<form method="post" action="">
    <div>
        <li class="banji">
            <a href="">班级管理</a>
            <dl class="two">
                <dd><a href="/addclass.jsp">添加班级</a></dd>
                <dd><a href="/UserServlet?action=class">班级列表</a></dd>
            </dl>
        </li>

        <li class="result">
            <a href="">成绩录入</a>
            <dl class="two1">
                <dd><a href="/UserServlet?action=list">成绩查看</a></dd>
            </dl>
        </li>
    </div>


</form>
</body>
</html>
