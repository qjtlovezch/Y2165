<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/30
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        tr:nth-child(odd){
            background:palegreen;
        }


    </style>

</head>
<body>
<center>
    <h2>房屋信息查询</h2>
    <form action="${pageContext.request.contextPath}/dolist" method="post">


            <a href="${pageContext.request.contextPath}/type">发布房源</a>

            <table border="2px">
                <tr style="background: deepskyblue">
                    <th>序号</th>
                    <th>描述</th>
                    <th>户型</th>
                    <th>租金</th>
                    <th>发布时间</th>
                </tr>
                <c:forEach var="item" items="${houselist}">
                <tr>

                        <td>${item.houseid}</td>

                        <td>${item.housedesc}</td>

                    <td><a href="#">${item.housetypes.typename}</a></td>

                        <td>${item.monthlyrent}</td>

                        <td>${item.publishdate}</td>



                </tr>

                </c:forEach>
            </table>






    </form>
</center>

</body>
</html>
