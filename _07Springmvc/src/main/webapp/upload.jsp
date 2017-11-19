<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/8/30
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>文件上传</h1>
<form action="/two" method="post" enctype="multipart/form-data">
    文件1   <input type="file" name="upload"/><br>
    文件2   <input type="file" name="upload"/><br>
    文件3   <input type="file" name="upload"/>
    <br>
    <input type="submit"/>
</form>

</body>
</html>
