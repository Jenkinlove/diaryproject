package com.company.dao;

import com.company.domain.Mood;
import com.company.domain.RemindMood;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class MoodDao {
    private QueryRunner qr = jdbcUtil.getQueryRunner();

    public RemindMood getRemindMood() throws SQLException {
        String sql="select * from remindMood order by rand() limit 1";
        RemindMood query = qr.query(sql, new BeanHandler<RemindMood>(RemindMood.class));
        return query;
    }

    public Mood getRandGood(int moodId) throws SQLException {
        String sql="select * from mood where moodId=? order by rand() limit 1";
        Mood mood = qr.query(sql, new BeanHandler<Mood>(Mood.class), moodId);
        return mood;
    }

}
