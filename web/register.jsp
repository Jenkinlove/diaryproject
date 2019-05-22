<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
    <link rel="stylesheet" href="${ctx}/css/register.css">
</head>
<body>
<div class="head">
    <div class="logo"><a href=""><img src="${ctx}/img/爱心.png"></a>
        <h3>欢迎注册树洞账号!</h3></div>
</div>
<div class="fg"></div>
<div class="content">
    <div class="left">
        <form name="form1" action="${ctx}/RegisterServlet" method="post" id="reg_form">
            <div style="color:red;font-size:20px; text-align: center;">${error_reg }</div>
            <div class="input1"><span><span class="box">*</span>用户名:</span><input type="text"
                                                                                  name="username"
                                                                                  value="${user.username}"
                                                                                  required="required"
                                                                                  placeholder="可使用字母、数字、汉字">
            </div>
            <%--<div class="input6"><span><span class="box">*</span>账号:</span><input type="text" placeholder="可使用字母、数字"></div>--%>
            <div class="input3" id="input3"><span><span class="box">*</span>密码:
            </span><input
                    required="required"
                    name="password"
                    value="${user.password}"
                    type="password"
                    id="pwd1"
                    placeholder="6~16个字符，区分大小写">
            </div>
            <div class="input4" id="input4"><span><span class="box">*</span>确认密码:
            </span><input
                    required="required"
                    id="pwd2"
                    type="password"
                    value="${user.password}"
                    placeholder="请再次填写密码">
            </div>
            <div class="input2"><span><span class="box">*</span>邮箱地址:</span><input
                    required="required"
                    type="email"
                    value="${user.email}"
                    name="email"
                    placeholder="建议使用QQ邮箱">
            </div>
            <div class="input5"><span><span class="box">*</span>验证码:
            </span><input
                    name="code"
                    required="required"
                    type="text">
                <img src="${ctx}/CheckCodeServlet" alt="">
                <a href="${ctx}/register.jsp">看不清楚？换张图片</a></div>
            <div class="c"><input id="c" type="checkbox">同意 <a href="">"服务条款"</a>和 <a
                    href="">"隐私权相关政策"</a></div>
            <input id="input1" type="button" value="立即注册">
        </form>
    </div>
    <div class="right">
        <div class="xuanchuang"><h1>用"心情树洞"</h1>
            <p>记录你的美好心情!</p></div>

    </div>
</div>
<script>
    window.onload = function () {
        var oDiv = document.getElementById("c");
        var oInput = document.getElementById("input1");
        oDiv.onclick = function () {
            var p1 = document.getElementById("pwd1").value;
            var p2 = document.getElementById("pwd2").value;
            if (oDiv.checked === true) {
                oInput.style.backgroundColor = "#4fab39";

                oInput.onclick = function () {

                    if (p1 === p2) {
                        oInput.type = "submit";
                    } else {
                        oInput.type = "button";
                        alert("您输入的密码不一致");
                    }

                }
            } else {
                oInput.type = "button";
            }
        };

    }

</script>
</body>
</html>