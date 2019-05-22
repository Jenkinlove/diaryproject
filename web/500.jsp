<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String ctx=request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>500-对不起！服务器出问题了</title>
    <style type="text/css">

        .head404{ width:580px;
            height:234px;
            margin-top: 50px;
            margin-left: 550px;
            background:url("${ctx}/img/500.png") no-repeat;
        }

        .txtbg404{ width:499px; height:169px; margin:10px auto 0 auto; background:url(https://www.daixiaorui.com/Public/images/txtbg404.png) no-repeat;}

        .txtbg404 .txtbox{ width:390px; position:relative; top:30px; left:60px;color:#eee; font-size:13px;}

        .txtbg404 .txtbox h2 {
            width: 400px;
            height: 25px;
            margin-bottom: 20px;
            line-height:25px;}

        .txtbg404 .txtbox .paddingbox { padding-top:15px;}
        .txtbg404 .txtbox p{
            margin-right: 60px;
        }

        .txtbg404 .txtbox p a { color:#eee; text-decoration:none;}

        .txtbg404 .txtbox p a:hover { color:#FC9D1D;}

    </style>

</head>



<body bgcolor="#494949">

<div class="head404"></div>

<div class="txtbg404">

    <div class="txtbox">

        <h2>服务器有点小情绪，按返回'上一页'进行操作。</h2>

        <p class="paddingbox">请点击以下链接继续浏览网页</p>

        <p style="display: inline-block">》<a style="cursor:pointer" onclick="history.back()">返回上一页面</a></p>

        <p style="display: inline-block">》<a href="${ctx}/HomePageServlet">返回网站首页</a></p>

    </div>

</div>

</body>

</html>
</html>