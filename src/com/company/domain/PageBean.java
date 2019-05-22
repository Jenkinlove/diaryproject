package com.company.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PageBean {
    //当前是哪一页
    private int currentPage;
    //共多少页
    private int totalPage;
    //共多少日记
    private int totalCount;
    //当前页日记
    private List<Diaries> diariesList=new ArrayList<>();
}
