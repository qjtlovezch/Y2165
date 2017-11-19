<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/7/17
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {

            /*  var data={"name":"敖晴","age":20,"address":"北京某地"};
             alert(data.name);
             alert(data.age);
             alert(data.address);*/

            /* var data=[{"name":"敖晴","age":20,"address":"北京某地"},
             {"name":"本庆","age":22,"address":"北京某地"}];

             $.each(data,function (i,dom) {  // i数组中第几项  dom 数组中一个对象
             alert(dom.name);
             alert(dom.age);
             alert(dom.address);

             })*/

            var userArray = [ {
                "id" : 2,
                "name" : "admin",
                "pwd" : "123"
            }, {
                "id" : 3,
                "name" : "詹姆斯",
                "pwd" : "11111"
            }, {
                "id" : 4,
                "name" : "梅西",
                "pwd" : "6666"
            } ];
            //使用jquery在内存中构建一个table节点
            var $table = $("<table border='1'></table>")
            //在table内部追加一行  tr
                .append("<tr><td>ID</td><td>用户名</td><td>密码</td></tr>");
            $.each(userArray,function(i,dom) {
                $table.append("<tr><td>" + dom.id + "</td><td>"
                    + dom.name+ "</td><td>"
                    + dom.pwd + "</td></tr>");
            });
            $("#objectArrayDiv").append($table);
            $("[name=uname]").blur(function () {
                    //old();
              /*  $.ajax({
                    url:"/FirstServlet",
                    type:"POST",
                    data:"uname="+$("[name=uname]").val(),
                    success:function (data) {
                        $("#msg").html(data)
                    }
                })*/

                  $.post('/FirstServlet',"uname="+$("[name=uname]").val(),function (data) {
                 $("#msg").html(data);
                 });

              /*  $.getJSON('/FirstServlet',"uname="+$("[name=uname]").val(),function (data) {
                    $("#msg").html(data);
                });*/

                //$("#msg").load('/FirstServlet',{"uname":$("[name=uname]").val()});



               /* var data=$("#form1").serializeArray();
                $.each(data,function (i,dom) {
                    alert(dom.name+"\r\n"+dom.value);
                })*/
            });
        });


        function old() {
            var xhr=null;
            if(window.XMLHttpRequest){
                xhr=new XMLHttpRequest();
            }else {
                xhr=new ActiveXObject("Microsoft.XMLHTTP")
            }
            //alert(xhr);
            // xhr.open("get","/FirstServlet?uname="+$("[name=uname]").val(),true);
            xhr.open("post","/FirstServlet",true);
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4 && xhr.status==200){
                    var data=xhr.responseText;
                    $("#msg").html(data);
                }
            };
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xhr.send("uname="+$("[name=uname]").val());
            //xhr.send(null);
        }
    </script>
</head>
<body>

<form id="form1">
    <input name="uname"/><span id="msg"></span>
    <input name="upwd" value="000000"/>
</form>

<div id="objectArrayDiv"></div>
</body>
</html>
