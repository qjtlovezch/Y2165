<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script type="text/javascript" src="js/jQuery1.11.1.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
      $(function () {
          $("#from").submit(function () {
              var id=$("[name=id]").val();
              var quantity=$("[name=quantity]").val();
              var handler=$("[name=handler]").val();

              if(!$.trim(id)&&!$.trim(quantity)&&!$.trim(handler)){
                  alert("操作失败！");
                  return false;
              }else if(!$.trim(id)&&!$.trim(quantity)){
                  alert("操作失败！");
                  return false;
              }else if (!$.trim(id)&&!$.trim(handler)){
                  alert("操作失败！");
                  return false;
              }else if (!$.trim(quantity)&&!$.trim(handler)){
                  alert("操作失败！");
                  return false;
              }else if(!$.trim(id)){
                  alert("操作失败！");
                  return false;
              }else if(!$.trim(quantity)){
                  alert("操作失败！");
                  return false;
              }else if (!$.trim(handler)){
                  alert("操作失败！");
                  return false;
              }else {
                 // alert("操作成功！");
                  return true;
              }
          })
      })
    </script>

</head>
<body>
<center>
    <h2>商品出库</h2>

    <form id="from" action="${pageContext.request.contextPath}/add" method="post">
    商品名称：
    <select name="id" >
        <option value="0">--请选择出库商品--</option>
        <c:forEach items="${list}" var="aaa">
        <option value="${aaa.id}">${aaa.productname}</option>
    </c:forEach>
    </select>
        <br>
        <br>
    数量：
    <input name="quantity" value="${myuicount}"/>
    <br/>
    <br/>
    &nbsp; &nbsp; 经手人：
    <input name="handler" value="${name}"/>
    <br/>
    <input type="submit" value="提交"/>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <input type="reset" value="重置"/>
    </form>
</center>

</body>
</html>
