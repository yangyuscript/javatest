package com.lin.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/23 20:01
 * @Modified By:
 **/
public class StringFormatTest {

    @Test
    public void test2(){
        String a = "1";
        if(a.length()>0){
            System.out.println(a.charAt(0));
            System.out.println(a.charAt(a.length()-1));
        }
    }

    public static void main(String[] args) {
        String s = ",511-689374-002,10/01/2020,HC12011077925215,HC12011077925215,/ORDP/ECKART ASIA LIMITED /BREF/HC12011077925215/OBK/004 /PXY/511689374002 /PURP/EXPE /EREF/57275NJ00URN /REMI/CUSTOMER NO.:1.7 179978 STL INV.85943771219 PAYMENT N O.200717997885,CR ADV,HKD,\"8,530.60\",\"9,190,075.00\",\"16,031,849.21\"";
        List<String> list = getLineList(s);
        System.out.println("lineList is ");
        for (String str :
                list) {
            System.out.println(str);
        }

        String s5 = list.get(5);
        List<String> list2 = getNumberList(s5);
        System.out.println("numberList is ");
        for (String str:
                list2) {
            System.out.println(str);
        }
    }

    private static List<String> getLineList (String ss){
        //String ss = "123,456,789";

        List<String> list = new ArrayList<>();

        int m = ss.indexOf("\"");
        if(m >= 0){
            String str1[] = ss.substring(0,m).split(",");
            for(String s : str1){
                list.add(s);
            }
            ss = ss.substring(m);
            while(ss.length() >= 0){
                if(list.size() >= 9)
                    break;

                int idx3 = ss.indexOf("\"");
                if(idx3 >= 0){
                    int idx4 = ss.substring(idx3 + 1).indexOf("\"");
                    if(idx4 < 0){
                        return null;
                    }
                    idx4 = idx4 + idx3 + 1;
                    String s1 = ss.substring(idx3 + 1, idx4);
                    list.add(s1);
                    if(idx4 == ss.length() -1) {
                        break;
                    }else {
                        int idx5 = ss.substring(idx4 + 1).indexOf("\"");
                        if(idx5 >= 0){
                            if(idx5 > 1){
                                String str2[] = ss.substring(idx4 + 2, idx4+idx5).split(",");
                                for(String s : str2){
                                    list.add(s);
                                }
                            }
                            idx5 = idx5 + idx4 + 1;
                            ss = ss.substring(idx5);
                        }else {
                            String str3[] = ss.substring(idx4 + 2).split(",");
                            for(String s : str3){
                                list.add(s);
                            }
                            break;
                        }
                    }
                }else {
                    return null;
                }
            }

        }else {
            String str4[] = ss.split(",");
            for(String s : str4){
                list.add(s);
            }
        }

        return list;
    }

    private static List<String> getNumberList (String str){
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i=0; i<=str.length()-1; i++){
            int chr=str.charAt(i);
            // 找到 . 和 0123456789
            if(chr == 46 || (chr >= 48 && chr <= 57)) {
                s.append(str.substring(i, i+1));
            }else {
                if(s != null && s.length() != 0) {
                    list.add(s.toString());
                    s.setLength(0);
                }
            }
        }
        if(s != null && s.length() != 0)
            list.add(s.toString());

        return list;
    }
}
