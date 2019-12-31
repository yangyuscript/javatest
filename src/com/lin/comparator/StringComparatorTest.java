package com.lin.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/8 23:53
 * @Modified By:
 **/
public class StringComparatorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23");
        list.add("21");
        list.add("26");

        System.out.println(list);
        Collections.sort(list,new StringComparator());
        System.out.println(list);
    }
}
