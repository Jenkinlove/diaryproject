package com.company.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Mood {
    private int id;
    private int moodId;
    private String image;
    private String moodSentence;
    private String audio;
    private String background;

    @Override
    public String toString() {
        return "Mood{" +
                "id=" + id +
                ", moodId=" + moodId +
                ", image='" + image + '\'' +
                ", moodSentence='" + moodSentence + '\'' +
                ", audio='" + audio + '\'' +
                ", background='" + background + '\'' +
                '}';
    }
}
