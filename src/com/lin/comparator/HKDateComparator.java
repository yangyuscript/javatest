package com.lin.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/8 23:41
 * @Modified By:
 **/
public class HKDateComparator implements Comparator<Map<String, Object>> {
    public static final int DATE_LEN = 10;
    String key;

    public HKDateComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        String v1 = (String)o1.get(key);
        String v2 = (String)o2.get(key);

        int len1 = v1 == null ? 0 : v1.length();
        int len2 = v2 == null ? 0 : v2.length();


        String date1 = "", time1 = "";
        String date2 = "", time2 = "";
        if (len1 >= DATE_LEN) {
            date1 = v1.substring(0, 10);
            time1 = v1.substring(10);
        }
        if (len2 >= DATE_LEN) {
            date2 = v2.substring(0, 10);
            time2 = v2.substring(10);
        }

        String[] dd1 = date1.split("/");
        String[] dd2 = date2.split("/");
        if (dd1.length != dd2.length) {
            return dd1.length - dd2.length;
        } else {
            for (int i = dd1.length - 1; i >= 0; i--) {
                if (!dd1[i].equals(dd2[i])) {
                    return dd1[i].compareTo(dd2[i]);
                }
            }
            return time1.compareTo(time2);
        }
    }
}
