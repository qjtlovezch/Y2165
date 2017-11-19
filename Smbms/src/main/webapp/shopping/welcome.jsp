<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/style.css"/>

</head>
<body>
<!--头部-->
<%--<%
if(request.getSession().getAttribute("username")==null){
    String aa="您尚未登录，请先登录！！！";
request.setAttribute("aa",aa);

    request.getRequestDispatcher("/shopping/login.jsp").forward(request,response);

}
%>--%>
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span style="color: #fff21b"> <%=request.getSession().getAttribute("userinfo")%> </span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/shopping/login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath}/getbill">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/provider/provlist">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/pwd">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath}/shopping/img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2><%=request.getSession().getAttribute("userinfo")%></h2>
            <p>欢迎来到超市账单管理系统!</p>
        </div>
    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="${pageContext.request.contextPath}/shopping/js/time.js"></script>
</body>
</html>