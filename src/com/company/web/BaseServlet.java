package com.company.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ܲ���
        String action = request.getParameter("action");
        try {
            //ͨ��������õ�ǰ����
            Class<?> classType = this.getClass();
            //��ȡ����
            Method method = classType.getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
            //ȥ��˽������
            method.setAccessible(true);
            //�ж���û�д���ķ���
            if(method!=null) {
                //����о͵���
                String despath =(String)method.invoke(this, request,response);
                //ת��
                if(despath!=null) {
                    request.getRequestDispatcher(despath).forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
