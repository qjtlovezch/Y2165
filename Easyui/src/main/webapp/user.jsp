<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/10
  Time: 3:22
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        function deptFormatter(val,row,index){
            return val?val.name:"";
        }

        $(function(){

            // 初始化表格
            $("#userGridu").datagrid({
                url : "/userlist.do",
                fit : true,
                fitColumns : true,
                pagination : true,

                columns:[[
                    {field : 'id' ,
                        checkbox : true},
                    {field:'userName',title:'用户名称',width:1},
                    {field:'genders',title:'用户性别',width:1},
                    {field:'date',title:'用户生日',width:1},
                    {field:'phone',title:'联系电话',width:1},
                    {field:'address',title:'用户地址',width:1},
                    {field:'roleName',title:'用户权限',width:1},
                ]],
                toolbar : [{
                    text : "添加",
                    iconCls : "icon-add",
                    handler:function(){
                        //   $.messager.alert("提示","添加成功");
                        $("#userFormu").form("clear");
                        $("#userDlgu").dialog("open");

                    }
                },{
                    text : "编辑",
                    iconCls : "icon-edit",
                    handler:function(){
                        //$.messager.alert("提示","编辑....");
                        // 获取,并判断编辑数据的有效性
                        var rowData = $("#userGridu").datagrid("getSelected");

                        if(!rowData){
                            $.messager.alert("提示","请选中一行数据!!","info");
                        }else {
                            alert($("#1234").text());
                             if($("#1234").text()==1){
                                 $("#userFormsu").form("clear");
                                 $("#userDlgsu").dialog("open");

                                 // 加载行数据
                                 $("#userFormsu").form("load", "/userselect.do?id="+rowData.id);
                             }else {
                                 $.messager.alert("提示","系统管理员方可编辑您权限不足!!","info");
                             }
                            // 打开对话框


                        }
                    }
                },{
                    text : "删除",
                    iconCls : "icon-remove",
                    handler:function(){
                        obj = document.getElementsByName("id");
                        check_val = [];
                        for(k in obj){
                            if(obj[k].checked)
                                check_val.push(obj[k].value);
                        }

                        $('#userGridu').datagrid({url:'/userdelete.do?id='+check_val,

                            queryParams:{method:'post' }
                        });

                    }
                },{
                    text : "刷新",
                    iconCls : "icon-reload",
                    handler:function(){
                        //$.messager.alert("提示","刷新....");
                        $('#userGridu').datagrid('reload');
                    }
                },{
                    text: '<input type="text" id="userAccountsu"/>'
                },{
                    text : "查询",
                    handler:function() {
                        var typename=$("#userAccountsu").val();
                        $('#userGridu').datagrid({url:'/userlists.do',

                            queryParams:{method:'post', typename:typename }
                        });
                        $('#userGridu').datagrid('getPager').pagination({
                            pageSize: 10,//每页显示的记录条数，默认为10 
                            pageList: [5,10,15],//可以设置每页记录条数的列表 
                            beforePageText: '第',//页数文本框前显示的汉字 
                            afterPageText: '页    共 {pages} 页',
                            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

                        });
                        $("#userAccountsu").val(typename);
                    }
                }

                ]
            });
            $('#userGridu').datagrid('getPager').pagination({
                pageSize: 10,//每页显示的记录条数，默认为10 
                pageList: [5,10,15],//可以设置每页记录条数的列表 
                beforePageText: '第',//页数文本框前显示的汉字 
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

            });
            // 初始化对话框
            $("#userDlgsu").dialog({
                title:"编辑面板",
                width: 300,
                height :300,
                closed:true,
                modal : true,
                buttons:[
                    {
                        text : "保存",
                        iconCls : "icon-save",
                        handler:function(){
                            // $.messager.alert("提示","保存成功");
                            $("#userFormsu").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //  $.messager.alert("提示","取消成功");
                            $("#userDlgsu").dialog("close");
                        }
                    }
                ]
            });
            $("#userDlgu").dialog({
                title:"添加面板",
                width: 300,
                height :300,
                closed:true,
                modal : true,
                buttons:[
                    {
                        text : "保存",
                        iconCls : "icon-save",
                        handler:function(){

                            //$.messager.alert("提示","保存成功");
                            $("#userFormu").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //$.messager.alert("提示","取消成功");
                            $("#userDlgu").dialog("close");
                        }
                    }
                ]
            });

            // 初始化form
            $('#userFormu').form({
                url:"/userinsert.do",
                onSubmit: function(){

                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){    // 表单提交成功后的回调函数

                    //console.debug(data);
                    // 由于easyui-form提交,返回的都是字符串,所以需要转换
                    var rs = $.parseJSON(data);

                    // 判断响应内容,操作是否成功

                    // 成功提示
                    if(rs==false){
                        $.messager.alert("提示","请输入正确的日期格式!!","info",function(){

                        });
                    }else {
                        $.messager.alert("提示", "保存用户成功!!", "info", function () {
                            // 刷新表格
                            $('#userGridu').datagrid('load');

                            // 关闭对话框
                            $("#userDlgu").dialog("close");
                        });
                    }
                }
            });
            $('#userFormsu').form({
                url:"/userupdate.do",
                onSubmit: function(){

                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){    // 表单提交成功后的回调函数

                    //console.debug(data);
                    // 由于easyui-form提交,返回的都是字符串,所以需要转换
                    var rs = $.parseJSON(data);

                    // 判断响应内容,操作是否成功

                        // 成功提示
                        $.messager.alert("提示", "保存用户成功!!", "info", function () {
                            // 刷新表格
                            $('#userGridu').datagrid('load');

                            // 关闭对话框
                            $("#userDlgsu").dialog("close");
                        });
                    }

            });
            // 当前页面初始化完毕,手动初始化"验证输入框组件"
            $("input").validatebox({

            });
        });

    })

</script>

<table id="userGridu" data-height="300px">

</table>
<div id="userDlgu" data-height="100px">
    <form id="userFormu" action="/userinsert.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>用户姓名:</td>
                <td><input name="userName" id="productNames" class="easyui-validatebox" /></td>
            </tr>
            <tr>
                <td>用户性别:</td>
                <td><select name="gender">
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select></td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td><input name="date"  class="easyui-validatebox" required="true"/><br><span style="font-size: 10px">(请输入XXXX-XX-XX格式)</span></td>

            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="phone" id="productUnit" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input name="address"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input name="userCode" id="productCount" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="userPassword"  class="easyui-validatebox" required="true"/></td>


            </tr>
            <td id="1234" hidden>${userRole}</td>
        </table>
    </form>
</div>
<div id="userDlgsu" data-height="100px">
    <form id="userFormsu" action="/userupdate.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>用户ID:</td>
                <td><input name="id"  class="easyui-validatebox"  readonly/></td>
            </tr>
            <tr>
                <td>用户姓名:</td>
                <td><input name="userName"  class="easyui-validatebox" /></td>
            </tr>

            <tr>
                <td>电话:</td>
                <td><input name="phone"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input name="address"  class="easyui-validatebox" required="true"/></td>
            </tr>

            <tr>
                <td>权限：
                </td>
                <td><select name="userRole"  class="easyui-validatebox" required="true">
                    <option value="0">--请选择--</option>
                    <c:forEach items="${role}" var="item">
                    <option value="${item.id}">${item.roleName}</option>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </form>
</div>


</center>
</body>
</html>

