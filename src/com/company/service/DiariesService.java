package com.company.service;

import com.company.dao.DiariesDao;
import com.company.domain.Diaries;
import com.company.domain.PageBean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DiariesService {
    private DiariesDao diariesDao=new DiariesDao();
    //ȡ�������ռǣ�����ҳ��
    public List<Diaries> getAllGiaries(int uid) throws SQLException {
        List<Diaries> allDiaries = diariesDao.getAllDiaries(uid);
        return allDiaries;
    }
    //ȡ����ҳ�ռ�
    public PageBean getPageBean(int currentPage,int uid) throws SQLException {
        PageBean pageBean=new PageBean();
        //���õ�ǰҳ
        pageBean.setCurrentPage(currentPage);
        //��ȡ�ж���ƪ�ռ�
        //�����ݿ��в�ѯ
        Long count = diariesDao.getCount(uid);
        pageBean.setTotalCount(count.intValue());

        //һҳչʾ����ƪ�ռ�
        int pageCount=6;
        //��ҳ��
        int totalPage=(int)(Math.ceil(1.0*pageBean.getTotalCount()/pageCount));
        pageBean.setTotalPage(totalPage);

        //��ǰҳ��ѯ�ĽǱ�
        int index=(pageBean.getCurrentPage()-1)*pageCount;
        List<Diaries> list =diariesDao.getPageData(index,pageCount,uid);
        pageBean.setDiariesList(list);
        return pageBean;
    }

    public void addDiaries(Diaries diaries) throws SQLException {
        diariesDao.addDiaries(diaries);
    }

    public void delDiaries(String d_id) throws SQLException {
        diariesDao.delDiaries(Integer.parseInt(d_id));
    }

    public void updateDiaries(Diaries diaries) throws SQLException {
        diariesDao.updateDiaries(diaries);
    }

    //����һ��д�ռ�����
    public List<Diaries> getWeekDiaries(Date date,int uid) throws SQLException {
        List<Diaries> weekDiaries = diariesDao.getWeekDiaries(date,uid);
        return weekDiaries;
    }


    public void delRemindSign() throws SQLException {
        diariesDao.delRemindSign();
    }

    //�ж��Ƿ�������ͱ�ʶ�����ڷ���true�������ڷ���false
    public boolean hasRemindSign(int uid) throws SQLException {
        List<Diaries> allDiaries = diariesDao.getAllDiaries(uid);
        for (Diaries allDiary : allDiaries) {
            if(allDiary.getRemindSign()==1){
                return true;
            }
        }
        return false;
    }
}
