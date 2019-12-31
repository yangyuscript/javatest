package com.lin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/26 16:28
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) throws Exception{
        parseStr("200077107649,200586630012,5976789,98440078,201911,210492,1800,0,0,20191226,20200126,20191126,20191226,0,1800,0,0,210492,200586630012,1118000,2080088631131,1,10754,0007602702,30,20191231,20200104");
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
