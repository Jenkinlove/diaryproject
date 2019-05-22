<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String cxt = request.getContextPath();
    pageContext.setAttribute("cxt",cxt);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    int bgnum=(int)(Math.random()*38+1);
    int audio_num=(int)(Math.random()*25+1);
    pageContext.setAttribute("audio_num",audio_num);
    pageContext.setAttribute("bgnum",bgnum);
    pageContext.setAttribute("bgimg","bg"+bgnum);
    pageContext.setAttribute("bg","bg");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人空间</title>
    <script src="${cxt}/js/index.js"></script>
    <link rel="stylesheet" href="${cxt}/css/personalSpace.css">
    <script src="${cxt}/js/bottom1.js"></script>
    <script src="${cxt}/js/bottom2.js"></script>
    <script src="${cxt}/js/bottom3.js"></script>

    <link rel="stylesheet" href="${cxt}/css/pageStyle.css">
    <link rel="stylesheet" href="${cxt}/css/bottom.css">
    <script>
        window.onload=function () {
            var oDiv2=document.getElementById('all');
            var oH=document.getElementById('h1');
            var aImg=oDiv2.getElementsByTagName('img');
            var aP=oDiv2.getElementsByTagName('p');
            var aDiv=oDiv2.getElementsByTagName('div');
            var oDiv1=document.getElementById('son');
            var oDiv3=document.getElementById('fangda');
            var oImg=document.getElementById('datu');
            var oSpan=document.getElementById('spa');
            var oP=document.getElementById('pcontent');
            var aA=oDiv2.getElementsByTagName('a');
            var oSp2=document.getElementById('spa2');
            var oSp3=document.getElementById('spa3');
            var oTs=document.getElementById('tishi');
            var oNo=document.getElementById('no');
            var oYes=document.getElementById('yes');
            var oSpan1=document.getElementById('data');
            var aH6=oDiv2.getElementsByTagName('h6');
            var aH5=oDiv2.getElementsByTagName('h5');
            var aH4=oDiv2.getElementsByTagName('h4');
            var aH3=oDiv2.getElementsByTagName('h3');
            var aDel=oDiv2.getElementsByTagName('a');
            for (var a=0;a<aDiv.length;a++){
                aDiv[a].index=a;
                aDiv[a].onclick=function (e){
                    oDiv1.style.display="block";
                    oImg.src=aImg[this.index].src;
                    e.stopPropagation();
                    for (var i=0;i<aP.length;i++){
                        aP[i].index=i;
                        oH.innerHTML=aP[this.index].innerHTML;
                    oP.innerHTML=aH6[this.index].innerHTML;
                        oSp2.innerHTML=aH5[this.index].innerHTML;
                        if(1==aH4[this.index].innerHTML){
                            oSp3.src='${cxt}/ximg/tianqi.png';
                        }else if(2==aH4[this.index].innerHTML){
                            oSp3.src='${cxt}/ximg/2.png';
                        }else if(3==aH4[this.index].innerHTML){
                            oSp3.src='${cxt}/ximg/rain.png';
                        }else if(4==aH4[this.index].innerHTML){
                            oSp3.src='${cxt}/ximg/1.png';
                        }
                        // aDel[this.index].onclick=function (e) {
                        //     oTs.style.display="block";
                        //     if(e && e.stopPropagation){
                        //         //W3C取消冒泡事件
                        //         e.stopPropagation();
                        //         e.preventDefault();
                        //     }else{
                        //         //IE取消冒泡事件
                        //         window.event.cancelBubble = true;
                        //     }
                        // };


                    }

                };
                for (var b=0;b<aDel.length;b++){
                    aDel[b].index=b;
                    aDel[b].onclick=function (e) {
                        oTs.style.display="block";
                        if(e && e.stopPropagation){
                            //W3C取消冒泡事件
                            e.stopPropagation();
                            e.preventDefault();
                        }else{
                            //IE取消冒泡事件
                            window.event.cancelBubble = true;
                        }
                        oSpan1.innerHTML=aH5[this.index].innerHTML;
                        oYes.href="${cxt}/PersonalSpaceServlet?action=deletedata&d_id="+aH3[this.index].innerHTML;
                    }
                }
                aDiv[a].onmouseover=function () {
                    aA[this.index].style.display="block";
                };
                aDiv[a].onmouseout=function () {
                    aA[this.index].style.display="none";
                }
            }
            oSpan.onclick=function () {
                oDiv1.style.display="none";
            };
            oNo.onclick=function () {
                oTs.style.display="none";
            }
        }
    </script>
    <%--<style>
        .center{
            width: 100%;
            height: 650px;
            margin: 0 auto;
            background: url("${cxt}/img/background_img/${mood.image}");
            border: 1px solid #000;

        }
    </style>--%>
</head>
<body>
<div id="tishi" class="tishi" style="display:none ">
    <p><img src="${cxt}/img/jinggao.png" alt="">要删除<span id="data"></span>的心情吗?</p>
    <a id="yes" href="${cxt}/PersonalSpaceServlet?action=deletedata&d_id=">是的，忘记这一切</a>
    <a id="no" href="javascript:;">否</a>
</div>
<div class="head">
    <div class="logo"><p>个人空间</p></div>
    <div class="back"><a href="${cxt}/HomePageServlet">首页</a></div>

    <div class="wel">欢迎
        <span>${username}</span><a
                href="${cxt}/ExitServlet" class="out">退出</a></div>
    <a href="${cxt}/writeDiary.jsp"><div class="right">
        <img src="${cxt}/img/笔.png" alt=""><span>写心情</span></div></a>
</div>
<audio src="${cxt}/audio/${mood.audio}${audio_num}.mp3" autoplay="autoplay"
       loop="loop"></audio>
<div class="center"
     style="background-image: url('${cxt}/img/background_img/${mood.image}${bgnum}.jpg')">
    <div class="baz"><img src="${cxt}/img/爱心.png" alt=""><h1>Tree Hole</h1></div>
    <p>${mood.moodSentence}</p>
</div>
<p>往日心情</p>
<div class="foot">
    <div class="all" id="all">
        <c:if test="${empty pageBean.diariesList}">
            您还没有开始写日记哦，点击上方的写日记开始记录您的喜怒哀乐和生活中的点点滴滴吧...
        </c:if>
        <c:if test="${!empty pageBean.diariesList}">
            <c:forEach items="${pageBean.diariesList}" var="giaries">
                <div>
                    <p id="p10">${giaries.title}</p>
                    <h3 style="display: none;">${giaries.d_id}</h3>
                    <h4 id="content3" style="display: none;">${giaries.weather}</h4>
                    <h5 id="content2" style="display: none;"><fmt:formatDate
                            value="${giaries.date}" pattern="yyyy-MM-dd"/> </h5>
                    <h6 id="content1" style="display: none;">${giaries.content}</h6>
                    <span class="glass"><img src="${cxt}/img/mood_img/${giaries.d_background}"
                                             alt=""></span>
                    <a id="del" title="删除"></a>
<%--                    <a id="del" href="${cxt}/PersonalSpaceServlet?action=deletedata&d_id--%>
<%--                    =${giaries.d_id}"--%>
<%--                       title="删除"></a>--%>
                </div>
            </c:forEach>
        </c:if>

        <%--<div class="card">
            <p>笑是一种没有副作用的镇静剂</p>
            <div class="glass"><img src="${cxt}/img/happy1.jpg" alt=""></div>
        </div>--%>

    </div>
</div>
<!--分页-->
<div id="page" class="page_div">aaa</div>
<div class="son" id="son">
    <span id="spa2"></span><img class="tianqi" id="spa3" src="${cxt}/img/1.png" alt=""
                                title="天气">
    <img id="datu" src="" alt="">
    <span id="spa"></span>
    <p class="pc2"><h1 id="h1"></h1></p>
    <p class="pc1"><p id="pcontent"></p></p>

</div>
<div class="end"></div>
<script src="${cxt}/js/jquery.min.js"></script>
<script type="text/javascript" src="${cxt}/js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:${pageBean.currentPage},
        totalPage: ${pageBean.totalPage},
        totalSize: ${pageBean.totalCount},
        callback: function(num) {
            $(window).attr('location','${cxt }/PersonalSpaceServlet?action=getPageData&currentPage='+num+'&moodId=${mood.moodId}');
        }
    });
</script>
</body>
</html>