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
            //1.���������뱣�浽cookie��
           // System.out.println(user);
            //�ж��ǹ������������
            String remember = request.getParameter("remember");

            //�½�cookie
            Cookie cookie = new Cookie("users", name+"-"+pwd);
            //System.out.println(name+" "+pwd);
            //2 �ж�remeber
            if (remember != null && remember.equals("yes")) {
                // "yes" ��ѡ��--- ������Чʱ��Ϊһ����
                cookie.setMaxAge(60 * 60 * 24 * 30);
            } else {
                // null û��ѡ --- ����cookie����Чʱ��Ϊ0
                cookie.setMaxAge(0);
            }
            //3 ��cookie��ӵ�response
            response.addCookie(cookie);

            //2.��ת����̨��ҳ
            //�ض����������ȥ��ת��ָ����λ��
            //ת����moodchoose
            request.getRequestDispatcher("/moodChoose.jsp").forward(request,response);
        } catch (Exception e) {

            if (e.getMessage().equals("�û������������")) {
                //���ص�¼��ҳ�����Դ�����Ϣ
                request.setAttribute("error", e.getMessage());
                //ת�����������ڲ�ת��
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

}
