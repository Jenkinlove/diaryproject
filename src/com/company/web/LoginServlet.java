package com.company.web;

import com.company.domain.User;
import com.company.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");

        LoginService loginService = new LoginService();
        try {
            User user = loginService.checkUser(name, pwd);
            int uid=user.getUid();
            HttpSession session = request.getSession();
            session.setAttribute("uid",uid);
            //1.把姓名密码保存到cookie中
           // System.out.println(user);
            //判断是够点击保存密码
            String remember = request.getParameter("remember");

            //新建cookie
            Cookie cookie = new Cookie("users", name+"-"+pwd);
            //System.out.println(name+" "+pwd);
            //2 判断remeber
            if (remember != null && remember.equals("yes")) {
                // "yes" 勾选了--- 设置有效时间为一个月
                cookie.setMaxAge(60 * 60 * 24 * 30);
            } else {
                // null 没勾选 --- 设置cookie的有效时间为0
                cookie.setMaxAge(0);
            }
            //3 将cookie添加到response
            response.addCookie(cookie);

            //2.跳转到后台首页
            //重定向，让浏览器去跳转到指定的位置
            //转发到moodchoose
            request.getRequestDispatcher("/moodChoose.jsp").forward(request,response);
        } catch (Exception e) {

            if (e.getMessage().equals("用户名或密码错误")) {
                //跳回登录首页，回显错误信息
                request.setAttribute("error", e.getMessage());
                //转发，服务器内部转发
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

}
