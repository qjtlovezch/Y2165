<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/9/1
  Time: 14:04
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
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jQuery1.11.1.js">
</script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(
        function() {
            $("#myform").submit(function(){
                var username=$("#tiantian").val();


                if(username=="")
                {
                    alert("请选择标题！");
                    $("#tiantian").focus();
                    return false;
                }

            });

        });
</script>
<body>
<center>
    <h1>常见问题检索</h1>
    ${house}
    <form action="${pageContext.request.contextPath}/dolists" method="post">
        <input type="text" name="housedesc" value="${housedesc}">
        <input type="submit" value="查询">
        <a href="${pageContext.request.contextPath}/typelist">添加常见问题</a>
    </form>
    <form action="${pageContext.request.contextPath}/dolist" method="post">

        <table id="myform">
            <tr style="background: deepskyblue"align="center">
                <td>序号</td>
                <td>标题</td>
                <td>分类</td>
                <td>创建时间</td>
            </tr>
            <c:if test="${!empty houselist}">
                <c:forEach var="item" items="${houselist}">

                    <tr>
                        <td>${item.houseid}</td>
                        <td><a href="${pageContext.request.contextPath}/info/${item.houseid}">${item.housedesc}</a></td>
                        <td id="tiantian">${item.housetypes.typename}</td>
                        <td><fmt:formatDate value="${item.publishdate}" pattern="yyyy-MM-dd"/></td>
                    </tr>

                </c:forEach>
            </c:if>
            <tr>
                <td>
                <c:if test="${empty houselist}">
                       <h2>没有找到和"${housedesc}"相关的内容，<br>
                    &nbsp; &nbsp; &nbsp; &nbsp;请修改关键字后重试。</h2>

                </c:if>
            </td>
            </tr>

        </table>
    </form>
</center>
</body>
</html>
