package com.company.dao;

import com.company.domain.Diaries;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DiariesDao {
    private QueryRunner qr = jdbcUtil.getQueryRunner();
    public List<Diaries> getAllDiaries(int uid) throws SQLException {
        String sql="select * from diaries where uid=?";
        List<Diaries> allGiaries = qr.query(sql, new BeanListHandler<Diaries>(Diaries.class), uid);
        return allGiaries;
    }

    //获取日记总数
    public Long getCount(int uid) throws SQLException {
        String sql="select count(*) from diaries where uid=?";
        Long count = (Long) qr.query(sql, new ScalarHandler(),uid);
        return count;

    }

    public List<Diaries> getPageData(int index, int pageCount ,int uid) throws SQLException {
        String sql="select * from diaries where uid=? order by date DESC limit ?,?";
        List<Diaries> pageDiaries = qr.query(sql, new BeanListHandler<Diaries>(Diaries.class),
                uid,index, pageCount);
        return pageDiaries;
    }

    public void addDiaries(Diaries diaries) throws SQLException {
        String sql="insert into diaries(uid,moodId,weather,date,title,content,d_background," +
                "remindSign) " +
                "values(?,?,?,?,?,?,?,?)";
        qr.update(sql,diaries.getUid(),diaries.getMoodId(),diaries.getWeather(),diaries.getDate(),
                diaries.getTitle(),diaries.getContent(),diaries.getD_background(),diaries.getRemindSign());
    }

    public void delDiaries(int d_id) throws SQLException {
        String sql="delete from diaries where d_id=?";
        qr.update(sql,d_id);
    }

    public void updateDiaries(Diaries diaries) throws SQLException {
        String sql="update diaries set moodId=?,title=?,content=?,d_background=? where d_id=?";
        qr.update(sql,diaries.getMoodId(),diaries.getTitle(),diaries.getContent(),
                diaries.getD_background(),diaries.getD_id());
    }

    public List<Diaries> getWeekDiaries(Date date,int uid) throws SQLException {
        String sql="select * from diaries where date>? and uid=?";
        List<Diaries> query = qr.query(sql, new BeanListHandler<Diaries>(Diaries.class),date,uid);
        return query;
    }

    public void delRemindSign() throws SQLException {
        String sql="delete from diaries where remindSign=1";
        qr.update(sql);
    }


}
