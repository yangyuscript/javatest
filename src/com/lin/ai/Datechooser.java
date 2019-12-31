package com.lin.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/20 16:20
 * @Modified By:
 **/
public class Datechooser {
    private static final String YEAR = "year";
    private static final String BEGIN_PARTID = "BEGIN_PARTID";
    private static final String END_PARTID = "END_PARTID";

    public static void main(String[] args) {
        /*System.out.println(getQryDate(201901,201912));
        System.out.println(getQryDate(201811,201912));
        System.out.println(getQryDate(201801,201912));
        System.out.println(getQryDate(201711,201912));
        System.out.println(getQryDate(201701,201812));
        System.out.println(getQryDate(201601,201912));*/


        System.out.println(getQryDate(201801,201910));
        System.out.println(getQryDate(201702,201810));
        System.out.println(getQryDate(201702,201806));
        System.out.println(getQryDate(201702,201811));
        System.out.println(getQryDate(201702,201911));
        System.out.println(getQryDate(201602,201811));
        System.out.println(getQryDate(201602,201711));
        System.out.println(getQryDate(201812,201912));


    }

    public static List<Map<String,Object>> getQryDate(int beginDate, int endDate){
        List<Map<String,Object>> yearNPartiList = new ArrayList<>();
        int beginYear = beginDate/100;
        int beginMM = beginDate%100;
        int endYear = endDate/100;
        int endMM = endDate%100;

        int nowYear = 2019;
        int nowMM = 10;

        int i = endYear - beginYear;
        int year = endYear;
        while(i-->=0){
            Map<String,Object> map = new HashMap<>();
            map.put(Datechooser.YEAR,year);
            if(year == nowYear){
                if(beginYear == year){
                    if(endMM>nowMM){
                        map.put(Datechooser.BEGIN_PARTID,beginMM);
                        map.put(Datechooser.END_PARTID,nowMM);
                    }else{
                        map.put(Datechooser.BEGIN_PARTID,beginMM);
                        map.put(Datechooser.END_PARTID,endMM);
                    }
                }else{
                    map.put(Datechooser.BEGIN_PARTID,1);
                    map.put(Datechooser.END_PARTID,endMM<=nowMM?endMM:nowMM);
                }
            }else if(year == nowYear-1){
                if(endYear == year){
                    if(beginYear == year) {
                        Map<String, Object> temp = new HashMap<>();
                        temp.put(Datechooser.YEAR, nowYear);
                        temp.put(Datechooser.BEGIN_PARTID, nowMM+1);
                        temp.put(Datechooser.END_PARTID, 12);
                        yearNPartiList.add(temp);

                        if (beginMM > nowMM) {
                            map.put(Datechooser.YEAR, nowYear);
                            map.put(Datechooser.BEGIN_PARTID, (nowMM + 1 > 12) ? 12 : nowMM + 1);
                            map.put(Datechooser.END_PARTID, nowMM);
                        } else {
                            if(endMM > nowMM){
                                map.put(Datechooser.YEAR, year);
                                map.put(Datechooser.BEGIN_PARTID, beginMM);
                                map.put(Datechooser.END_PARTID, nowMM);
                            }else{
                                map.put(Datechooser.YEAR, year);
                                map.put(Datechooser.BEGIN_PARTID, beginMM);
                                map.put(Datechooser.END_PARTID, endMM);
                            }
                        }
                    }else{
                        if (endMM > nowMM) {
                            map.put(Datechooser.YEAR, nowYear);
                            map.put(Datechooser.BEGIN_PARTID, (nowMM + 1 > 12) ? 12 : nowMM + 1);
                            map.put(Datechooser.END_PARTID, 12);

                            Map<String,Object> temp = new HashMap<>();
                            temp.put(Datechooser.YEAR, year);
                            temp.put(Datechooser.BEGIN_PARTID, 1);
                            temp.put(Datechooser.END_PARTID, nowMM);
                            yearNPartiList.add(temp);
                        } else {
                            map.put(Datechooser.YEAR, year);
                            map.put(Datechooser.BEGIN_PARTID, 1);
                            map.put(Datechooser.END_PARTID, endMM);
                        }
                    }
                }else if(endYear != year){
                    Map<String, Object> temp = new HashMap<>();
                    temp.put(Datechooser.YEAR, nowYear);
                    temp.put(Datechooser.BEGIN_PARTID, nowMM+1);
                    temp.put(Datechooser.END_PARTID, 12);
                    yearNPartiList.add(temp);

                    if(beginYear == year) {
                        if(beginMM <= nowMM){
                            if(endMM > nowMM){
                                map.put(Datechooser.BEGIN_PARTID,beginMM);
                                map.put(Datechooser.END_PARTID,nowMM);
                            }else{
                                map.put(Datechooser.BEGIN_PARTID,beginMM);
                                map.put(Datechooser.END_PARTID,endMM);
                            }
                        }else{
                            continue;
                        }
                    }else{
                        map.put(Datechooser.BEGIN_PARTID,1);
                        map.put(Datechooser.END_PARTID,nowMM);
                    }
                }else{
                    map.put(Datechooser.BEGIN_PARTID,1);
                    map.put(Datechooser.END_PARTID,12);
                }
            }else{
                if(beginYear == year && endYear ==year){
                    map.put(Datechooser.BEGIN_PARTID,beginMM);
                    map.put(Datechooser.END_PARTID,endMM);
                }else if(beginYear == year && endYear !=year){
                    map.put(Datechooser.BEGIN_PARTID,beginMM);
                    map.put(Datechooser.END_PARTID,12);
                }else{
                    map.put(Datechooser.BEGIN_PARTID,1);
                    map.put(Datechooser.END_PARTID,12);
                }
            }
            yearNPartiList.add(map);
            year--;
        }
        return yearNPartiList;
    }
}
