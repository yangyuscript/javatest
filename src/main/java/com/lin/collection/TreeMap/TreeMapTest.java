package com.lin.collection.TreeMap;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/18 19:54
 * @Modified By:
 **/
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("1","treeMap");
        System.out.println(treeMap.get("1"));

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","hashMap");
        System.out.println(hashMap.get("1"));
    }
}
