<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
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
                submitForm("/getbill?pn=1");
                return true;
            }
        }
        // 下一页
        function nextPage(){
            if(currentPage == totalPage){
                alert("已经是最后一页数据");
                return false;
            }else{
                submitForm("/getbill?pn="+(currentPage+1));
                ${page.pageNum+1}
                return true;
            }
        }
        function del() {
            var result = confirm('确定删除？');

            if (result) {
                alert("删除成功！");
            }else
            {
                alert("删除失败！");
            }

        }
        // 上一页
        function previousPage(){
            if(currentPage == 1){
                alert("已经是第一页数据");
                return false;
            }else{
                submitForm("/getbill?pn="+(currentPage-1));
                ${page.pageNum-1}
                return true;
            }
        }
    </script>


</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b">${userCode}</span> , 欢迎你！</p>
            <a href="/user/exit">退出</a>
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
                    <li ><a href="/getbill">账单管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/prolist">供应商管理</a></li>
                    <li><a href=" ${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                    <%--<li><a href="${pageContext.request.contextPath}/user/setAll/1">用户管理</a></li>--%>
                    <li><a href="/user/pwd">密码修改</a></li>
                    <li><a href="/user/exit">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>账单管理页面</span>
            </div>
            <form id="stuForm" action="/getbills"  method="post">
                <div class="search">
                    <span>商品名称：</span>
                    <input type="text" name="productName" placeholder="请输入商品的名称"/>

                    <span>供应商：</span>
                    <select name="providerId" >
                        <option value="">--请选择--</option>
                        <c:forEach items="${page.list}" var="item">
                        <option value="${item.providerId}">${item.provider.proName}</option>
                        </c:forEach>
                    </select>

                    <span>是否付款：</span>
                    <select name="isPayment">
                        <option value="">--请选择--</option>
                        <option value="0">已付款</option>
                        <option value="1">未付款</option>
                    </select>

                    <input type="submit" value="查询"/>
                    <a href="${pageContext.request.contextPath}/addf">添加订单</a>
                </div>
            </form>


            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">ID</th>
                    <th width="10%">账单编码</th>
                    <th width="20%">商品名称</th>
                    <th width="10%">供应商</th>
                    <th width="10%">账单金额</th>
                    <th width="10%">是否付款</th>
                    <th width="10%">创建时间</th>
                    <th width="30%">操作</th>
                </tr>

<c:forEach items="${page.list}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.billCode}</td>
        <td>${item.productName}</td>
        <td>${item.provider.proName}</td>

        <td>${item.totalPrice}</td>
        <c:if test="${item.isPayment==1}">
            <td>未付款</td>
        </c:if>
        <c:if test="${item.isPayment==0}">
            <td>已付款</td>
        </c:if>

        <td><fmt:formatDate value="${item.creationDate}" pattern="yyyy/MM/dd"/></td>
        <td>
            <a href="${pageContext.request.contextPath}/billuser/${item.id}"><img src="../img/read.png" alt="查看" title="查看"/></a>
            <a href="${pageContext.request.contextPath}/CBill/${item.id}"><img src="../img/xiugai.png" alt="修改" title="修改"/></a>
            <a href="${pageContext.request.contextPath}/Bdel/${item.id}" class="removeBill"><img src="../img/schu.png" onclick="del()" alt="删除" title="删除"/></a>
        </td>
    </tr>
</c:forEach>

            </table>

            <div style="text-align: center">
                <ul>
                    <li> 当前页:[${page.pageNum}/${page.pages}] &nbsp;&nbsp;&nbsp;

                        <a onclick="firstPage()" href="#">首页</a> &nbsp;&nbsp;&nbsp;
                        <a onclick="previousPage()" href="#">上一页</a> &nbsp;&nbsp;&nbsp;
                        <a onclick="nextPage()" href="#">下一页</a> &nbsp;&nbsp;&nbsp;
                        <a  href="/getbill?pn=${page.pages}" >尾页</a></li>
                </ul>
            </div>

          <%--  <div>
                当前页:${page.pageNum}页 共：${page.pages}页，共${page.total}条记录
                <a href="#" onclick="firstPage()">首页</a>
                <a href="#" onclick="previousPage()">上一页</a>
                <a href="#" onclick="nextPage()">下一页</a>
                <a href="/provider/provlist?pn=${page.pages}">尾页</a>
            </div>--%>






        </div>
    </section>

<<%--!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>--%>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>