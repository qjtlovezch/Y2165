<%--
  Created by IntelliJ IDEA.
  User: QiuShao
  Date: 2017/7/6
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8" />
    <title>不落阁后台管理系统</title>
    <link rel="shortcut icon" href="../images/Logo_40.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="/BlogHtTemplate-master/plugin/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="/BlogHtTemplate-master/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="/BlogHtTemplate-master/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="/BlogHtTemplate-master/css/main.css" rel="stylesheet" />

    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/css/blogadd.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function(){

           //通过调用新浪IP地址库接口查询用户当前所在国家、省份、城市、运营商信息
            $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){

                $(".ip").html(remote_ip_info.ip);
                $(".city").html(remote_ip_info.city);
            });
//通过调用QQIP地址库接口查询本机当前的IP地址
            $.getScript('http://fw.qq.com/ipaddress',function(){
                $(".ip").html(IPData[0]);
            });
        });
    </script>
    <script type="text/javascript">
        function display(clock){
            var now=new Date();   //创建Date对象
            var year=now.getFullYear(); //获取年份
            var month=now.getMonth(); //获取月份
            var date=now.getDate();  //获取日期
            var day=now.getDay();  //获取星期
            var hour=now.getHours(); //获取小时
            var minu=now.getMinutes(); //获取分钟
            var sec=now.getSeconds(); //获取秒钟
            month=month+1;
            var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
            var week=arr_week[day];  //获取中文的星期
            var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
            clock.innerHTML="当前时间："+time; //显示系统时间
        }
        window.onload=function(){
            window.setInterval("display(clock)", 1000);
        }
    </script>
    <script type="text/javascript">
        $(function () {
            $("form").submit(function () {

                var name = $("[name=blogAuthor]").val();
                var address = $("[name=blogAddress]").val();

                if (!$.trim(address) && !$.trim(name)) {
                    alert("添加作者和地址不能为空");
                    return false;
                } else if (!$.trim(name)) {
                    alert("添加作者不能为空");
                    return false;
                } else if (!$.trim(address)) {
                    alert("添加地址不能为空");
                    return false;
                } else {
                    alert("添加成功！");
                    return true;
                }



            })
        })

    </script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <!--顶部-->
    <div class="layui-header">
        <div class="ht-console">
            <div class="ht-user">
                <img src="/BlogHtTemplate-master//images/Logo_40.png" />
                <a class="ht-user-name">超级管理员</a>
            </div>
        </div>
        <span class="sys-title">Blog后台管理系统</span>
        <ul class="ht-nav">
            <li class="ht-nav-item">
                欢迎您:<%=session.getAttribute("userName")%>
            </li>
            <li class="ht-nav-item">
                <a target="_blank" href="javascript:;">前台入口</a>
            </li>
            <li class="ht-nav-item">
                <a href="javascript:;" id="individuation"><i class="fa fa-tasks fa-fw" style="padding-right:5px;"></i>个性化</a>
            </li>
            <li class="ht-nav-item">

                <a href="/BlogHtTemplate-master/html/index.html">注销</a>
            </li>
        </ul>
    </div>
    <!--侧边导航-->
    <div class="layui-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="leftnav">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;"><i class="fa fa-home"></i>首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-file-text"></i>博客管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="BlogInfoServlet" data-id="1">博客列表</a></dd>
                        <dd><a href="#mymodal" data-toggle="modal" data-id="2" onclick="this">添加博客</a></dd>
                        <!-- <dd><a href="#mymodal:;" data-url="datalist.html" data-id="2">添加博客</a></dd>-->
                        <dd><a href="javascript:;" data-url="datalist.html" data-id="3">时光轴管理</a></dd>
                        <dd><a href="javascript:;">笔记本管理</a></dd>
                        <dd><a href="javascript:;" data-url="datalist.html" data-id="4">文章回收站</a></dd>
                        <dd><a href="javascript:;">资源回收站</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-user"></i>用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">全部用户</a></dd>
                        <dd><a href="javascript:;">黑名单管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-wrench"></i>教学管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="1" data-url="/BlogHtTemplate-master/html/teacher/homeadd.jsp" >作业布置</a></dd>
                        <dd><a href="javascript:;" data-id="2" data-url="/HomeServlet?action=list" >作业查看</a></dd>
                        <dd><a href="javascript:;">学院考勤</a></dd>
                        <dd><a href="javascript:;" data-url="datalist.html" data-id="5">网站公告</a></dd>
                        <dd><a href="javascript:;" data-url="datalist.html" data-id="6">更新日志</a></dd>
                        <dd><a href="javascript:;" data-url="datalist.html" data-id="7">留言管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-cog"></i>系统配置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">SEO配置</a></dd>
                        <dd><a href="javascript:;">QQ互联</a></dd>
                        <dd><a href="javascript:;">数据库配置</a></dd>
                        <dd><a href="javascript:;">站点地图</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-info-circle"></i>其他信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">操作日志</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!--收起导航-->
    <div class="layui-side-hide layui-bg-cyan">
        <i class="fa fa-long-arrow-left fa-fw"></i>收起导航
    </div>
    <!--主体内容-->
    $ip=get_clieat_ip();
    <div class="layui-body">
        <div style="margin:0;position:absolute;top:4px;bottom:0px;width:100%;" class="layui-tab layui-tab-brief" lay-filter="tab" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li lay-id="0" class="layui-this">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <p style="padding: 10px 15px; margin-bottom: 20px; margin-top: 10px; border:1px solid #ddd;display:inline-block;">
                        本次登陆
                        <span style="padding-left:1em;">IP：<%=session.getAttribute("ipAddress")%></span>
                       <%-- <span style="padding-left:1em;">IP：<%=request.getAttribute("ipAddress")%></span>--%>
                        <span style="padding-left:1em;">地点：<span class="country"></span><span class="city"></span></span>
                        <span style="padding-left:1em;"><span id="clock" ></span></span>

                    </p>
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>统计信息</legend>
                        <div class="layui-field-box">
                            <div style="display: inline-block; width: 100%;">
                                <div class="ht-box layui-bg-blue">
                                    <p>123</p>
                                    <p>用户总数</p>
                                </div>
                                <div class="ht-box layui-bg-red">
                                    <p>32</p>
                                    <p>今日注册</p>
                                </div>
                                <div class="ht-box layui-bg-green">
                                    <p>55</p>
                                    <p>今日登陆</p>
                                </div>
                                <div class="ht-box layui-bg-orange">
                                    <p>123</p>
                                    <p>文章总数</p>
                                </div>
                                <div class="ht-box layui-bg-cyan">
                                    <p>321</p>
                                    <p>资源总数</p>
                                </div>
                                <div class="ht-box layui-bg-black">
                                    <p>231</p>
                                    <p>笔记总数</p>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
    <!--底部信息-->
    <div class="layui-footer">
        <p style="line-height:44px;text-align:center;">不落阁后台管理系统 - Design By LY</p>
    </div>
    <!--快捷菜单-->
    <div class="short-menu" style="display:none">
        <fieldset class="layui-elem-field layui-field-title">
            <legend style="color:#fff;padding-top:10px;padding-bottom:10px;">快捷菜单</legend>
            <div class="layui-field-box">
                <div style="width:832px;margin:0 auto;">
                    <div class="windows-tile windows-two">
                        <i class="fa fa-file-text"></i>
                        <span data-url="BlogInfoServlet" data-id="1">博客管理</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-volume-up"></i>
                        <span data-url="datalist.html" data-id="2">网站公告</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-comments-o"></i>
                        <span data-url="datalist.html" data-id="3">留言管理</span>
                    </div>
                    <div class="windows-tile windows-two">
                        <i class="fa fa-handshake-o"></i>
                        <span data-url="datalist.html" data-id="4">友情链接</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-arrow-circle-right"></i>
                        <span data-url="datalist.html" data-id="5">更新日志</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-wrench"></i>
                        <span data-url="datalist.html" data-id="6">操作日志</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-tags"></i>
                        <span data-url="datalist.html" data-id="7">资源管理</span>
                    </div>
                    <div class="windows-tile windows-one">
                        <i class="fa fa-pencil-square-o"></i>
                        <span data-url="datalist.html" data-id="8">笔记管理</span>
                    </div>
                    <div class="windows-tile windows-two">
                        <i class="fa fa-hourglass-half"></i>
                        <span data-url="datalist.html" data-id="9">时光轴管理</span>
                    </div>
                    <div style="clear:both;"></div>
                </div>
            </div>
        </fieldset>

    </div>
    <!--个性化设置-->
    <div class="individuation animated flipOutY layui-hide">
        <ul>
            <li><i class="fa fa-cog" style="padding-right:5px"></i>个性化</li>
        </ul>
        <div class="explain">
            <small>从这里进行系统设置和主题预览</small>
        </div>
        <div class="setting-title">设置</div>
        <div class="setting-item layui-form">
            <span>侧边导航</span>
            <input type="checkbox" lay-skin="switch" lay-filter="sidenav" lay-text="ON|OFF" checked>
        </div>
        <div class="setting-item layui-form">
            <span>管家提醒</span>
            <input type="checkbox" lay-skin="switch" lay-filter="steward" lay-text="ON|OFF" checked>
        </div>
        <div class="setting-title">主题</div>
        <div class="setting-item skin skin-default" data-skin="skin-default">
            <span>低调优雅</span>
        </div>
        <div class="setting-item skin skin-deepblue" data-skin="skin-deepblue">
            <span>蓝色梦幻</span>
        </div>
        <div class="setting-item skin skin-pink" data-skin="skin-pink">
            <span>姹紫嫣红</span>
        </div>
        <div class="setting-item skin skin-green" data-skin="skin-green">
            <span>一碧千里</span>
        </div>
    </div>
</div>
<!-- layui.js -->
<script src="/BlogHtTemplate-master/plugin/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '/BlogHtTemplate-master/js/'
    }).use('main');
</script>

<div id="mymodal" class="modal fade bs-examlpe-modal-sm"><!-- modal固定布局，上下左右都是0表示充满全屏，支持移动设备上使用触摸方式进行滚动。。-->
    <div class="modal-dialog modal-sm"><!-- modal-dialog默认相对定位，自适应宽度，大于768px时宽度600，居中-->
        <div class="modal-content"><!-- modal-content模态框的边框、边距、背景色、阴影效果。-->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">
                    添加
                    <small>邱少</small>
                </h4>
            </div>
            <div class="media-body">
                <form action="BlogInfoServlet?action=add" method="post">
                    <div class="col-md-10 col-md-offset-1 myMP">
                        <input name="blogAuthor" class="form-control" type="text" placeholder="博客作者"/>
                    </div>
                    <div class="col-md-10 col-md-offset-1 myMP">
                        <input name="blogAddress" class="form-control" type="text" placeholder="博客地址"/>
                    </div>

                    <div class="col-md-12 myB">

                        <input class="btn btn-danger form-control" type="submit"  value="添加"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>

</div>
</body>
</html>
