package com.lin.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/18 19:46
 * @Modified By:
 **/
public class MainTest {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if("".equals(s.trim()) || len ==0){
            return s;
        }
        char[] array = s.toCharArray();
        int ri = 0;
        int rj = 0;
        int max1 = 0;
        int max1i = 0;

        for(int i=0;i<len;i++){
            for(int j=len-1;j>0;j--){
                if(i!=j && max1<j-i && array[i]==array[j]){
                    if(check(i,j,array)){
                        ri = i;
                        rj = j;
                        break;
                    }
                }
            }
            if(rj-ri>max1){
                max1 = rj-ri;
                max1i = ri;
            }
        }

        return s.substring(max1i,max1i+max1+1);
    }

    public static boolean check(int i,int j,char[] s){
        if(i==j || (i+1) ==j || (i+2)==j){
            return true;
        }
        if(i<j){
            if(s[i+1]==s[j-1]){
                return check(i+1,j-1,s);
            }else{
                return false;
            }
        }
        return false;
    }
}
