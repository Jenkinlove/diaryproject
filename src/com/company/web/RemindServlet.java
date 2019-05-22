package com.company.web;

import com.company.domain.Diaries;
import com.company.domain.Mood;
import com.company.domain.RemindMood;
import com.company.service.DiariesService;
import com.company.service.MoodService;
import com.company.utils.MoodListUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/RemindServlet")
public class RemindServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("uid");
        String moodId =(String)session.getAttribute("moodId");
        DiariesService diariesService = new DiariesService();
        MoodService moodService = new MoodService();
        try {
            //���͹��ܣ�����������վ�д�ռǵ���ʽ����һ����Ϣ
            // �������һ��ɾ���ռ�����������
            Date date = new Date();
            Calendar c = Calendar.getInstance();

            //�ж��Ƿ���������,�����վ�����
            if (c.get(Calendar.DAY_OF_WEEK) == 1) {

                //�������ͱ�ʶ���ж����ݿ����Ƿ�������ͱ�ʶ��������ھ�ֱ���ض���
                //��������ڣ�����������

                if(diariesService.hasRemindSign(uid)){
                    response.sendRedirect("/diarypro/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId="+moodId);
                }else{
                    Diaries diaries = new Diaries();
                    diaries.setRemindSign(1);

                    diaries.setDate(date);
                    diaries.setUid(uid);
                    diaries.setMoodId(Integer.parseInt(moodId));
                    diaries.setWeather(1);
                    diaries.setTitle("����");
                    Mood randGood = moodService.getRandGood(Integer.parseInt(moodId));
                    String background = randGood.getBackground();
                    diaries.setD_background(background);
                    //��ȡ�û�һ��д���ռ�
                    c.setTime(new Date());
                    c.add(Calendar.DAY_OF_MONTH, - 7);
                    Date d = c.getTime();
                    //System.out.println(day);

                    List<Diaries> weekDiaries = diariesService.getWeekDiaries(d,uid);
                    //System.out.println(weekDiaries);
                    //һ�ܹ�д�˶���ƪ�ռ�
                    int diariesCount = weekDiaries.size();
                    //�ж��û�ÿƪ�ռǵ�����
                    Map<Integer, String> moodMap = MoodListUtil.getMoodMap();
                    Map<String, String> moodTransform = MoodListUtil.getMoodTransform();
                    Map<String, Integer> moodCount = MoodListUtil.getMoodCount();
                    for (Diaries weekDiary : weekDiaries) {
                        Set<Map.Entry<Integer, String>> entries = moodMap.entrySet();
                        for (Map.Entry<Integer, String> entry : entries) {
                            if(entry.getKey()==weekDiary.getMoodId()){
                                Integer count = moodCount.get(entry.getValue());
                                count=count+1;
                                moodCount.put(entry.getValue(),count);
                            }
                        }
                    }
                    int goodMood=0;//�õ�����
                    int badMood=0;//��������
                    StringBuffer buffer=new StringBuffer();
                    Set<Map.Entry<String, Integer>> entries = moodCount.entrySet();
                    buffer.append("���ˣ���������ڵ������ܽ�����: </br>");
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        if(key=="happy"||key=="exciteexcite"||key=="appreciate"||key=="joy"||key=="cheer"){
                            goodMood=goodMood+entry.getValue();
                        }else{
                            badMood=badMood+entry.getValue();
                        }
                        if (entry.getValue()==0){
                            continue;
                        }
                        String moodName = moodTransform.get(entry.getKey());
                        buffer.append("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+moodName+"�Ĵ�����"+entry.getValue()+"�� </br>  ");
                    }
                    if((goodMood+badMood)==0){
                        buffer.append("�װ������ˣ�������û������κ��ռ�Ŷ");
                    }else if(goodMood>badMood){
                        RemindMood remindMood = moodService.getRemindMood();
                        String remind_good = remindMood.getRemind_good();
                        buffer.append(remind_good);
                    }else if(goodMood<badMood){
                        RemindMood remindMood = moodService.getRemindMood();
                        String remind_bad = remindMood.getRemind_bad();
                        buffer.append(remind_bad);
                    }
                    diaries.setContent(buffer.toString());
                    diariesService.addDiaries(diaries);
                    response.sendRedirect("/diarypro/PersonalSpaceServlet?action=getPageData" +
                            "&currentPage=1&moodId="+moodId);
                }

            }
            //�ж��Ƿ�����һ���������һ��ɾ���ռ�����������
            if(c.get(Calendar.DAY_OF_WEEK)==2||c.get(Calendar.DAY_OF_WEEK)==3||c.get(Calendar.DAY_OF_WEEK)==4||c.get(Calendar.DAY_OF_WEEK)==5||c.get(Calendar.DAY_OF_WEEK)==6||c.get(Calendar.DAY_OF_WEEK)==7){
                diariesService.delRemindSign();
                response.sendRedirect("/diarypro/PersonalSpaceServlet?action=getPageData&currentPage=1&moodId="+moodId);
            }
            } catch(Exception e){
                e.printStackTrace();
            }

    }
}
