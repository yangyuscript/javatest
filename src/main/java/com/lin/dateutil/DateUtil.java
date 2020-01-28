package com.lin.dateutil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Long get2Timedurity(String timeOne,String timeTwo) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date t1 = sdf.parse(timeOne);
        Date t2 = sdf.parse(timeTwo);
        Long result = 0L;
        if(t1.getTime() - t2.getTime()>0){
            result = (t1.getTime()-t2.getTime())/1000;
        }else{
            result = (t2.getTime()-t1.getTime())/1000;
        }
        //235
        return result;
    }

    public static void getDateAnd15MinAfter() throws Exception{
        Date endDate = new Date();
        long endDate_long=endDate.getTime();
        long startDate_long=endDate_long-15*60*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String endDate_str=sdf.format(new Date(endDate_long));
        String startDate_str=sdf.format(new Date(startDate_long));
        System.out.println(startDate_str+"--"+endDate_str);
    }

    public static void compareHHMM() throws  Exception{
        System.out.println("08:00".compareTo("07:00"));
    }

    public static void main(String[] args) throws Exception{
        //System.out.println(DateUtil.get2Timedurity("2018/12/05 17:18:43","2018/12/05 17:25:47"));
        //getDateAnd15MinAfter();
        //compareHHMM();
        //System.out.println("2018/12/18 15:28:09".compareTo("2018/06/18 15:28:09"));

        System.out.println("2018-06-18 15:28:09".substring(0,10));
    }
}
