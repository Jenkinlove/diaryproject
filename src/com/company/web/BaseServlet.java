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
        //接受参数
        String action = request.getParameter("action");
        try {
            //通过反射调用当前对象
            Class<?> classType = this.getClass();
            //获取方法
            Method method = classType.getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
            //去除私有属性
            method.setAccessible(true);
            //判断有没有传入的方法
            if(method!=null) {
                //如果有就调用
                String despath =(String)method.invoke(this, request,response);
                //转发
                if(despath!=null) {
                    request.getRequestDispatcher(despath).forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
