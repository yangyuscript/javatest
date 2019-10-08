package com.lin.test;


import java.util.Calendar;

public class testone {
    private static int i=9;
    public static void main(String[] args) {
        /*String[] s={"1","2"};
        testone.main(s);*/

        /*String a = "1$2$3$5";
        String[] arraya = a.split("\\$");
        for (String s:arraya) {
            System.out.println(s);
        }*/

        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.get(Calendar.YEAR));
    }
}
