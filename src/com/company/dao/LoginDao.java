package com.company.dao;

import com.company.domain.User;
import com.company.utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class LoginDao {

	public User checkUser(String name, String pwd) throws Exception {
		QueryRunner qr = jdbcUtil.getQueryRunner();
		String sql="select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),name,pwd);
		return user;
	}

}
