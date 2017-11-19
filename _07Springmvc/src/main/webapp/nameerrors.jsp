<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>错误页面</title>
  </head>
  
  <body>
       <h1>用户名错误</h1>
       ${ex.message }
  </body>
</html>
