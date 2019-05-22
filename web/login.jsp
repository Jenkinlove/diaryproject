<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx=request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>

<%
    String name="";
    String pwd="";
    //取出Cookie
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if(cookie.getName().equals("users")){
            //存着数据（用户名+密码）
            name=cookie.getValue().split("-")[0];
            pwd=cookie.getValue().split("-")[1];

            //再一次存起来（备用）
            request.setAttribute("uname",name);
            request.setAttribute("pwd",pwd);
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${ctx}/css/login.css">
    <script src="${ctx}/style.js"></script>
</head>
<body>
<video  loop="loop" autoplay="autoplay" poster="${ctx}/mp4/xingkong.png">
    <source src="${ctx}/mp4/xingkong.mp4" type="video/mp4">
</video>
<audio src="#" hidden="hidden" autoplay="autoplay" loop="loop"></audio>
<div class="logo">
    <h1>心情树洞</h1><br><span>记录你的美好心情 </span>
</div>
<form class="login" action="${ctx }/LoginServlet" method="post">
	<div style="color:red;font-size:20px; text-align: center;">${error }</div>
    <div><span>账号:</span><input type="text" placeholder="输入已注册的账号" name="username"
                                value="${empty user.username?uname:user.username}"></div>
    <div><span>密码:</span><input type="password" placeholder="输入密码" name="password"
                                value="${empty user.password?pwd:user.password}"></div>
    <input type="checkbox" name="remember" value="yes" checked>记住密码
    <div class="forget"><%--<a href="#">忘记密码</a>--%></div>
    <div id="box" onselectstart="return false;">
        <div class="bgColor"></div>
        <div class="txt" >滑动验证</div>
        <!--给i标签添加上相应字体图标的类名即可-->
        <div class="slider" id="slider"><i class="iconfont icon-double-right"></i></div>
    </div>
    <script>
        //一、定义了一个获取元素的方法
        function getEle(selector){
            return document.querySelector(selector);
        }
        //二、获取到需要用到的DOM元素
        var box = getEle("#box"),//容器
            bgColor = getEle(".bgColor"),//背景色
            txt = getEle(".txt"),//文本
            slider = getEle(".slider"),//滑块
            icon = getEle(".slider>i"),
            successMoveDistance = box.offsetWidth- slider.offsetWidth,//解锁需要滑动的距离
            downX,//用于存放鼠标按下时的位置
            isSuccess = false;//是否解锁成功的标志，默认不成功

        //三、给滑块添加鼠标按下事件
        slider.onmousedown = mousedownHandler;

        //3.1鼠标按下事件的方法实现
        function mousedownHandler(e){
            bgColor.style.transition = "";
            slider.style.transition = "";
            var e = e || window.event || e.which;
            downX = e.clientX;
            //在鼠标按下时，分别给鼠标添加移动和松开事件
            document.onmousemove = mousemoveHandler;
            document.onmouseup = mouseupHandler;
        };

        //四、定义一个获取鼠标当前需要移动多少距离的方法
        function getOffsetX(offset,min,max){
            if(offset < min){
                offset = min;
            }else if(offset > max){
                offset = max;
            }
            return offset;
        }

        //3.1.1鼠标移动事件的方法实现
        function mousemoveHandler(e){
            var e = e || window.event || e.which;
            var moveX = e.clientX;
            var offsetX = getOffsetX(moveX - downX,0,successMoveDistance);
            bgColor.style.width = offsetX + "px";
            slider.style.left = offsetX + "px";

            if(offsetX === successMoveDistance){
                success();
            }
            //如果不设置滑块滑动时会出现问题（目前还不知道为什么）
            e.preventDefault();
        }

        //3.1.2鼠标松开事件的方法实现
        function mouseupHandler(e){
            if(!isSuccess){
                bgColor.style.width = 0 + "px";
                slider.style.left = 0 + "px";
                bgColor.style.transition = "width 0.8s linear";
                slider.style.transition = "left 0.8s linear";
            }
            document.onmousemove = null;
            document.onmouseup = null;
        };

        //五、定义一个滑块解锁成功的方法
        function success(){
            var oBtn=document.getElementById("btn");
            var oSlide=document.getElementById("slider");
            isSuccess = true;
            txt.innerHTML = "解锁成功";
            bgColor.style.backgroundColor ="lightgreen";
            slider.className = "change active";
            icon.className = "iconfont icon-xuanzhong";
            //滑动成功时，移除鼠标按下事件和鼠标移动事件
            slider.onmousedown = null;
            document.onmousemove = null;
            oBtn.style.background="#2f435e";
            oBtn.type="submit";
            oSlide.style.background="url('${ctx}/img/提交,成功,对号.png')";
        }
</script>
    <input id="btn" type="button" value="登录">
    <a href="${ctx}/register.jsp">注册</a>
</form>
<div class="d1"><img src="${ctx}/img/aixin.png" alt=""><h1>Tree Hole</h1></div>
<div class="d2"></div>
</body>
</html>