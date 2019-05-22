package com.company.dao;

import com.company.domain.HomePage;
import com.company.domain.Ran_HomePage;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class HomePageDao {
    private QueryRunner qr = jdbcUtil.getQueryRunner();

    public HomePage getHomePageGood() throws SQLException {
        String sql="select * from homepage order by rand() limit 1";
        HomePage query = qr.query(sql, new BeanHandler<HomePage>(HomePage.class));
        return query;
    }

    public List<Ran_HomePage> getHomePageRan() throws SQLException {
        String sql="select * from ran_homepage order by rand() limit 6";
        List<Ran_HomePage> query = qr.query(sql, new BeanListHandler<Ran_HomePage>(Ran_HomePage.class));
        return query;
    }
}
