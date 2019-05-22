package com.company.service;

import com.company.dao.MoodDao;
import com.company.domain.Mood;
import com.company.domain.RemindMood;

import java.sql.SQLException;

public class MoodService {
    private MoodDao moodDao=new MoodDao();
    public Mood getRandGood(int moodId) throws SQLException {
        Mood mood = moodDao.getRandGood(moodId);
        return mood;
    }

    public RemindMood getRemindMood() throws SQLException {
        RemindMood remindMood = moodDao.getRemindMood();
        return remindMood;
    }
}
