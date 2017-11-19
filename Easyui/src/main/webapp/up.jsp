<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/1
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.js"></script>

</head>
<body>
<script type="text/javascript">
    function su() {
        var bh= $("#2").val();
        var name= $("#1").val()

        $.ajax({
            type: "post",
            url: "/uppwd.do",
            data: {"pwd": bh, "pwds": name},
            success: function (date) {

                if(date>0) {
                    $("#3").text("修改成功");
                }else {
                    $("#3").text("修改失败");
                }
            }
        });
    }
    function sunbmit() {
        var flag=true;


        return flag;
    }
</script>
 <center>
     <h1>添加常见问题</h1>
 </center>

      原密码:<input type="password" id="2" name="pwd">
         新密码:<input type="password"id="1" name="pwds">
         <input type="button" onclick=" javascript:su()" value="提交">
            <br>
         <p id="3"></p>


</body>
</html>
