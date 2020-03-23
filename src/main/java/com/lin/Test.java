package com.lin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/26 16:28
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) throws Exception{
        System.out.println(Integer.numberOfLeadingZeros(16 - 1));
    }


    public static void parseStr(String str) {
        List<String> bc = new ArrayList<String>(100);
        int sIdx = 0, idx = 0;

        while ((idx = str.indexOf(",", sIdx)) >= 0) {
            if (sIdx == idx) {
                bc.add("");
            } else {
                bc.add(str.substring(sIdx, idx));
            }
            sIdx = idx + 1;
        }

        if (sIdx == str.length()) {
            bc.add("");
        } else {
            bc.add(str.substring(sIdx));
        }

        if (bc.size() != 27) {
            System.out.println("有问题");
        }else{
            System.out.println(bc);
            System.out.println(bc.get(24));
            System.out.println(bc.get(25));
            System.out.println(bc.get(26));
        }
    }


    public static List<String> getNumberList (String str){
        List<String> list = new ArrayList<>();
        String s = "";
        for(int i=0; i<=str.length()-1; i++){
            int chr=str.charAt(i);
            System.out.println(chr);
            // 找到 . 和 0123456789
            if(chr == 46 || (chr >= 48 && chr <= 57)) {
                s += str.substring(i, i+1);
            }else {
                if(!"".equals(s)) {
                    list.add(s);
                    s = "";
                }
            }
        }
        return list;
    }

    public static boolean isNumeric(String str){
        for(int i=str.length(); --i>=0;){
            char c=str.charAt(i);
            if (c < 48 || c > 57)
                return false;
        }
        return true;
    }
}
