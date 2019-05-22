<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);

%>
<%
    int bgnum=(int)(Math.random()*38+1);
    pageContext.setAttribute("bgnum",bgnum);

%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>写心情界面</title>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <link rel="stylesheet" href="${ctx}/css/writeDiary.css">
    <script>
        $(function () {
            $("#button1").click(function () {

                $("#form1").attr("action",
                    "${ctx}/AddDataServlet?d_background=${empty
                 filename?1:filename}");
                  $("#form1").attr("enctype","application/x-www-form-urlencoded");
                $("form").submit();
            });
            $("#button2").click(function () {

                $("#form1").attr("action", "${ctx}/UploadServlet");
                $("#form1").attr("enctype","multipart/form-data");
                $("form").submit();
            });
            $("#image").click(function () {
                $("#uploadfile").click();
            });
            $("#uploadfile").change(function () {

                var files = $(this)[0].files[0];    //获取文件信息
                if (files) {
                    var reader = new FileReader();  //调用FileReader
                    reader.onload = function (evt) {   //读取操作完成时触发。
                        $("#img2").attr('src', evt.target.result)  //将img标签的src绑定为DataURL
                    };
                    reader.readAsDataURL(files); //将文件读取为 DataURL(base64)
                } else {
                    alert("上传失败");
                }
            })
        })
    </script>
    <script>
        window.onload = function () {
            var oDiv = document.getElementById('left');
            var oDiv1 = document.getElementById('close');
            var myDate = new Date();
            var oP = document.getElementById('p1');
            var oP2 = document.getElementById('p2');
            var oImg = document.getElementById('img1');
            var oSpan = document.getElementById('xuanzhe');
            var oDiv2 = document.getElementById('weth');
            var oImg3 = document.getElementById('img3');
            var oImg4 = document.getElementById('img4');
            var oImg5 = document.getElementById('img5');
            var aImg = oDiv2.getElementsByTagName('img');
            oP.text = myDate.toLocaleDateString();
            oP2.text = myDate.getMonth() + 1 + "月" + myDate.getDate() + "号的心情";
            oDiv.onclick = function () {
                oDiv.style.transform = "rotateY(-170deg)";
            };
            oDiv1.onclick = function () {
                oDiv.style.transform = "rotateY(0deg)";
            };
            <c:if test="${!empty weather}">
                <c:choose>
                    <c:when test="${weather eq '2'}">
                        oImg.src='${ctx}/ximg/2.png';
                    </c:when>
                    <c:when test="${weather eq '3'}">
                    oImg.src='${ctx}/ximg/rain.png';
                    </c:when>
                    <c:when test="${weather eq '4'}">
                    oImg.src='${ctx}/ximg/1.png';
                    </c:when>
                </c:choose>
            </c:if>
            oSpan.onclick = function () {
                if (oDiv2.style.display === "block") {
                    oDiv2.style.display = "none";
                }
                else{
                    oDiv2.style.display = "block";
                }

            };
            oImg3.onclick=function () {
                a = oImg.src;
                oImg.src = this.src;
                this.src = a;
                oDiv2.style.display = "none";
                document.getElementById("weath").value=2;
            };
            oImg4.onclick=function () {
                a = oImg.src;
                oImg.src = this.src;
                this.src = a;
                oDiv2.style.display = "none";
                document.getElementById("weath").value=3;

            };
            oImg5.onclick=function () {
                a = oImg.src;
                oImg.src = this.src;
                this.src = a;
                oDiv2.style.display = "none";
                document.getElementById("weath").value=4;

            };

            <c:if test="${!empty filename}">
                oDiv.style.transform = "rotateY(-170deg)";
            </c:if>
        }
    </script>


</head>
<body>
<div class="head">
    <a href="${ctx}/HomePageServlet">
        <div class="logo"><p>首页</p></div>
    </a>
    <a class="geren"
       href="${ctx}/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId=${moodId}">个人空间
    </a>
</div>
<form id="form1" enctype="" action=""
       method="post">
    <input id="weath" name="weather" type="hidden" value="${empty weather?1:weather}">
    <div id="center" class="center">
        <div id="close"></div>
        <div id="right" class="right">
            <div id="left" class="left">
                <div class="front"><img src="${ctx}/ximg/riji1.jpg" alt="">
                    <div class="logo"><img class="img2" src="${ctx}/ximg/aixin.png" alt="">
                        <h1>Tree Hole</h1></div>
                    <p>记录你的每日心情</p></div>

                <div id="back" class="back">
                    <h1>我的心情</h1>
                    <span>标题:</span><input type="text" placeholder="描述一下你的心情" name="title"
                                           value="${title}"/>
                    <div class="cave">
                        <input id="button1" type="submit" value="保存">
<%--                        <%--<img src="${ctx}/ximg/baocun.png" alt="">--%>
                    </div>
                </div>
            </div>

            <div class="day">
                <div class="head1"><a id="p2"></a>
                    <span id="xuanzhe"><img id="img1"  src="${ctx}/ximg/tianqi.png"
                                            alt=""><a
                            id="p1"></a></span>
                        <div id="weth" class="weth">
                            <img  id="img5" src="${ctx}/ximg/1.png" alt="">
                            <img id="img3" src="${ctx}/ximg/2.png" alt="">
                            <img  id="img4"src="${ctx}/ximg/rain.png" alt="">
                        </div>
                </div>
                <div class="center1"><img id="img2"
                                          src='${ctx}/img/mood_img/${empty filename?"writeImg.jpg":filename}'
                                          alt="">

                        <div class="shangchuan">
                            <input name="filedb" type="file" style="display:none" id="uploadfile"
                                   accept="image/*"/>
                            <img src="${ctx}/ximg/xiangji.png" id="image" title="自选图片">


                        </div>
                    <div class="sc" title="上传"><input id="button2" type="submit" value="">
                        <img title="上传" src="${ctx}/img/shangchuan.png" alt=""></div>

                </div>
                <div class="foot1">
                    <textarea name="content" class="word" id="word" cols="55"
                              rows="10">${content}
                    </textarea>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>