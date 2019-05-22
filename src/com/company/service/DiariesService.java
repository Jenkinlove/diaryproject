package com.company.service;

import com.company.dao.DiariesDao;
import com.company.domain.Diaries;
import com.company.domain.PageBean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DiariesService {
    private DiariesDao diariesDao=new DiariesDao();
    //取出所有日记（不分页）
    public List<Diaries> getAllGiaries(int uid) throws SQLException {
        List<Diaries> allDiaries = diariesDao.getAllDiaries(uid);
        return allDiaries;
    }
    //取出分页日记
    public PageBean getPageBean(int currentPage,int uid) throws SQLException {
        PageBean pageBean=new PageBean();
        //设置当前页
        pageBean.setCurrentPage(currentPage);
        //获取有多少篇日记
        //从数据库中查询
        Long count = diariesDao.getCount(uid);
        pageBean.setTotalCount(count.intValue());

        //一页展示多少篇日记
        int pageCount=6;
        //总页数
        int totalPage=(int)(Math.ceil(1.0*pageBean.getTotalCount()/pageCount));
        pageBean.setTotalPage(totalPage);

        //当前页查询的角标
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

    //计算一周写日记总数
    public List<Diaries> getWeekDiaries(Date date,int uid) throws SQLException {
        List<Diaries> weekDiaries = diariesDao.getWeekDiaries(date,uid);
        return weekDiaries;
    }


    public void delRemindSign() throws SQLException {
        diariesDao.delRemindSign();
    }

    //判读是否存在推送标识，存在返回true，不存在返回false
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
