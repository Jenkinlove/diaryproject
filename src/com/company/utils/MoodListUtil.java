package com.company.utils;

import java.util.Map;
import java.util.TreeMap;

public class MoodListUtil {
    public static Map<Integer,String> getMoodMap(){
        Map<Integer,String> moodMap=new TreeMap<>();
        moodMap.put(1, "happy");//����
        moodMap.put(2, "mawkishness");//�˸�
        moodMap.put(3, "exciteexcite");//����
        moodMap.put(4, "appreciate");//�м�
        moodMap.put(5, "regret");//�û�
        moodMap.put(6, "rage");//��ŭ
        moodMap.put(7, "joy");//��ϲ
        moodMap.put(8, "sad");//�ǳ�
        moodMap.put(9, "upset");//����
        moodMap.put(10,"lost");//ʧ��
        moodMap.put(11,"cheer");//����
        return moodMap;
    }

    public static Map<String,String> getMoodTransform(){
        Map<String,String> map=new TreeMap<>();
        map.put("happy","����");//����
        map.put("mawkishness","�˸�");//�˸�
        map.put("exciteexcite","����");//����
        map.put("appreciate","�м�");//�м�
        map.put("regret","�û�");//�û�
        map.put("rage","��ŭ");//��ŭ
        map.put("joy","��ϲ");//��ϲ
        map.put("sad","�ǳ�");//�ǳ�
        map.put("upset","����");//����
        map.put("lost","ʧ��");//ʧ��
        map.put("cheer","����");
        return map;
    }

    public static Map<String,Integer> getMoodCount(){
        Map<String,Integer> map=new TreeMap<>();
        map.put("happy",0);
        map.put("mawkishness",0);
        map.put("exciteexcite",0);
        map.put("appreciate",0);
        map.put("regret",0);
        map.put("rage",0);
        map.put("joy",0);
        map.put("sad",0);
        map.put("upset",0);
        map.put("lost",0);
        map.put("cheer",0);
        return map;
    }
}
