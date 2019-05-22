package com.company.service;


import com.company.dao.UserDao;
import com.company.domain.User;

import java.sql.SQLException;

public class UserService {
    public User getUserdata(int uid) throws SQLException {
        UserDao userDao=new UserDao();
        User user=userDao.getUser(uid);
        return user;
    }
}
