package com.company.service;

import com.company.dao.HomePageDao;
import com.company.domain.HomePage;
import com.company.domain.Ran_HomePage;

import java.sql.SQLException;
import java.util.List;

public class HomePageService {
    private HomePageDao homePageDao=new HomePageDao();
    public HomePage getHomePageGood() throws SQLException {
        HomePage homePageGood = homePageDao.getHomePageGood();
        return homePageGood;

    }

    public List<Ran_HomePage> getHomePageRan() throws SQLException {
        List<Ran_HomePage> homePageRan = homePageDao.getHomePageRan();
        return homePageRan;
    }
}
