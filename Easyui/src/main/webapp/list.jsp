<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/5
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
 <div class="easyui-layout">
     <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
     <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
     <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
     <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
     <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>

 </div>
</body>
</html>
