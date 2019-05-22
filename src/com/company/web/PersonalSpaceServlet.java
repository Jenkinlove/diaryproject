package com.company.web;

import com.company.domain.Mood;
import com.company.domain.PageBean;
import com.company.domain.User;
import com.company.service.DiariesService;
import com.company.service.MoodService;
import com.company.service.UserService;
import com.company.utils.MoodListUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/PersonalSpaceServlet")
public class PersonalSpaceServlet extends BaseServlet {
    //获取数据
    protected String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moodId = request.getParameter("moodId");
        //根据moodId取出对应的心情
        Map<Integer, String> moodMap = MoodListUtil.getMoodMap();
        String moodType = moodMap.get(Integer.parseInt(moodId));
        request.setAttribute("moodType",moodType);

        try {
            //从数据库中取出mood根据moodId的相关内容
            MoodService moodService=new MoodService();
            Mood mood = moodService.getRandGood(Integer.parseInt(moodId));
            //System.out.println(mood);
            //把取出的数据存放到request域中
            request.setAttribute("mood",mood);

            HttpSession session = request.getSession();
            int uid = (int) session.getAttribute("uid");
            //1.获取当前页码
            String currentPage = request.getParameter("currentPage");
            //2.把页码给业务层，根据页码给我一个pageBean
            DiariesService diariesService=new DiariesService();
            PageBean pageBean=diariesService.getPageBean(Integer.parseInt(currentPage),
                    uid);
            //3.把pageBean写到域中
            request.setAttribute("pageBean",pageBean);

            //根据uid取出相应用户名
            UserService userService=new UserService();
            User user=userService.getUserdata(uid);
            String username = user.getUsername();
            session.setAttribute("username",username);

            /*//从数据库中取出giaries个人日记信息
            List<Diaries> allGiaries = diariesService.getAllGiaries(Integer.parseInt(moodId));
            //把取出的数据存放到request域中
            request.setAttribute("allGiaries",allGiaries);
            System.out.println(allGiaries);*/

            //4.转发到personalspace.jsp
            return "/personalspace.jsp";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //点击删除按钮，删除此篇日记
    protected String deletedata(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String d_id = request.getParameter("d_id");
            DiariesService diariesService=new DiariesService();
            diariesService.delDiaries(d_id);
            HttpSession session = request.getSession();
            String moodId =(String) session.getAttribute("moodId");
            //System.out.println(moodId);
            return "/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId="+moodId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*//更新日记
    protected String updateData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Map<String, String[]> map = request.getParameterMap();
            Diaries diaries=new Diaries();
            BeanUtils.populate(diaries,map);

            DiariesService diariesService =new DiariesService();
            diariesService.updateDiaries(diaries);

            return "/personalspace.jsp";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }*/


}
