package com.company.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Ran_HomePage {
    private int ran_id;
    private String ran_img;
    private String ran_ad;
    private String ran_ad_img;

    @Override
    public String toString() {
        return "Ran_HomePage{" +
                "ran_id=" + ran_id +
                ", ran_img='" + ran_img + '\'' +
                ", ran_ad='" + ran_ad + '\'' +
                ", ran_ad_img='" + ran_ad_img + '\'' +
                '}';
    }
}
