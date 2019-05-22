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
        //�ж��û��������֤���Ƿ���ȷ�������ش�����Ϣ
        try {
            Map<String, String[]> map = request.getParameterMap();
            System.out.println(request.getParameter("username"));
            User user = new User();
            BeanUtils.populate(user, map);
            request.setAttribute("user", user);

            String code = request.getParameter("code");
            String checkCode = (String) request.getSession().getAttribute("checkCode");
            request.setAttribute("error_reg", "���������֤�����");
            if (!code.equals(checkCode)) {
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            //System.out.println(user);
            //����service����
            RegisterService registerService = new RegisterService();
            registerService.createUser(user);
            //ת����¼����
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
