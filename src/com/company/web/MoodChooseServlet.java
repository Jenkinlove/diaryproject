package com.company.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/MoodChooseServlet")
public class MoodChooseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //点击气球所选择的心情id
        String moodId = request.getParameter("moodId");
        System.out.println("MoodChooseServlet"+moodId);
        HttpSession session = request.getSession();
        session.setAttribute("moodId",moodId);

        response.sendRedirect("/diarypro/RemindServlet");

        //重定向到PersonalSpaceServlet,并传送moodId
        /*response.sendRedirect("/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId="+moodId);*/

    }
}
