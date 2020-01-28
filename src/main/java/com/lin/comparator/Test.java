package com.lin.comparator;

import java.util.*;

/**
 * @Author: lingx
 * @Description:
 * @Date: Created in 2019/4/13 15:39
 * @Modified By:
 **/
public class Test {
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

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(five);
        list.add(six);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);


        System.out.println("排序前:");
        for (Map<String,Object> map:list) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }

        List<Map<String,Object>> todayList = new ArrayList<>();
        for (Map<String,Object> map:list) {
            if(map.get("TIME").toString().contains("2019/4/18")){
                todayList.add(map);
            }
        }
        list.removeAll(todayList);

        System.out.println("过滤掉今日账单后:todayList is:");
        for (Map<String,Object> map:todayList) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }
        System.out.println("过滤掉今日账单后:list is:");
        for (Map<String,Object> map:list) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }

        System.out.println("去除今日账单排序后:");
        Collections.sort(list,new MyComparator());
        for (Map<String,Object> map:list) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }

        System.out.println("合并今日账单后:");
        list.addAll(0,todayList);
        for (Map<String,Object> map:list) {
            System.out.println(map.get("COLLECT_ID").toString()+" "+map.get("TIME").toString());
        }
    }
}
