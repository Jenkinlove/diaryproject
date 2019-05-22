package com.company.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class  Diaries {
    private int d_id;
    private int uid;
    private int moodId;
    private int weather;
    private Date date;
    private String title;
    private String content;
    private String d_background;
    private int remindSign;
    private int delSign;

    @Override
    public String toString() {
        return "Diaries{" +
                "d_id=" + d_id +
                ", uid=" + uid +
                ", moodId=" + moodId +
                ", weather=" + weather +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", d_background='" + d_background + '\'' +
                ", remindSign=" + remindSign +
                ", delSign=" + delSign +
                '}';
    }
}
