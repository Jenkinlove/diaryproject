package com.company.web;

import com.company.domain.HomePage;
import com.company.domain.Ran_HomePage;
import com.company.service.HomePageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    private HomePageService homePageService =new HomePageService();
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取数据库表homepage
            HomePage homePageGood = homePageService.getHomePageGood();
            //System.out.println(homePageGood);
            request.setAttribute("homePageGood",homePageGood);

            //获取数据库表ran_homepage
            List<Ran_HomePage> homePageRan = homePageService.getHomePageRan();
            System.out.println(homePageRan);
            request.setAttribute("homePageRan",homePageRan);

            //转发
            request.getRequestDispatcher("/homePage.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
