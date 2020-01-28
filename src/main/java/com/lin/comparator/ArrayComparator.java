package com.lin.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/4/18 10:05
 * @Modified By:
 **/
public class ArrayComparator implements Comparator<Map<String,Object>>{
    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        String timeOne = o1.get("TIME").toString();
        String timeTwo = o2.get("TIME").toString();
        int flag = timeOne.compareTo(timeTwo);
        if(flag > 0){
            return -1;
        }else if(flag <0){
            return 1;
        }else{
            return 0;
        }
    }
}
