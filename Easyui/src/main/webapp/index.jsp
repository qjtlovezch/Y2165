
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        function deptFormatter(val,row,index){
            return val?val.name:"";
        }

        $(function(){

            // 初始化表格
            $("#userGrid").datagrid({
                url : "/list.do",
                fit : true,
                fitColumns : true,
                pagination : true,

                columns:[[
                    {field : 'id',
                        checkbox : true},
                    {field:'billCode',title:'账单编码',width:1},
                    {field:'productName',title:'商品名称',width:1},
                    {field:'proName',title:'供应商',width:1},
                    {field:'totalPrice',title:'账单金额',width:1},
                    {field:'p',title:'是否付款',width:1},
                    {field:'data',title:'创建时间',width:1},
                ]],
                toolbar : [{
                    text : "添加",
                    iconCls : "icon-add",
                    handler:function(){
                        //$.messager.alert("提示","添加....");
                        $("#userForm").form("clear");
                        $("#userDlg").dialog("open");

                    }
                },{
                    text : "编辑",
                    iconCls : "icon-edit",
                    handler:function(){
                        //$.messager.alert("提示","编辑....");
                        // 获取,并判断编辑数据的有效性
                        var rowData = $("#userGrid").datagrid("getSelected");

                        if(!rowData){
                            $.messager.alert("提示","请选中一行数据!!","info");
                        }else {

                            // 打开对话框
                            $("#userForms").form("clear");
                            $("#userDlgs").dialog("open");

                            // 加载行数据
                            $("#userForms").form("load", "/select.do?billCode="+rowData.billCode);

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
                        $('#userGrid').datagrid({url:'/delete.do?billCode='+check_val,

                            queryParams:{method:'post' }
                        });
                        $('#userGrid').datagrid('getPager').pagination({
                            pageSize: 10,//每页显示的记录条数，默认为10 
                            pageList: [5,10,15],//可以设置每页记录条数的列表 
                            beforePageText: '第',//页数文本框前显示的汉字 
                            afterPageText: '页    共 {pages} 页',
                            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

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
                    text: '<input type="text" id="userAccount"/>'
                },{
                    text : "查询",
                    handler:function() {
                        var typename=$("#userAccount").val();
                        $('#userGrid').datagrid({url:'/lists.do',

                            queryParams:{method:'post', typename:typename }
                        });
                        $('#userGrid').datagrid('getPager').pagination({
                            pageSize: 10,//每页显示的记录条数，默认为10 
                            pageList: [5,10,15],//可以设置每页记录条数的列表 
                            beforePageText: '第',//页数文本框前显示的汉字 
                            afterPageText: '页    共 {pages} 页',
                            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

                        });
                        $("#userAccount").val(typename);
                    }
                },{
                    text : "导出报表",
                    handler:function(){
                        var typename=$("#userAccount").val();
                        window.location.href="/exal.do?typename="+typename;


                    }
                }

                ]
            });
            $('#userGrid').datagrid('getPager').pagination({
                pageSize: 10,//每页显示的记录条数，默认为10 
                pageList: [5,10,15],//可以设置每页记录条数的列表 
                beforePageText: '第',//页数文本框前显示的汉字 
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

            });
            // 初始化对话框
            $("#userDlgs").dialog({
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
                            //$.messager.alert("提示","保存....");
                            $("#userForms").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //$.messager.alert("提示","取消....");
                            $("#userDlgs").dialog("close");
                        }
                    }
                ]
            });
            $("#userDlg").dialog({
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
                            //$.messager.alert("提示","保存....");
                            $("#userForm").submit();
                        }
                    }, {
                        text : "取消",
                        iconCls : "icon-cancel",
                        handler:function(){
                            //$.messager.alert("提示","取消....");
                            $("#userDlg").dialog("close");
                        }
                    }
                ]
            });

            // 初始化form
            $('#userForm').form({
                url:"/add.do",
                onSubmit: function(){

                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){    // 表单提交成功后的回调函数

                    //console.debug(data);
                    // 由于easyui-form提交,返回的都是字符串,所以需要转换
                    var rs = $.parseJSON(data);
                    alert(rs.success);
                    // 判断响应内容,操作是否成功

                        // 成功提示
                        $.messager.alert("提示","保存用户成功!!","info",function(){
                            // 刷新表格
                            $('#userGrid').datagrid('load');

                        // 关闭对话框
                        $("#userDlg").dialog("close");
                    });

                }
            });
            $('#userForms').form({
                url:"/update.do",
                onSubmit: function(){

                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){    // 表单提交成功后的回调函数

                    //console.debug(data);
                    // 由于easyui-form提交,返回的都是字符串,所以需要转换
                    var rs = $.parseJSON(data);
                    alert(rs.success);
                    // 判断响应内容,操作是否成功

                    // 成功提示
                    $.messager.alert("提示","保存用户成功!!","info",function(){
                        // 刷新表格
                        $('#userGrid').datagrid('load');

                        // 关闭对话框
                        $("#userDlgs").dialog("close");
                    });

                }
            });
            // 当前页面初始化完毕,手动初始化"验证输入框组件"
            $("input").validatebox({

            });
        });

    })

</script>
<%@page isELIgnored="false" %>
</table>
    <table id="userGrid" data-height="300px">

    </table>
    <div id="userDlg" data-height="100px">
        <form id="userForm" action="/add.do" method="post">
            <table align="center" style="margin-top: 10px; width: auto;height: auto">
                <tr>
                    <td>商品编号:</td>
                    <td><input name="billCode" class="easyui-validatebox" /></td>
                </tr>
                <tr>
                    <td>商品名称:</td>
                    <td><input name="productName" id="productName" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>供应商:</td>
                    <td><select name="provider" id="provider" class="easyui-validatebox" required="true">
                        <option value="0">--请选择--</option>
                        <c:forEach items="${lists}"  var="item">
                            <option value="${item.id}">${item.proName}</option>
                        </c:forEach>

                    </select></td>
                </tr>
                <tr>
                    <td>商品单位:</td>
                    <td><input name="productUnit" id="productUnit" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>商品数量:</td>
                    <td><input name="productCount" id="productCount" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>商品总额:</td>
                    <td><input name="totalPrice" id="totalPrice" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>是否支付:</td>
                    <td><select name="isPayment"  class="easyui-validatebox" required="true">
                        <option value="0">未支付</option>
                        <option value="1">已支付</option>
                    </select>
                    </td>
                </tr>

            </table>
        </form>
    </div>
<div id="userDlgs" data-height="100px">
    <form id="userForms" action="/update.do" method="post">
        <table align="center" style="margin-top: 10px; width: auto;height: auto">
            <tr>
                <td>商品ID:</td>
                <td><input name="id" class="easyui-validatebox" readonly/></td>
            </tr>
            <tr>
                <td>商品编号:</td>
                <td><input name="billCode" class="easyui-validatebox" /></td>
            </tr>
            <tr>
                <td>商品名称:</td>
                <td><input name="productName"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>供应商:</td>
                <td><select name="provider"  class="easyui-validatebox" required="true">
                    <option value="0">--请选择--</option>
                    <c:forEach items="${lists}"  var="item">
                    <option value="${item.id}">${item.proName}</option>
                    </c:forEach>

                </select></td>
            </tr>
            <tr>
                <td>商品单位:</td>
                <td><input name="productUnit" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>商品数量:</td>
                <td><input name="productCount"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>商品总额:</td>
                <td><input name="totalPrice"  class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>是否支付:</td>
                <td><select name="isPayment"  class="easyui-validatebox" required="true">
                    <option value="0">未支付</option>
                    <option value="1">已支付</option>
                </select>
                </td>
            </tr>

        </table>
    </form>
</div>


</center>
</body>
</html>
