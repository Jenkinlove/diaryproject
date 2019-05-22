package com.company.web;

import com.company.domain.User;
import com.company.service.RegisterService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //判断用户输入的验证码是否正确，并返回错误信息
        try {
            Map<String, String[]> map = request.getParameterMap();
            System.out.println(request.getParameter("username"));
            User user = new User();
            BeanUtils.populate(user, map);
            request.setAttribute("user", user);

            String code = request.getParameter("code");
            String checkCode = (String) request.getSession().getAttribute("checkCode");
            request.setAttribute("error_reg", "您输入的验证码错误");
            if (!code.equals(checkCode)) {
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            //System.out.println(user);
            //调用service方法
            RegisterService registerService = new RegisterService();
            registerService.createUser(user);
            //转发登录界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
