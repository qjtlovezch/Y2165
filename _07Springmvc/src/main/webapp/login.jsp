<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/Area" method="post">
    用户名<input name="uname"/>
   <%-- <input name="book.bookname"/>--%>
    书名1<input name="books[0].bookname"/>
    书名2<input name="books[1].bookname"/>
    <input type="submit"/>
</form>
</body>
</html>
