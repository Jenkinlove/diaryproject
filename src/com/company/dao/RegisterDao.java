package com.company.dao;

import com.company.domain.User;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class RegisterDao {
    public void insertUser(User user) throws SQLException {
        QueryRunner qr = jdbcUtil.getQueryRunner();
        String sql="insert into user(username,password,email) values(?,?,?)";
        qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
