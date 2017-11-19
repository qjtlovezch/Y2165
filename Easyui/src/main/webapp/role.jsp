<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/9/6
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    $(function () {
        function deptFormatter(val,row,index){
            return val?val.name:"";
        }

        $(function(){

            // 初始化表格
            $("#userGridwr").datagrid({
                url : "/rolelist.do",
                fit : true,
                fitColumns : true,
                pagination : true,

                columns:[[
                    {field : 'id' ,
                        checkbox : true},

                    {field:'roleName',title:'角色名称',width:1},
                    {field:'str',title:'角色负责',width:1},
                ]],
                toolbar : [{
                    text : "添加",
                    iconCls : "icon-add",
                    handler:function(){
                        //   $.messager.alert("提示","添加成功");
                        $("#userFormwr").form("clear");
                        $("#userDlgwr").dialog("open");

                    }
                },{
                    text : "编辑",
                    iconCls : "icon-edit",
                    handler:function(){
                        //$.messager.alert("提示","编辑....");
                        // 获取,并判断编辑数据的有效性
                        var rowData = $("#userGridwr").datagrid("getSelected");

                        if(!rowData){
                            $.messager.alert("提示","请选中一行数据!!","info");
                        }else {

                            // 打开对话框
                            $("#userFormswr").form("clear");
                            $("#userDlgswr").dialog("open");

                            // 加载行数据
                            $("#userFormswr").form("load", "/roleselect.do?id="+rowData.id);

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

                        $('#userGridwr').datagrid({url:'/roledelete.do?id='+check_val,

                            queryParams:{method:'post' }
                        });

                    }
                },{
                    text : "刷新",
                    iconCls : "icon-reload",
                    handler:function(){
                        //$.messager.alert("提示","刷新....");
                        $('#userGridr').datagrid('reload');
                    }
                }

                ]
            });
            $('#userGridwr').datagrid('getPager').pagination({
                pageSize: 10,//每页显示的记录条数，默认为10 
                pageList: [5,10,15],//可以设置每页记录条数的列表 
                beforePageText: '第',//页数文本框前显示的汉字 
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

            });
            // 初始化对话框
            $("#userDlgswr").dialog({
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
                            $("#userFormswr").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //  $.messager.alert("提示","取消成功");
                            $("#userDlgswr").dialog("close");
                        }
                    }
                ]
            });
            $("#userDlgwr").dialog({
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
                            $("#userFormwr").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //$.messager.alert("提示","取消成功");
                            $("#userDlgwr").dialog("close");
                        }
                    }
                ]
            });

            // 初始化form
            $('#userFormwr').form({
                url:"/roleinsert.do",
                onSubmit: function(){
                    obj = document.getElementsByName("roleCode");
                    check_val = [];
                    for(k in obj){
                        if(obj[k].checked)
                            check_val.push(obj[k].value);

                    }
                },
                success:function(data){    // 表单提交成功后的回调函数

                    //console.debug(data);
                    // 由于easyui-form提交,返回的都是字符串,所以需要转换
                    var rs = $.parseJSON(data);

                    // 判断响应内容,操作是否成功

                    // 成功提示
                    $.messager.alert("提示","保存用户成功!!","info",function(){
                        // 刷新表格
                        $('#userGridwr').datagrid('load');

                        // 关闭对话框
                        $("#userDlgwr").dialog("close");
                    });

                }
            });
            $('#userFormswr').form({
                url:"/roleupdate.do",
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
                    $.messager.alert("提示","保存用户成功!!","info",function(){
                        // 刷新表格
                        $('#userGridwr').datagrid('load');

                        // 关闭对话框
                        $("#userDlgswr").dialog("close");
                    });

                }
            });
            // 当前页面初始化完毕,手动初始化"验证输入框组件"
            $("input").validatebox({

            });
        });

    })

</script>


<table id="userGridwr" data-height="300px">

</table>
<div id="userDlgwr" data-height="100px">
    <form id="userFormwr" action="/roleinsert.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>角色名字:</td>
                <td><input name="roleName" class="easyui-validatebox"  /></td>
            </tr>
            <tr>
                <td>责任:</td>
                </tr>
            <tr>
                <td><input  type="checkbox" name="roleCode" value="1" class="easyui-validatebox" required="true"/>全部管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="2" class="easyui-validatebox" required="true"/>商品管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="3" class="easyui-validatebox" required="true"/>供应商管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="4" class="easyui-validatebox" required="true"/>人员管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="13" class="easyui-validatebox" required="true"/>权限管理</td>

            </tr>


        </table>
    </form>
</div>
<div id="userDlgswr" data-height="100px">
    <form id="userFormswr" action="/roleupdate.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>编号:</td>
                <td><input name="id" class="easyui-validatebox" readonly/></td>
            </tr>
            <tr>
                <td>角色名字:</td>
                <td><input name="roleName" class="easyui-validatebox"  /></td>
            </tr>
            <tr>
                <td>责任:</td>
            </tr>
            <tr>
                <td><input onclick="stu()" type="checkbox" name="roleCode" value="1" class="easyui-validatebox" required="true"/>全部管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="2" class="easyui-validatebox" required="true"/>商品管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="3" class="easyui-validatebox" required="true"/>供应商管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="4" class="easyui-validatebox" required="true"/>人员管理</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="roleCode" value="13" class="easyui-validatebox" required="true"/>权限管理</td>

            </tr>

        </table>
    </form>
</div>


</center>
</body>
</html>
