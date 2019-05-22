package com.company.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class HomePage {
    private Integer h_id;
    private String h_bg;
    private String h_stmt;//ÿ���Ƽ����
    private String h_article;//ÿ��һ��
    private String h_title;
    private String h_author;

    @Override
    public String toString() {
        return "HomePage{" +
                "h_id=" + h_id +
                ", h_bg='" + h_bg + '\'' +
                ", h_stmt='" + h_stmt + '\'' +
                ", h_article='" + h_article + '\'' +
                '}';
    }
}
