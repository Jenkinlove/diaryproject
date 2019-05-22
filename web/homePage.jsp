<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String ctx=request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>

<%
    int bgnum=(int)(Math.random()*38+1);
    pageContext.setAttribute("bgnum",bgnum);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="${ctx}/css/homePage.css">
    <script>
        window.onload=function () {
            var oDiv=document.getElementById('foot');
            var oUl=document.getElementById('ul1');
            var aBtn=oUl.getElementsByTagName('li');
            var aDiv=oDiv.getElementsByTagName('div');
            for(var i=0;i<aBtn.length;i++){
                aBtn[i].index=i;
                aBtn[i].onmouseover=function () {
                    for(var i=0;i<aBtn.length;i++) {
                        aBtn[i].className = '';
                        aDiv[i].style.display='none';
                    }
                    this.className='active';
                    aDiv[this.index].style.display='block';
                };
            }
            var oDiv2=document.getElementById('all2');
            var aImg=oDiv2.getElementsByTagName('img');
            var oDiv1=document.getElementById('mark');
            var oDiv3=document.getElementById('fangda');
            var oImg=document.getElementById('datu');

            var oSpan=document.getElementById('gb');
            for (var a=0;a<aImg.length;a++){
                aImg[a].index=a;
            aImg[a].onclick=function (){
                oDiv1.style.display="block";
                oImg.src=aImg[this.index].src;

                }
                }
                oSpan.onclick=function () {
                    oDiv1.style.display="none";
                }
            };

    </script>
</head>
<body>
<form action="${ctx}/HomePageServlet" method="post">
<div class="head">
    <div class="logo"><p>首页</p></div>
    <div class="enter">
        <c:if test="${empty username}">
            <a href="${ctx}/login.jsp">个人空间</a>
        </c:if>
        <c:if test="${!empty username}">
            <a
                    href="${ctx}/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId=${moodId}">个人空间
            </a>
        </c:if>
    </div>
    <c:if test="${empty username}">
        <div class="wel"><a href="${ctx}/login.jsp">登录</a><a href="${ctx}/register.jsp">注册</a></div>
    </c:if>
    <c:if test="${!empty username}">
        <div class="welcome">欢迎
            <span>${username}</span><a
                    href="${ctx}/ExitServlet" class="out">退出</a></div>
    </c:if>

</div>
<div class="center" style="background-image: url('${ctx}/img/background_img/bg${bgnum}.jpg')">
    <div class="baz"><img src="${ctx}/img/aixin.png" alt=""><h1>Tree Hole</h1></div>
        <p>${homePageGood.h_stmt}</p>

</div>
<div id="foot" class="foot">
<ul id="ul1">
    <li class="active">每日一文</li>
    <li>今日美图</li>
    <li>轻音乐</li>
</ul>
    <div style="display: block" class="all1">
        <h1>${homePageGood.h_title}</h1>
        <span>${homePageGood.h_author}</span> <br>
        <p>${homePageGood.h_article}</p>

        <input type="submit" value="随机文章">
    </div>
    <div id="all2" class="all2">
        <c:forEach items="${homePageRan}" var="pageRan">
            <img src="${ctx}/img/home_mt/${pageRan.ran_img}" alt="">
        </c:forEach>
        <%--<img src="${ctx}/img/home_mt/1.jpg" alt="">--%>

        <input type="submit" value="随机图片">
    </div>
    <div class="all3">
        <c:forEach items="${homePageRan}" var="pageRan">
            <div><img src="${ctx}/img/background_img/${pageRan.ran_ad_img}" alt=""><audio
                    src="${ctx}/audio/${pageRan.ran_ad}"
                    controls="controls" loop="loop" preload="auto"></audio></div>
        </c:forEach>
        <%--<div><img src="${ctx}/img/s2.jpg" alt=""><audio src="${ctx}/mp4/9313.wav" controls="controls" loop="loop" preload="auto"></audio></div>--%>
        <input type="submit" value="随机音乐">
    </div>
</div>
<div id="mark" class="mark"><div class="fangda" id="fangda"><img id="datu" src="" alt="">
    <span id="gb"></span></div></div>
</form>
</body>

</html>