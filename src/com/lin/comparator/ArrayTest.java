package com.lin.comparator;

import java.util.*;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/4/18 10:10
 * @Modified By:
 **/
public class ArrayTest {
    public static void main(String[] args) {
        Map<String,Object> one = new HashMap<>();
        one.put("COLLECT_ID","999");
        one.put("TIME","2019/4/14");
        Map<String,Object> two = new HashMap<>();
        two.put("COLLECT_ID","222");
        two.put("TIME","2019/4/18");
        Map<String,Object> three = new HashMap<>();
        three.put("COLLECT_ID","1001");
        three.put("TIME","2019/4/15");
        Map<String,Object> four = new HashMap<>();
        four.put("COLLECT_ID","111");
        four.put("TIME","2019/4/18");
        Map<String,Object> five = new HashMap<>();
        five.put("COLLECT_ID","0");
        five.put("TIME","2019/4/10");
        Map<String,Object> six = new HashMap<>();
        six.put("COLLECT_ID","0");
        six.put("TIME","2019/4/11");

        Map<String,Object>[] mapArray = new Map[]{one,two,three,four,five};

        Arrays.sort(mapArray,new ArrayComparator());

        for (Map<String,Object> map:mapArray) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }
    }
}
