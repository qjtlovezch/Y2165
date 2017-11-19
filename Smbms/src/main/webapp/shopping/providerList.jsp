<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/shopping/css/style.css"/>
    <script type="text/javascript">
        var currentPage = ${page.pageNum};
        // 总页数
        var totalPage = ${page.pages};
        function submitForm(actionUrl){
            var formElement = document.getElementById("stuForm");
            formElement.action = actionUrl;
            formElement.submit();
        }
        // 第一页
        function firstPage(){
            if(currentPage == 1){
                alert("已经是第一页数据");
                return false;
            }else{
                submitForm("/provider/provlist?pn=1");
                return true;
            }
        }
        // 下一页
        function nextPage(){
            if(currentPage == totalPage){
                alert("已经是最后一页数据");
                return false;
            }else{
                submitForm("/provider/provlist?pn="+(currentPage+1));
                ${page.pageNum+1}
                return true;
            }
        }
        // 上一页
        function previousPage(){
            if(currentPage == 1){
                alert("已经是第一页数据");
                return false;
            }else{
                submitForm("/provider/provlist?pn="+(currentPage-1));
                ${page.pageNum-1}
                return true;
            }
        }
        //删除
        function del(id) {
            var choice = confirm("你确认删除吗?");//确认框。
            if (choice==true){
                $.ajax({
                    url: "/provider/delpro/",
                    type: "post",
                    data: {"id": id},
                    success: function (data) {
                        if (data != 1) {
                            alert('删除失败');
                        } else {
                            alert('删除成功');
                            window.location.href="/shopping/providerList.jsp";
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
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/getbill">账单管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/provider/provlist">供应商管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/pwd">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <form id="stuForm" action="${pageContext.request.contextPath}/provider/prolike" method="post">
            <span>供应商名称：</span>
            <input type="text" name="proName" placeholder="请输入供应商的名称"/>
            <input type="submit"  value="查询"/>
            </form>
            <a href="${pageContext.request.contextPath}/shopping/providerAdd.jsp">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${page.list}" var="item" >
                <tr>
                    <td>${item.proCode}</td>
                    <td>${item.proName}</td>
                    <td>${item.proContact}</td>
                    <td>${item.proPhone}</td>
                    <td>${item.proFax}</td>
                    <td><fmt:formatDate value="${item.creationDate}" pattern="yyyy/MM/dd"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/provider/idlist/${item.id }"><img src="../shopping/img/read.png" alt="查看" title="查看"/></a>
                        <a href="${pageContext.request.contextPath}/provider/Pupda/${item.id }/"><img src="../shopping/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="${pageContext.request.contextPath}/provider/delpro/${item.id }"><img src="../shopping/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            当前页:${page.pageNum}页 共：${page.pages}页，共${page.total}条记录
            <a href="#" onclick="firstPage()">首页</a>
            <a href="#" onclick="previousPage()">上一页</a>
            <a href="#" onclick="nextPage()">下一页</a>
            <a href="/provider/provlist?pn=${page.pages}">尾页</a>
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
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