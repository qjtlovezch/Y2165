<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/7/7
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>添加作业</title>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"><link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin","douban"],"viewText":"分享到：","viewSize":"24"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<form class="navbar-form navbar-left" role="search" action="/HomeServlet?action=add" method="post">
    <div class="form-group">
        <a class="bshareDiv" href="http://www.bshare.cn/share">分享</a>
        <script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=<您的uuid>&style=-1"></script>

        <script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/addons/bsharePop.js"></script>
        <br/>
    <br/>
    年级：<input type="text" name="homeGrade" class="form-control" placeholder="请输入年级"/>
    <br/>
    <br/>
    教员：<input type="text" name="homeTeacher" class="form-control" placeholder="请输入教员姓名"/>
    <br/>
    <br/>
    章节：<input type="text" name="homeChapter" class="form-control" placeholder="请输入章节"/>
    <br/>
    <br/>
    内容： <div>
        <script id="editor" type="text/plain" name="homeContent"></script>
    </div>

</div>
    <br/>
    <br/>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <button type="submit" class="btn btn-danger">添加</button>

</form>

<script type="text/javascript">

    //实例化编辑器
    var ue = UE.getEditor( 'editor', {
        autoHeightEnabled: true,
        autoFloatEnabled: true,
        initialFrameWidth: 690,
        initialFrameHeight:483
    });

</script>
</body>
</html>
