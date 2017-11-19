<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> <%=request.getSession().getAttribute("userinfo")%></span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/getbill">账单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/provider/provlist">供应商管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/pwd">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>

        <div class="providerView">
            <c:forEach var="item" items="${useridlist}">
                <p><strong>用户编号：</strong><span>${item.userCode}</span></p>
                <p><strong>用户名称：</strong><span>${item.userName}</span></p>
                <p><strong>用户性别：</strong><span>
                <c:if test="${item.gender==1}">
                    <td>男</td>
                </c:if>

                 <c:if test="${item.gender==2}">
                     <td>女</td>
                 </c:if></span></p>
                <p><strong>出生日期：</strong><span>${item.birthday}</span></p>
                <p><strong>用户电话：</strong><span>${item.phone}</span></p>
                <p><strong>用户地址：</strong><span>${item.address}</span></p>
                <p><strong>用户类别：</strong><span>
                <c:if test="${item.userRole==0}">
                    <td>经理</td>
                </c:if>

                    <c:if test="${item.userRole==1}">
                        <td>董事长</td>
                    </c:if>
            </span></p>
            </c:forEach>
            <a href="${pageContext.request.contextPath}/user/dolist">返回</a>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>

</body>
</html>
