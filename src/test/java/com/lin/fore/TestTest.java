package com.lin.fore;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:34 2020/3/25
 */
public class TestTest {
    public static int a;

    @Test
    public void test(){
        System.out.println(a);
    }

    @Test
    public void test2() throws Exception{
        String a = "1234";
        byte[] b = a.getBytes();
        System.out.println(b.toString());
        System.out.println(new String(b,"UTF-8"));
    }

    @Test
    public void test3() throws Exception{
        String s = "\"RD\",\"\",\"01287520146944\",\"CFI01120186222\",\"891901\",\"20261103\",\"API\",\"540.00\",\"\",\"7062715\",\"300\",\"Instruction accepted\"";
        System.out.println(getstr(s,3));
        System.out.println(getstr2(s,3));
    }



    public static String getstr(String line, int k) throws Exception{
        String tmp = line;
        if(k == 1){
            tmp = tmp.substring(1);
        }else {
            for (int i = 1; i < k; i++) {
                int idx1 = tmp.indexOf("\",\"");
                if (idx1 < 0)
                    System.out.println("格式不正确");
                tmp = tmp.substring(idx1 + 3);
            }
        }
        int idx2 = tmp.indexOf("\"");
        if(idx2 < 0)
            System.out.println("格式不正确");
        tmp = tmp.substring(0, idx2);
        return tmp.trim();
    }


    public static String getstr2(String line, int k) throws Exception {
        String[] lineArr = line.split(",");
        String tar = lineArr[k-1];
        return tar.substring(1,tar.length()-1);
    }
}