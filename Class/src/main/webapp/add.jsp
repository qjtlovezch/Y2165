<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/9/1
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>添加常见问题</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    <center>
        <h1>添加常见问题</h1>


        标题：
        <select name="typeid">
            <c:forEach items="${typelist}" var="item">
                <option value="${item.typeid}">${item.typename}</option>
            </c:forEach>
        </select>
        <br/>
        分类：<input name="housedesc" required/>

        <br/>
        <br/>
        内容：<input name="monthlyrent" required/>
        <br/> <br/>
        </input>
        <input type="submit" required/>
        <button type="reset">重置</button>

    </center>

</form>

</body>
</html>
