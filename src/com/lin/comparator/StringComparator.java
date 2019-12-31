package com.lin.comparator;

import java.util.Comparator;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/4/17 17:57
 * @Modified By:
 **/
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        /*if(o1.compareTo(o2)>0){
            return -1;
        }
        return 0;*/

        return o1.compareTo(o2);
    }
}
