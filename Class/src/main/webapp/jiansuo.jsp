<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/9/1
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<style type="text/css">
    tr:nth-child(odd){
        background:palegreen;
    }


</style>
<head>
    <title>常见问题检索</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dolist" method="post">
    <center>
        <h1>常见问题检索</h1>

        <c:forEach var="item" items="${houselist}">
            <p>分类：${item.housetypes.typename}</p>
            <p>添加时间：<fmt:formatDate value="${item.publishdate}" pattern="yyyy-MM-dd"/></p>
            <p>标题${item.housedesc}</p>

            <p>内容：${item.monthlyrent}</p>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/dolist">返回</a>

        </table>
    </center>
</form>

</body>
</html>
