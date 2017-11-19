<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/css/blogadd.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function editBlog(id,obj){

            $("#rid").val(id);

        }


        function del(){
            var result=confirm('确定删除吗？');
            if(result){
                alert('删除成功')
                return true;
            }else{
                return false;
            }
        }

        $(function () {
            $("form").submit(function () {
                var name=$("[name=blogAuthor]").val();
                var address=$("[name=blogAddress]").val();
                if(!$.trim(address)&&!$.trim(name)){
                    alert("修改作者和地址不能为空");
                    return false;
                }else if(!$.trim(name)){
                    alert("修改作者不能为空");
                    return false;
                } else if(!$.trim(address)){
                    alert("修改地址不能为空");
                    return false;
                }else {
                    alert("修改成功！");
                    return true;
                }


            })
        })





    </script>

</head>
<body>
<div class="clearfix" id="home_partner">
    <div class="container">
        <h2 class="btitle">
            有伴有爱有力量，再也不怕学习没动力
        </h2>
        <h4 class="subtitle">
            <span>
                学习从来不是轻松事，与其孤身奋战，不如找到志同道合小伙伴一起坚持到底，微冷的雨
            </span>
        </h4>
        <br>
        <div class="row text-center">
            <c:forEach items="${page.bloglist}" var="item">
                <div class="col-sm-4">
                    <div class="partneritem" style="position:relative;">
                        <div>
                            <h1>
                                    ${item.blogAuthor}
                            </h1>
                           <%-- <img width="300px" height="300px" class="img-responsive" src="/BlogHtTemplate-master/image/${item.blogAuthor}.jpg" >--%>
                        </div>
                        <div id="operation" style="position:absolute;background:pink;opacity:0.5;filter:alpha(opacity=50);text-align:center;margin-top:-50px;z-index:20;width: 290px;height: 40px;border: 1px solid red;">
                            <a href="#mymodal" data-toggle="modal" onclick="editBlog(${item.blogId},this)">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=path %>/BlogInfoServlet?action=del&blogId=${item.blogId}" onclick="return del()">删除</a>
                        </div>
                        <%--<h4>
                                ${item.blogAuthor}
                        </h4>--%>
                        <p>
                            <a target="_blank" href="${item.blogAddress}">${item.blogAddress}</a>
                        </p>
                    </div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>

<div style="text-align: center">
    <a href="<%=path%>/BlogInfoServlet?pageIndex=1">首页</a> &nbsp;&nbsp;&nbsp;
    当前页:[${page.pageIndex} / ${page.totapages}] &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex-1}">上一页</a> &nbsp;&nbsp;&nbsp;

    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex+1}">下一页</a> &nbsp;&nbsp;&nbsp;


    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.totapages}">尾页</a>
</div>
<!--弹出的模态框-->
<div id="mymodal" class="modal fade bs-examlpe-modal-sm"><!-- modal固定布局，上下左右都是0表示充满全屏，支持移动设备上使用触摸方式进行滚动。。-->
    <div class="modal-dialog modal-sm"><!-- modal-dialog默认相对定位，自适应宽度，大于768px时宽度600，居中-->
        <div class="modal-content"><!-- modal-content模态框的边框、边距、背景色、阴影效果。-->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">
                    修改
                    <small></small>
                </h4>
            </div>
            <div class="media-body">

                <form action="BlogInfoServlet?action=update" method="post">


                    <input type="hidden" name="blogId" value="" id="rid"/>

                    <div class="col-md-10 col-md-offset-1 myMP">


                        博客作者：<input name="blogAuthor" class="form-control" type="text" placeholder="请输入修改作者"/>
                    </div>
                    <div class="col-md-10 col-md-offset-1 myMP">

                        博客地址： <input name="blogAddress" class="form-control" type="text" placeholder="请输入修改地址"/>
                    </div>

                    <div class="col-md-12 myB">
                        <input class="btn btn-danger form-control" type="submit" value="修改"/>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>

</div>
<%--
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">博客管理</div>
    <!-- Table -->
    <table class="table">
        <tr>
            <td>博客作者</td>
            <td>博客路径</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${page.bloglist}" var="item">
            <tr>
                <td>${item.blogAuthor}</td>
                <td>${item.blogAddress}</td>
                <td>
                    <a href="#mymodal" data-toggle="modal" onclick="editBlog(${item.blogId},this)">修改</a>
                    <a href="<%=path %>/BlogInfoServlet?action=del&blogId=${item.blogId}"><button >删除</button></a>
                </td>
            </tr>
            </tr>

        </c:forEach>



    </table>
</div>

<div style="text-align: center">
    <a href="<%=path%>/BlogInfoServlet?pageIndex=1">首页</a> &nbsp;&nbsp;&nbsp;
    当前页:[${page.pageIndex} / ${page.totapages}] &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex-1}">上一页</a> &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex+1}">下一页</a> &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.totapages}">尾页</a>
</div>--%>
</body>
</html>