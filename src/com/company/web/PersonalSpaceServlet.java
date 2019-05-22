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
    //��ȡ����
    protected String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moodId = request.getParameter("moodId");
        //����moodIdȡ����Ӧ������
        Map<Integer, String> moodMap = MoodListUtil.getMoodMap();
        String moodType = moodMap.get(Integer.parseInt(moodId));
        request.setAttribute("moodType",moodType);

        try {
            //�����ݿ���ȡ��mood����moodId���������
            MoodService moodService=new MoodService();
            Mood mood = moodService.getRandGood(Integer.parseInt(moodId));
            //System.out.println(mood);
            //��ȡ�������ݴ�ŵ�request����
            request.setAttribute("mood",mood);

            HttpSession session = request.getSession();
            int uid = (int) session.getAttribute("uid");
            //1.��ȡ��ǰҳ��
            String currentPage = request.getParameter("currentPage");
            //2.��ҳ���ҵ��㣬����ҳ�����һ��pageBean
            DiariesService diariesService=new DiariesService();
            PageBean pageBean=diariesService.getPageBean(Integer.parseInt(currentPage),
                    uid);
            //3.��pageBeanд������
            request.setAttribute("pageBean",pageBean);

            //����uidȡ����Ӧ�û���
            UserService userService=new UserService();
            User user=userService.getUserdata(uid);
            String username = user.getUsername();
            session.setAttribute("username",username);

            /*//�����ݿ���ȡ��giaries�����ռ���Ϣ
            List<Diaries> allGiaries = diariesService.getAllGiaries(Integer.parseInt(moodId));
            //��ȡ�������ݴ�ŵ�request����
            request.setAttribute("allGiaries",allGiaries);
            System.out.println(allGiaries);*/

            //4.ת����personalspace.jsp
            return "/personalspace.jsp";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //���ɾ����ť��ɾ����ƪ�ռ�
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

    /*//�����ռ�
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
