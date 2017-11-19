<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2017-9-8
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>

<%--设置导出数据的个格式--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="application/msexcel; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--导出数据的文本名--%>
<%
    response.setHeader("Content-disposition","attachment; filename=stu.xls");

%>


<html>
<head>
    <title>Title</title>

    <meta http-equiv="Content-Type" content="application/msexcel;charset=utf-8"/>     <%--json导出的格式是application--%>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>

</head>
<body>

    <table border="0px" cellpadding="0" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>用户编码</th>
            <th>用户名称</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>电话</th>
            <th>地址</th>

        </tr>

        <c:forEach var="row" items="${list}">

        <tr>
         <th><c:out value="${row.id}"></c:out> </th>
            <th><c:out value="${row.userCode}"></c:out> </th>
            <th<c:out value="${row.userName}"></c:out>></th>
            <th><c:out value="${row.gender}"></c:out></th>
            <th><c:out value="${row.birthday}"></c:out></th>
            <th><c:out value="${row.phone}"></c:out></th>
            <th><c:out value="${row.address}"></c:out></th>


        </tr>
        </c:forEach>

    </table>




</body>
</html>
