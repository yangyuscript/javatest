package com.lin.java8.localdatetime;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:23 2020/1/16
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        //Date转Timestamp
        Timestamp timestamp = new Timestamp(new Date().getTime());

        //Timestamp转Date
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp1.getTime());
    }
}
