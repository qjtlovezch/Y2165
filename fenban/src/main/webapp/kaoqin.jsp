<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/11
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>出勤操作</h1>
    <form action="/UserServlet?action=data" method="post">
        根据日期进行查询:<input type="date" name="time"/>
        <input type="submit" value="查询"/>
    </form>
</div>
<div align="center" id="id">
    <form action="/UserServlet?action=in" method="post">
        <table>
            <tr>
                <th align="center">学员姓名</th>
            </tr>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td align="center">${item.studentname}</td>
                    <td align="center"><input type="radio" name="${item.studentid}"
                                              value="1"/>出勤</td>
                    <td align="center"><input type="radio" name="${item.studentid}"
                                              value="2"/>未出勤</td>
                    <td align="center"><input type="radio" name="${item.studentid}"
                                              value="3"/>事假</td>
                    <td align="center"><input type="radio" name="${item.studentid}"
                                              value="4"/>病假</td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="提交"/>
    </form>

</div>


</body>
</html>
