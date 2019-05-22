package com.company.service;

import com.company.dao.LoginDao;
import com.company.domain.User;

public class LoginService {

	public User checkUser(String name, String pwd) throws Exception {
		LoginDao dao=new LoginDao();
		User user = dao.checkUser(name,pwd);
		if(user!=null) {
			return user;
		}else {
			throw new Exception("用户名或密码错误");
		}
		
	}

}
