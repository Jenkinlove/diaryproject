package com.company.dao;

import com.company.domain.User;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User getUser(int uid) throws SQLException {
        QueryRunner qr = jdbcUtil.getQueryRunner();
        String sql="select * from user where uid=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), uid);
        return user;
    }
}
