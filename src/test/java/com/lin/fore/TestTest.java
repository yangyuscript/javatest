package com.lin.fore;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.management.ManagementFactory;
import java.util.*;

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
        String pid = null;

        try {
            pid = ManagementFactory.getRuntimeMXBean().getName();
        } catch (Throwable var2) {
            pid = "-1";
        }
        System.out.println(pid);
    }

    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        list.add("xiang");
        list.add("guang");
        list.add("lin");
        list.add("abc");
        Collections.sort(list);
        System.out.println(list);

        List<Map<String,String>> list1 = new ArrayList<>();
        Map<String,String> a = new HashMap<>();
        a.put("name","xiang");
        list1.add(a);
        Map<String,String> b = new HashMap<>();
        b.put("name","guang");
        list1.add(b);
        Map<String,String> c = new HashMap<>();
        c.put("name","lin");
        list1.add(c);
        Map<String,String> d = new HashMap<>();
        d.put("name","abc");
        list1.add(d);

        Collections.sort(list1,(m1,m2) -> {
            return m1.get("name").compareTo(m2.get("name"));
        });

        System.out.println(list1);
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

    @Test
    public void getSys(){
        System.out.println(System.getProperty("zookeeper.serverCnxnFactory"));
    }


    @Test
    public void testStr() throws Exception{
        File file = new File("C:\\Users\\Administrator\\Desktop\\offerinsid.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = bufferedReader.readLine()) != null){
            sb.append(line).append(",");
        }
        System.out.println(sb);
    }
}