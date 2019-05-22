package com.company.service;

import com.company.dao.RegisterDao;
import com.company.domain.User;

import java.sql.SQLException;

public class RegisterService {
    public void createUser(User user) throws SQLException {
        RegisterDao registerDao=new RegisterDao();
        registerDao.insertUser(user);
    }
}
