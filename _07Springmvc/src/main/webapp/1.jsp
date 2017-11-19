<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/four",
                    success:function (data) {
                       $.each(data,function (i,dom) {
                           alert(dom.name)
                       })
                    }
                });
            });
        });
    </script>
</head>
<body>
<input type="button" id="btn" value="Ajax"/>
</body>
</html>
