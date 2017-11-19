<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>后台管理系统</title>

    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div class="login_wrapper">
    <h1>APP信息管理平台</h1>
    <div>
        <a href=<%=path%>"/WEB-INF/jsp/backendlogin.jsp" class="btn btn-link">后台管理系统 入口</a>
    </div>
    <div>
        <a href=<%=path%>"/WEB-INF/jsp/devlogin.jsp" class="btn btn-link">开发者平台 入口</a>
    </div>
</div>
</body>
</html>