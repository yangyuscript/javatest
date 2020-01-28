package com.lin.DateFormatTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/2 9:29
 * @Modified By:
 **/
public class DateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currDate = sdf.format(new Date());
        System.out.println(currDate);
        String effDate = "2019-05-02 09:34:12";
        String expDate = "2019-05-02 11:10:21";

        System.out.println(currDate.compareTo(effDate));
        System.out.println(currDate.compareTo(expDate));
        System.out.println((currDate.compareTo(effDate)>0&&currDate.compareTo(expDate)<0));
    }
}
