/**
 * Created by 123 on 2017/11/10.
 */
var id = undefined;
var text = undefined;
var url = '${pageContext.request.contextPath}/content/columnlist';
var url = '${pageContext.request.contextPath}/content/Details?columncode=+${id}';
$(function () {
    $("#tt").tree({
        url: url,
        animate: true,
        cascadeCheck: false,
        loadFilter: function (data) {
            change(data);
            //图标的设定
            /*$.each(data, function (i, v) {
             v.iconCls = "icon-folder";
             alert("data"+v.columnname)
             });*/

            return data;
        }, onClick: function (node) {
            text = node.text;
            //var ico = node.iconCls;
            id = node.attributes.id
            alert(id);
            var url = node.attributes.url;
            alert("122222222222" + url);
            if (node.attributes && node.attributes.url) {
                openTab(text, url);
            }
        }
    });

});
function change(data) {
    if (!data.length) {
        data.text = data.columnname;
        if (data.children) {
            change(data.children);
        }
    } else {
        $.each(data, function (i, v) {
            change(v);
        });
    }
}
//新开tabs选项卡
function openTab(text, url) {
    if ($("#tabs").tabs("exists", text)) {
        $("#tabs").tabs("select", text);
    } else {
        var content = "<iframe frameborder=0 scrolling='scroll' style='width:100%;height:100%' src='${pageContext.request.contextPath}" + url + "?id=" + id + "'></iframe>";
        $("#tabs").tabs("add", {
            title: text,
            closable: true,
            content: content
        });
    }
}


$(function () {
    alert('hhhhh ');
    var editRow = undefined;

    $('#bg').datagrid({
        title: text,
        loadMsg: "数据加载中，请稍后……",
        collapsible: true,
        /*singleSelect: false,
         selectOnCheck: true,*/
        singleSelect: true,
        checkOnSelect: true,
        pageSize: 2,
        pageList: [2, 4, 6, 8],
        url: url,
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
                width: 120,
                align: 'center',
                formatter: function (value, row, index) {
                    return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {
                field: 'opt', title: '操作', width: 100, align: 'center',
                formatter: function (value, rec) {
                    return '<a href="#" onclick="parent.addTab(\'编辑角色[' + +rec.userCode + ']\', \'Role/Edit.aspx?RoleCode=' + rec.userName + '&RoleName=' + rec.gender + '\')"><span style="color:red" onclick="">编辑</span></a>';
                }
            }
        ]], onLoadSuccess: function () {
            $('.datagrid-toolbar').append($('#txtSearch'));
            $('#txtSearch').show();
        },
        toolbar: [
            {
                id: 'add',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    //open1();
                    var text = "添加资讯";
                    //var url = "/page/DomesticManage.jsp";
                    //alert(22);
                    openTab("添加资讯", "/page/DomesticManage.jsp");
                }
            }, {
                id: 'cut',
                text: '删除',
                iconCls: 'icon-cut',
                handler: function () {
                    var codes = getSelections();
                    alert('codes' + getSelections());

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
                id: 'btnSearch',
                text: '搜索',
                iconCls: 'icon-search',
                handler: function () {
                    $('#bg').datagrid('options').url = '${pageContext.request.contextPath}/searchUserInfo?search=' + $('#txtSearch').val();
                    $('#bg').datagrid("reload");
                    $('#bg').datagrid("getPager").pagination({

                        beforePageText: '第',//页数文本框前显示的汉字 
                        afterPageText: '页    共 {pages} 页',
                        displayMsg: '第{from}到{to}条，共{total}条'
                    });
                }
            }, '-',
            {
                text: '修改', iconCls: 'icon-edit', handler: function () {
                //修改时要获取选择到的行
                var rows = $('#bg').datagrid("getSelections");
                //如果只选择了一行则可以进行修改，否则不操作
                if (rows.length == 1) {
                    //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                    if (editRow != undefined) {
                        $('#bg').datagrid("endEdit", editRow);
                    }
                    //当无编辑行时
                    if (editRow == undefined) {
                        //获取到当前选择行的下标
                        var index = $('#bg').datagrid("getRowIndex", rows[0]);
                        //开启编辑
                        $('#bg').datagrid("beginEdit", index);
                        //把当前开启编辑的行赋值给全局变量editRow
                        editRow = index;
                        //当开启了当前选择行的编辑状态之后，
                        //应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
                        $('#bg').datagrid("unselectAll");
                    }
                }
            }
            }, '-',
            {
                text: '保存', iconCls: 'icon-save', handler: function () {
                //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                $('#bg').datagrid("endEdit", editRow);
            }
            }, '-',
            {
                text: '取消编辑', iconCls: 'icon-redo', handler: function () {
                //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                editRow = undefined;
                $('#bg').datagrid("rejectChanges");
                $('#bg').datagrid("unselectAll");
            }
            }, '-'],
        onAfterEdit: function (rowIndex, rowData, changes) {
            //endEdit该方法触发此事件
            console.info(rowData);
            editRow = undefined;
        },
        onDblClickRow: function (rowIndex, rowData) {
            //双击开启编辑行
            if (editRow != undefined) {
                $('#bg').datagrid("endEdit", editRow);
            }
            if (editRow == undefined) {
                $('#bg').datagrid("beginEdit", rowIndex);
                editRow = rowIndex;
            }
        }

    });

    /* $('#dd').dialog({
     title: '添加资讯',
     collapsible: false,
     resizable: true,
     /!*inline:true,*!/
     modal: true,
     //小弹层的OK
     buttons: [{
     text: 'Ok',
     iconCls: 'icon-ok',
     handler: function () {
     openTab("添加资讯", "/page/DomesticManage.jsp");
     $.ajax({
     url: "/content/addDetail",
     type: "post",
     data: $("#form2").serialize(),
     success: function (data) {

     if (data == "y") {
     //alert('添加成功');
     $.messager.alert("操作成功", "添加成功");
     $('#bg').datagrid('reload');
     } else {
     $.messager.alert("操作失败", '添加失败');
     }
     $('#dd').dialog('close');
     }
     });

     }
     }, {
     text: 'Cancel',
     handler: function () {
     $('#dd').dialog('close');
     }
     }]
     });*/
    $('#dd').dialog('close');
    $('#xx').dialog('close');
});

