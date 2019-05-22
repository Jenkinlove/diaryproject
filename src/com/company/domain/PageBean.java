package com.company.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PageBean {
    //��ǰ����һҳ
    private int currentPage;
    //������ҳ
    private int totalPage;
    //�������ռ�
    private int totalCount;
    //��ǰҳ�ռ�
    private List<Diaries> diariesList=new ArrayList<>();
}
