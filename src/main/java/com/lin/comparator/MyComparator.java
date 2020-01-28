package com.lin.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * @Author: lingx
 * @Description:
 * @Date: Created in 2019/4/13 15:31
 * @Modified By:
 **/
public class MyComparator implements Comparator<Map<String,Object>> {
    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        Long collectIdOne = Long.valueOf(o1.get("COLLECT_ID").toString());
        Long collectIdTwo = Long.valueOf(o2.get("COLLECT_ID").toString());
        if(collectIdOne>collectIdTwo){
            return -1;
        }else if(collectIdOne<collectIdTwo){
            return 1;
        }else{
            return 0;
        }
    }
}
