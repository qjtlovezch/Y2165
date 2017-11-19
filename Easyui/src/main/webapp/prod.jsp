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
            $("#userGridw").datagrid({
                url : "/prolist.do",
                fit : true,
                fitColumns : true,
                pagination : true,

                columns:[[
                    {field : 'id' ,
                        checkbox : true},
                    {field:'proCode',title:'供应商编码',width:1},
                    {field:'proName',title:'供应商名称',width:1},
                    {field:'proContact',title:'联系人',width:1},
                    {field:'proPhone',title:'联系电话',width:1},
                    {field:'proFax',title:'传真',width:1},
                    {field:'date',title:'创建时间',width:1},
                ]],
                toolbar : [{
                    text : "添加",
                    iconCls : "icon-add",
                    handler:function(){
                     //   $.messager.alert("提示","添加成功");
                        $("#userFormw").form("clear");
                        $("#userDlgw").dialog("open");

                    }
                },{
                    text : "编辑",
                    iconCls : "icon-edit",
                    handler:function(){
                        //$.messager.alert("提示","编辑....");
                        // 获取,并判断编辑数据的有效性
                        var rowData = $("#userGridw").datagrid("getSelected");

                        if(!rowData){
                            $.messager.alert("提示","请选中一行数据!!","info");
                        }else {

                            // 打开对话框
                            $("#userFormsw").form("clear");
                            $("#userDlgsw").dialog("open");

                            // 加载行数据
                            $("#userFormsw").form("load", "/proselect.do?id="+rowData.id);

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
                        alert(check_val);
                        $('#userGridw').datagrid({url:'/prodelete.do?id='+check_val,

                            queryParams:{method:'post' }
                        });

                    }
                },{
                    text : "刷新",
                    iconCls : "icon-reload",
                    handler:function(){
                        //$.messager.alert("提示","刷新....");
                        $('#userGrid').datagrid('reload');
                    }
                },{
                    text: '<input type="text" id="userAccounts"/>'
                },{
                    text : "查询",
                    handler:function() {
                        var typename=$("#userAccounts").val();
                        $('#userGridw').datagrid({url:'/prolists.do',

                            queryParams:{method:'post', typename:typename }
                        });
                        $('#userGridw').datagrid('getPager').pagination({
                            pageSize: 10,//每页显示的记录条数，默认为10 
                            pageList: [5,10,15],//可以设置每页记录条数的列表 
                            beforePageText: '第',//页数文本框前显示的汉字 
                            afterPageText: '页    共 {pages} 页',
                            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

                        });
                        $("#userAccounts").val(typename);
                    }
                },{
                    text : "导出报表",
                    handler:function(){
                        var typename=$("#userAccounts").val();
                        window.location.href="/proexal.do?typename="+typename;


                    }
                }

                ]
            });
            $('#userGridw').datagrid('getPager').pagination({
                pageSize: 10,//每页显示的记录条数，默认为10 
                pageList: [5,10,15],//可以设置每页记录条数的列表 
                beforePageText: '第',//页数文本框前显示的汉字 
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

            });
            // 初始化对话框
            $("#userDlgsw").dialog({
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
                            $("#userFormsw").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                          //  $.messager.alert("提示","取消成功");
                            $("#userDlgsw").dialog("close");
                        }
                    }
                ]
            });
            $("#userDlgw").dialog({
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
                            $("#userFormw").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //$.messager.alert("提示","取消成功");
                            $("#userDlgw").dialog("close");
                        }
                    }
                ]
            });

            // 初始化form
            $('#userFormw').form({
                url:"/proinsert.do",
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
                        $('#userGridw').datagrid('load');

                        // 关闭对话框
                        $("#userDlgw").dialog("close");
                    });

                }
            });
            $('#userFormsw').form({
                url:"/proupdate.do",
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
                        $('#userGridw').datagrid('load');

                        // 关闭对话框
                        $("#userDlgsw").dialog("close");
                    });

                }
            });
            // 当前页面初始化完毕,手动初始化"验证输入框组件"
            $("input").validatebox({

            });
        });

    })

</script>

<table id="userGridw" data-height="300px">

</table>
<div id="userDlgw" data-height="100px">
    <form id="userFormw" action="/proinsert.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>供应商编号:</td>
                <td><input name="proCode" class="easyui-validatebox" /></td>
            </tr>
            <tr>
                <td>供应商名称:</td>
                <td><input name="proName" id="productNames" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>供应商负责人:</td>
                <td><input name="proContact"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="proPhone" id="productUnit" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input name="proAddress" id="productCount" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>传真:</td>
                <td><input name="proFax" id="totalPrice" class="easyui-validatebox" required="true"/></td>
            </tr>

        </table>
    </form>
</div>
<div id="userDlgsw" data-height="100px">
    <form id="userFormsw" action="/proupdate.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>供应商编号:</td>
                <td><input name="proCode" class="easyui-validatebox" readonly/></td>
            </tr>
            <tr>
                <td>供应商名称:</td>
                <td><input name="proName"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>供应商负责人:</td>
                <td><input name="proContact"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="proPhone"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input name="proAddress"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>传真:</td>
                <td><input name="proFax"  class="easyui-validatebox" required="true"/></td>
            </tr>

        </table>
    </form>
</div>


</center>
</body>
</html>
