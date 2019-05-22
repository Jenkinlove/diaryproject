package com.company.web;

import com.company.domain.Diaries;
import com.company.domain.Mood;
import com.company.service.DiariesService;
import com.company.service.MoodService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String weather = request.getParameter("weather");
            HttpSession session = request.getSession();
            Map<String, String[]> parameterMap = request.getParameterMap();
            Diaries diaries = new Diaries();
            BeanUtils.populate(diaries, parameterMap);
            diaries.setWeather(Integer.parseInt(weather));
            //System.out.println(diaries);
            String moodId = (String) session.getAttribute("moodId");
            diaries.setMoodId(Integer.parseInt(moodId));
            int uid = (int) session.getAttribute("uid");
            diaries.setUid(uid);
            Date date = new Date();
            diaries.setDate(date);
            diaries.setRemindSign(0);

            //System.out.println(diaries);

            String d_background = diaries.getD_background();
            //System.out.println(d_background);
            //判断用户是否上传了背景图片
            if (d_background.equals("1")) {
                //为空,根据moodId在数据库中随机选取一张
                int moodId2 = diaries.getMoodId();
                MoodService moodService = new MoodService();
                Mood randGood = moodService.getRandGood(moodId2);
                String background = randGood.getBackground();
                diaries.setD_background(background);
            } else {
                //不为空，把用户上传的图片存到数据库中
                diaries.setD_background(d_background);
            }
            DiariesService diariesService = new DiariesService();
            diariesService.addDiaries(diaries);
            response.sendRedirect("/diarypro/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId="+moodId);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
