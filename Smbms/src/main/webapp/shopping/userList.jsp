<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/js/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/shopping/js/jQuery1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/shopping/js/jquery.pagination.js"></script>
    <script type="text/javascript">
        //JS日期系列：根据出生日期 得到周岁年龄
        //参数strBirthday已经是正确格式的2007.02.09这样的日期字符串
        //后续再增加相关的如日期判断等JS关于日期处理的相关方法

        var returnData;

        jQuery.noConflict();
        jQuery(function($){
            //模糊查询
            $("#btnSelect").click(function () {
                load2(0);
            });

            //加载数据
            load(0);
            function  load(index) {
                $.ajax({
                    url:"/user/getUserInfo",
                    type:"post",
                    data:{"pageIndex":index},
                    success:function (data) {

                        //pageUtil
                        //模拟ajax去后端读取页数，获取数据并渲染列表的过程
                        $('#list-content').html('');
                        $.each(data.list,function (i,dom) {
                            $('#list-content').append('<tr>' +
                                    /*  '<td>'+'<input type="checkbox" value="id"/>'+'</td>'+*/
                                '<td>' + dom.userCode + '</td>' +
                                '<td>' + dom.userName + '</td>' +
                                '<td>' +  (dom.gender===1?"男":"女") + '</td>' +
                                '<td>' +jsGetAge (dom.birthday) + '</td>' +
                                '<td>' + dom.phone + '</td>' +
                                '<td>' + dom.userRole + '</td> ' +
                                '<td>' + '<a onclick="del('+dom.id+')">删除</a>'+
                                '<a href="/user/getAll/'+dom.id+'">修改</a> '+
                                '<a href="/user/doidlist/'+dom.id+'">查看</a>' +
                                '</td></tr>');
                        });
                        //渲染分页
                        if(data.totalPages>0){
                            $('#pagination').pagination(data.totalRecords, {
                                current_page : index, //当前页索引
                                items_per_page : data.pageSize, //每页记录数
                                num_display_entries :3, //显示页码块数量
                                callback :load,
                                ellipse_text:"...",
                                num_edge_entries:2,
                                load_first_page : true,
                                prev_text : 'Previous',
                                next_text : 'Next'
                            });
                        }
                    }
                });
            }
            //带条件查询
            function  load2(index) {
                var userName=$("[name=userName]").val();
                $.ajax({
                    url:"/user/selectUser",
                    type:"post",
                    data:{"pageIndex":index,"userName":userName},
                    success:function (data) {
                        //pageUtil
                        //模拟ajax去后端读取页数，获取数据并渲染列表的过程
                        $('#list-content').html('');
                        $.each(data.list,function (i,dom) {
                            $('#list-content').append('<tr>' +
                                    /*  '<td>'+'<input type="checkbox" value="id"/>'+'</td>'+*/
                                '<td>' + dom.userCode + '</td>' +
                                '<td>' + dom.userName + '</td>' +
                                '<td>' +  (dom.gender===1?"男":"女") + '</td>' +
                                '<td>' +jsGetAge (dom.birthday) + '</td>' +
                                '<td>' + dom.phone + '</td>' +
                                '<td>' + dom.userRole + '</td> ' +
                                '<td>' + '<a onclick="del('+dom.id+')">删除</a>'+
                                '<a href="/user/getAll/'+dom.id+'">修改</a> '+
                                '<a href="/user/doidlist/'+dom.id+'">查看</a>' +
                                '</td></tr>');
                        });
                        //渲染分页

                        $('#pagination').pagination(data.totalRecords, {
                            current_page: index, //当前页索引
                            items_per_page: data.pageSize, //每页记录数
                            num_display_entries: 3, //显示页码块数量
                            callback: load2,
                            ellipse_text: "...",
                            num_edge_entries: 2,
                            load_first_page: true,
                            prev_text: 'Previous',
                            next_text: 'Next'
                        });

                    }
                });
            }



        });

        function jsGetAge(strBirthday)
        {
            var returnAge;
            var strBirthdayArr=strBirthday.split("-");
            var birthYear = strBirthdayArr[0];

            var birthMonth = strBirthdayArr[1];
            var birthDay = strBirthdayArr[2];

            var d = new Date();
            var nowYear = d.getFullYear();
            var nowMonth = d.getMonth() + 1;
            var nowDay = d.getDate();

            if(nowYear == birthYear)
            {

                returnAge = 0;//同年 则为0岁
            }
            else
            {

                var ageDiff = nowYear - birthYear ; //年之差
                if(ageDiff > 0)
                {
                    if(nowMonth == birthMonth)
                    {

                        var dayDiff = nowDay - birthDay;//日之差
                        if(dayDiff < 0)
                        {
                            returnAge = ageDiff - 1;
                        }
                        else
                        {
                            returnAge = ageDiff ;
                        }
                    }
                    else
                    {
                        var monthDiff = nowMonth - birthMonth;//月之差
                        if(monthDiff < 0)
                        {
                            returnAge = ageDiff - 1;
                        }
                        else
                        {
                            returnAge = ageDiff ;
                        }
                    }
                }
                else
                {
                    returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
                }
            }

            return returnAge;//返回周岁年龄

        }



        //删除
        function del(id) {
            var choice = confirm("你确认删除吗?");//确认框。
            if (choice==true){
                $.ajax({
                    url: "/user/dellUser/",
                    type: "post",
                    data: {"id": id},
                    success: function (data) {
                        if (data != 1) {
                            alert('删除失败');
                        } else {
                            alert('删除成功');
                            window.location.href="/shopping/userList.jsp";
                        }
                    }

                });
            }

        }

    </script>











</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> <%=request.getSession().getAttribute("userinfo")%></span> , 欢迎你！</p>
            <a href="login.jsp">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表<span></span></h2>
            <nav>
                <ul class="list">
                    <li><a href="${pageContext.request.contextPath}/getbill">账单管理</a></li>
                    <li ><a href="${pageContext.request.contextPath}/provider/provlist">供应商管理</a></li>
                    <li id="active"><a href="${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/pwd">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <form id="stuForm" action="${pageContext.request.contextPath}/user/userlikeList" method="post">
                <span>用户名：</span>
                    <input type="text" name="userName" placeholder="请输入用户名"/>
                    <input type="button" id="btnSelect" value="查询"/>
                </form>
                <a href="${pageContext.request.contextPath}/user/excelUser">报表导出</a>
                <a href="${pageContext.request.contextPath}/shopping/userAdd.jsp">添加用户</a>
               <%-- <a href="${pageContext.request.contextPath}/user/dellUser/${item.id}" name="userid">删除用户</a>
                <a href="${pageContext.request.contextPath}/user/getAll/${item.id}">修改用户</a>--%>
            </div>

            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">

                   <%-- <th width="5%">全选<input type="checkbox"/></th>--%>
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <tbody id="list-content"></tbody>
              <%--  <c:forEach items="${page.list}"  var="item" >
                    <tr>
                        <td><input type="checkbox" name="${item.id}"/></td>
                        <td>${item.userCode}</td>
                        <td>${item.userName}</td>
                        <c:if test="${item.gender==1}">
                            <td>男</td>
                        </c:if>

                        <c:if test="${item.gender==2}">
                            <td>女</td>
                        </c:if>


                        <td>${item.birthday}</td>
                        <td>${item.phone}</td>

                        <c:if test="${item.userRole==0}">
                            <td>经理</td>
                        </c:if>

                        <c:if test="${item.userRole==1}">
                            <td>董事长</td>
                        </c:if>

                        <td>
&lt;%&ndash;                        <a href="${pageContext.request.contextPath}/user/doidlist/${item.id }"><img src="${pageContext.request.contextPath}/shopping/img/read.png" alt="查看" title="查看"/></a>
                            <a href="${pageContext.request.contextPath}/user/getAll/${item.id}"><img src="${pageContext.request.contextPath}/shopping/img/xiugai.png" alt="修改" title="修改"/></a>
                            <a href="${pageContext.request.contextPath}/user/dellUser/${item.id }" name="userid" class="removeUser"><img src="${pageContext.request.contextPath}/shopping/img/schu.png" alt="删除" title="删除"/></a>&ndash;%&gt;
                        </td>
                    </tr>
                </c:forEach>--%>

            </table>


           <%-- <div style="text-align: center">
                当前页:[${lists.pageIndex} / ${lists.totapages}] &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/user/dolist/1">首页</a> &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/user/dolist/${lists.pageIndex-1}">上一页</a> &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/user/dolist/${lists.pageIndex+1}">下一页</a> &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/user/dolist/${lists.totapages}">尾页</a>
            </div>--%>

          <%--  <div>
                当前页:${page.pageNum}页 共：${page.pages}页，共：${page.total}条记录
                <a href="#" onclick="firstPage()">首页</a>
                <a href="#" onclick="previousPage()">上一页</a>
                <a href="#" onclick="nextPage()">下一页</a>
                <a href="/user/dolist?pn=${page.pages}">尾页</a>
            </div>
--%>

         <div class="pagination" id="pagination" style="margin:4px 0 0 0"></div>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="${pageContext.request.contextPath}/shopping/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/shopping/js/js.js"></script>
<script src="${pageContext.request.contextPath}/shopping/js/time.js"></script>

</body>
</html>