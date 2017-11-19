<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tree</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#menutree").tree({
                url : "/one",
                method : "get",
                animate : true,
            });
        });
    </script>
    <script type="text/javascript" src="index.js"></script>
</head>
<body>

            <!-- 菜单树 -->
            <ul id="menutree">

            </ul>

</body>
</html>
