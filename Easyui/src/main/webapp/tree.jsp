<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <!-- 自己的js -->

    <script type="text/javascript">
        $(function(){
          if($("#222").text()==""){
              alert("自动跳转登录页面");
              window.location.href="login.do";
          }else {
              $("#menutree").tree({
                  url: "/one.do",
                  method: "post",
                  animate: true,
                  onClick: function (node) {
                      console.debug(arguments);
                      var text = node.text;
                      var icon = node.iconCls;

                      if (node.attributes && node.attributes.url) {
                          var url = node.attributes.url;


                          if ($("#mainTabs").tabs("exists", text)) {

                              $("#mainTabs").tabs("select", text);
                          } else {

                              $("#mainTabs").tabs
                              (
                                  "add", {
                                      title: text,
                                      iconCls: icon,
                                      closable: true,
                                      href: url
                                  }
                              )
                          }
                      }

                  }

              });
          }
        });
        function submit() {
            window.location.href="/tuichu.do";
        }
    </script>
    <script type="text/javascript" src="index.js"></script>
</head>
<body>

            <!-- 菜单树 -->
            <div id="cc" class="easyui-layout" style="width:600px;height:400px;" fit="true">
                <div data-options="region:'north',title:'North Title',split:false" style="height:100px;">
                   <center> <h1>超市账单管理系统</h1></center>
                </div>
                <div data-options="region:'south',title:'South Title',split:false" style="height:100px;">
                    <input type="button" value="退出" onclick="submit()">
                </div>

                <div data-options="region:'west',split:true" style="width:200px;">
                    <div id="aa" class="easyui-accordion" fit="true" >
                        <div title="系统菜单" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
                            <ul id="menutree">

                            </ul>
                                   </div>
                        <div title="帮助" data-options="iconCls:'icon-reload',selected:false" style="padding:10px;">
                            content2
                        </div>

                    </div>
                </div>
                <div data-options="region:'center'" style="background:#eee;">
                    <div id="mainTabs" class="easyui-tabs" fit="true"  border="false">
                        <div title="欢迎页面">
                            <div><span id="222">${user}</span>欢迎登陆<br>
                             <h1>${uppwd}</h1></div>
                        </div>
                    </div>
                </div>
            </div>

</body>
</html>
