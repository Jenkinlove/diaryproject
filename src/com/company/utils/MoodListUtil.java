package com.company.utils;

import java.util.Map;
import java.util.TreeMap;

public class MoodListUtil {
    public static Map<Integer,String> getMoodMap(){
        Map<Integer,String> moodMap=new TreeMap<>();
        moodMap.put(1, "happy");//¿ªĞÄ
        moodMap.put(2, "mawkishness");//ÉË¸Ğ
        moodMap.put(3, "exciteexcite");//¼¤¶¯
        moodMap.put(4, "appreciate");//¸Ğ¼¤
        moodMap.put(5, "regret");//°Ã»Ú
        moodMap.put(6, "rage");//·ßÅ­
        moodMap.put(7, "joy");//»¶Ï²
        moodMap.put(8, "sad");//ÓÇ³î
        moodMap.put(9, "upset");//·³ÂÒ
        moodMap.put(10,"lost");//Ê§Âä
        moodMap.put(11,"cheer");//¿ìÀÖ
        return moodMap;
    }

    public static Map<String,String> getMoodTransform(){
        Map<String,String> map=new TreeMap<>();
        map.put("happy","¿ªĞÄ");//¿ªĞÄ
        map.put("mawkishness","ÉË¸Ğ");//ÉË¸Ğ
        map.put("exciteexcite","¼¤¶¯");//¼¤¶¯
        map.put("appreciate","¸Ğ¼¤");//¸Ğ¼¤
        map.put("regret","°Ã»Ú");//°Ã»Ú
        map.put("rage","·ßÅ­");//·ßÅ­
        map.put("joy","»¶Ï²");//»¶Ï²
        map.put("sad","ÓÇ³î");//ÓÇ³î
        map.put("upset","·³ÂÒ");//·³ÂÒ
        map.put("lost","Ê§Âä");//Ê§Âä
        map.put("cheer","¿ìÀÖ");
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
