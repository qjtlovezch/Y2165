<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<s:form action="upload" enctype="multipart/form-data" method="POST">
    <s:file name="file" label="选择文件"/>
    <s:submit name="submit" value="上传"/>
</s:form>
</body>
</html>
