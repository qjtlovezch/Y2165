<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/11/08
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page import="cn.tms.entity.PostingDetails" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<%--百度编辑器--%>
<script type="text/javascript">
    var ue = undefined;
    $(function () {
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        ue = UE.getEditor('editor');

        ue.addListener("ready", function () {
            // editor准备好之后才可以使用
            ue.setContent('${detail.contents}');
        });
    });
    /**
     * 返回是有标签修改 列如    H1
     * @returns {Array}
     */
    function getContent() {
        var arr = [];
        arr.push(UE.getEditor('editor').getContent());
        return arr;
    }
</script>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/demo/demo.css">

<%--百度编辑器需要的jQuery插件--%>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ajaxfileupload_JS_File/ajaxFileupLoads.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ajaxfileupload_JS_File/jquery-1.7.1.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/static/ajaxfileupload_JS_File/jquery.form.js"></script>
<%@page import="cn.tms.entity.PostingDetails" %>
<script type="text/javascript">
    jQuery.noConflict();
    $(function () {

        var id = undefined;
        $('#cc').combotree({
            url: '${pageContext.request.contextPath}/content/getCombotList',
            valueField: 'id',
            textField: 'text',
            parentField: 'pid',
            onBeforeExpand: function (node, param) {

                //$(this).tree('options').url =
                //   '${pageContext.request.contextPath}/content/getCombotList';
            },
            onLoadSuccess: function (node, data) {
                // 修改         alert('成功了');
                //100是id      请选择所属栏目    comboTree  默认值
                var columnname = undefined;
                var columncode = undefined;
                <% PostingDetails details=  (PostingDetails)request.getAttribute("detail");%>

                <%
                 if (details!=null){
                %>
                columnname = '<%=details.getContent().getColumnname()%>';
                columncode = '<%=details.getContent().getColumnname()%>';
                <%
                }
                %>


                if (columnname != null) {
                    defaultCheck(columnname, columncode);

                }
                else {
                    defaultValue('cc', '100', '请选择所属栏目');//这个方法就是解决默认值的问题核心
                }
            }
        });
    })

    //为combotree增加默认值隐藏节点，解决因异步加载导致默认值id直接显示到文本框中的问题
    //cbtid:combotree的id
    //defval:生成节点的id
    //deftext：生成节点的文本用于显示
    function defaultValue(cbtid, defVal, defText) {
        var combotree = $("#" + cbtid);
        var tree = combotree.combotree('tree');
        var defNode = tree.tree("find", defVal);
        if (!defNode) {
            tree.tree('append', {
                data: [{
                    id: defVal,
                    text: defText
                }]
            });
            defNode = tree.tree("find", defVal);
            combotree.combotree('setValue', defVal);
            tree.tree('select', defNode.target);
            defNode.target.style.display = 'none';
        } else {
            combotree.combotree('setValue', defVal);
        }
    }

    //获取comboTree选中的节点的id
    function getComboTree() {
        var t = $('#cc').combotree('getValues')[0];
        return t;
    }


    function defaultCheck(name, colmuncode) {

        var node = $('#cc').combotree('tree');
        var roots = node.tree('getRoots'), i, j;
        var children = undefined;
        var nodes = undefined;



        nodes = $('#cc').combotree('tree').tree('find', colmuncode);
        $('#cc').combotree('tree').tree('check', nodes.target);


    }


    //上传图片
    function uploadPic(num) {
        var form = new FormData(document.getElementById("form2"));
        var file = form.get('file');

        var ids = getComboTree();

        var text = getContent();


        if (ids == 100) {
            $.messager.alert("操作失败", "请选择所属栏目!!!");
            return false;
        }

        if ($.isEmptyObject(file)) {
            $.messager.alert("操作失败", "请选择图片!!!");
            return false;
        } else {
            if (text == null) {
                $.messager.alert("操作", "请填写正文!!!");
                return false;
            } else {

                form.append("text", text);
                form.append("sysCode", ids);
                form.append("operation", num);

                // var oper = '';


                if ('${oper}' == '修改') {
                    form.append("execute", "m");

                }else{
                    form.append("execute", "i");

                }

                $.ajax({
                    url: "${pageContext.request.contextPath}/content/addDetail",
                    type: "post",
                    data: form,
                    processData: false,
                    contentType: false,
                    success: function (data) {

                        // window.clearInterval(timer);
                        $.messager.alert("操作", "添加成功！！");

                        parent.$('#bg').datagrid("reload");

                    },
                    error: function (e) {
                        $.messager.alert("操作", "添加错误！！");
                    }
                });
            }
        }
    }
    /**
     * 图片预览
     * @param e
     */
    function changImg(e) {
        for (var i = 0; i < e.target.files.length; i++) {
            var file = e.target.files.item(i);
            if (!(/^image\/.*$/i.test(file.type))) {
                continue; //不是图片 就跳出这一次循环
            }
            //实例化FileReader API
            var freader = new FileReader();
            freader.readAsDataURL(file);
            freader.onload = function (e) {
                $("#myImg").attr("src", e.target.result);
            };
        }
    }

    /**
     * 移除照片
     */
    function removeImg() {
        $('#myImg').attr('src', "");
    }
</script>

<style type="text/css">
    .file {
        position: relative;
        display: inline-block;
        background: #D0EEFF;
        border: 1px solid #99D3F5;
        border-radius: 4px;
        padding: 4px 12px;
        overflow: hidden;
        color: #1E88C7;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
    }

    .file input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }

    .file:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }
</style>
<%--添加用户--%>
<div id="dd" style="width:750px; height:400px;padding:30px 60px">
    <form id="form2" method="post" enctype="multipart/form-data" accept="image/gif, image/jpeg,image/jpg, image/png">
        <input type="hidden" name="id" value="${id}">
        <div>
            <label for="context">所属栏目：</label>
            <input id="cc" value="" editable="false" name="context" id="context">
        </div>

        <div>
            <label for="title">文章标题：</label>
            <input type="text" class="easyui-validatebox" required="true" name="title" id="title"
                   value="${detail.title}"/>
        </div>




        <div>
            <label for="file1">文章图片：</label> <%--${detail.articlePicture}--%>
            <img alt="暂无图片" id="myImg" src="${detail.articlePicture}"
                 style="height: 70px;width: 100px"/> <%--/upload/img/bg.gif--%>
            <%--<input class="easyui-filebox" id="uploadId" name="sourceFile" style="width:200px">--%>
            <a href="javascript:;" class="file">选择文件
                <input type="file" class="easyui-filebox" id="file1" name="file" accept="image/*"
                       onchange="changImg(event)"
                       style="width:85%;height: 30px">
            </a>
            <a href="javascript:;" class="file" onclick="removeImg()">移除
                <input type="button" value=""/>
            </a>
        </div>
        <div>
            <label for="summary">摘要：</label>
            <input type="text" class="easyui-validatebox" required="true" name="summary" id="summary"
                   value="${detail.summary}" style="width:550px;height:30px;"/>
        </div>

        <div>
            <label for="editor">正文：</label>
            <script id="editor" type="text/plain" ></script>
        </div>


        <center>
            <div>
                <a href="javascript:void(0)" class="file" onclick="uploadPic(1)">${oper}
                    <input class="easyui-button" type="button" value="" style="margin-top: 10px">
                </a>
                <a href="javascript:void(0)" class="file" onclick="uploadPic(0)">暂存草稿
                    <input class="easyui-button" type="button" value="" style="margin-top: 10px">
                </a>
            </div>
        </center>
    </form>
</div>
</body>
</html>
