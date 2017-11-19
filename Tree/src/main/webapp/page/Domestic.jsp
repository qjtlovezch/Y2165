<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/11/07
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <div width="750px";height="250px";>
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
<%--<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/Lanmu/gx.js"></script>--%>
<script type="text/javascript">
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1,                 //月份
            "d+": this.getDate(),                    //日
            "h+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "s+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    $(function () {
        var editRow = undefined;
        $('#bg').datagrid({
            title: '',
            loadMsg: "数据加载中，请稍后……",
            collapsible: true,
            singleSelect: true,
            checkOnSelect: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            url: '${pageContext.request.contextPath}/content/Details?columnCode=' +${id},
            sortName: 'RoleSort',
            sortOrder: 'asc',
            pagination: true,
            beforePageText: '第',//页数文本框前显示的汉字 
            afterPageText: '页    共 {total} 页',
            displayMsg: '第{from}到{pages}条，共{pages}条',
            frozenColumns: [[
                {field: 'ck', checkbox: true},
                {title: '编号', field: 'id', width: 120, align: 'center', sortable: true}
            ]],
            columns: [[
                {field: 'title', title: '标题', width: 120, align: 'center', sortable: true},
                {
                    field: 'content', title: '栏目', width: 80, align: 'center', formatter: function (value, row, index) {
                    return value.columnname;
                }
                },
                {field: 'weight', title: '权重', width: 80, align: 'center', sortable: true},
                {field: 'clicks', title: '点击次数', width: 80, align: 'center', sortable: true},
                {
                    field: 'user', title: '创建者', width: 80, align: 'center', formatter: function (value, row, index) {
                    return value.username;
                }
                },
                {
                    field: 'modifyTime',
                    title: '创建时间',
                    width: 150,
                    align: 'center',
                    formatter: function (value, row, index) {
                        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
                    }
                }
            ]],        // onLoadSuccess: function () {
            // $('.datagrid-toolbar').append($('#txtSearch'));
            //$('#txtSearch').show();
            //   },
            toolbar: [
                {
                    id: 'add',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        //open1();
                        var text = "添加资讯";
                        //var url = "/page/DomesticManage.jsp";

                        openTab("添加资讯", "/content/DomesticManage?pageType=add");
                    }
                }, {
                    id: 'cut',
                    text: '删除',
                    iconCls: 'icon-cut',
                    handler: function () {
                        var codes = getSelections();


                        if (codes == '') {
                            $.messager.alert('提示消息', '请选择要删除的数据！', 'info');
                        } else {
                            $.messager.confirm('提示消息', '确定要删除所选数据吗？', function (r) {
                                if (r) {
                                    $.ajax({
                                        url: '${pageContext.request.contextPath}/content/delDetail?id=' + codes,
                                        type: 'post',
                                        dataType: 'text',
                                        success: function (returnValue) {
                                            if (returnValue) {
                                                // alert('yes');
                                                $('#bg').datagrid('reload');
                                                $('#bg').datagrid('clearSelections');
                                                $.messager.alert("操作成功", "删除成功");
                                            } else {
                                                $.messager.alert("操作成功", "删除失败");
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                }, '-',
                {
                    text: '修改', iconCls: 'icon-edit', handler: function () {
                    var rows = getSelections();

                    if (rows=='') {
                        $.messager.alert('提示消息', '请选择要修改的数据！', 'info');
                        return false;
                    } else {
                        openTab("修改文章","/content/DomesticManage?id="+rows);
                    }
                }}],
            onAfterEdit: function (rowIndex, rowData, changes) {
                //endEdit该方法触发此事件
                console.info(rowData);
                editRow = undefined;
            }

        });
        $('#dd').dialog('close');
        $('#xx').dialog('close');
    });

    /**
     * 拿到选中的id
     * @returns {Array}
     */
    function getSelections() {
        var ids = [];
        var row = $('#bg').datagrid('getSelections');
        for (var i = 0; i < row.length; i++) {

            ids.push(row[i].id);
        }

        return ids;
    }

    function open1() {
        $('#dd').dialog('open');
        $('#dd').dialog('center');
    }
    function close1() {
        $('#dd').dialog('close');
    }


    //新开tabs选项卡
    function openTab(text, url) {

        if (parent.$("#tabs").tabs("exists", text)) {
            parent.$("#tabs").tabs("select", text);
        } else {

            var content = "<iframe frameborder=0 scrolling='scroll' style='width:100%;height:100%' src='${pageContext.request.contextPath}" + url + "'></iframe>";  //?columnname="+text+"
            parent.$("#tabs").tabs("add", {
                title: text,
                closable: true,
                content: content
            });
        }
    }
</script>
   

            <table id="bg">

            </table>
        </div>


</body>
</html>
