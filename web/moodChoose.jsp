<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String ctx=request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>心情界面</title>
    <link rel="stylesheet" href="${ctx}/css/moodChoose.css">
</head>
<body>
<h1>点击气球<br>选择您此时此刻的心情</h1>
<div id="div1" class="qiqiu1 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=1"><img src="${ctx}/img/气球1.png"></a>
    <div class="text">开心</div>
</div>
<div id="div2" class="qiqiu2 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=2"><img src="${ctx}/img/气球2.png"></a>
    <div class="text">伤感</div>
</div>
<div id="div3" class="qiqiu3 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=3"><img src="${ctx}/img/气球3.png"></a>
    <div class="text">激动</div>
</div>
<div id="div4" class="qiqiu4 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=4"><img src="${ctx}/img/气球4.png"></a>
    <div class="text">感激</div>
</div>
<div id="div5" class="qiqiu5 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=5"><img src="${ctx}/img/气球5.png"></a>
    <div class="text">懊丧</div>
</div>
<div id="div6" class="qiqiu6 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=6"><img src="${ctx}/img/气球1.png"></a>
    <div class="text">愤怒</div>
</div>
<div id="div7" class="qiqiu7 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=7"><img src="${ctx}/img/气球2.png"></a>
    <div class="text">欢喜</div>
</div>
<div id="div8" class="qiqiu8 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=8"><img src="${ctx}/img/气球3.png"></a>
    <div class="text">忧愁</div>
</div>
<div id="div9" class="qiqiu9 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=9"><img src="${ctx}/img/气球4.png"></a>
    <div class="text">烦乱</div>
</div>
<div id="div10" class="qiqiu10 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=10"><img src="${ctx}/img/气球5.png"></a>
    <div class="text">失落</div>
</div>
<div id="div11" class="qiqiu11 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=7"><img src="${ctx}/img/气球5.png"></a>
    <div class="text">欢喜</div>
</div>
<div id="div12" class="qiqiu12 qiqiu">
    <a href="${ctx}/MoodChooseServlet?moodId=11"><img src="${ctx}/img/气球3.png"></a>
    <div class="text">快乐</div>
</div>
<div class="yun1 yun"> </div>
<div class="yun2 yun"> </div>
<div class="yun3 yun"> </div>
<div class="yun4 yun"> </div>
</body>
</html>