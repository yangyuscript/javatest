package com.lin.map.treemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:52 2020/2/29
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getResult(180L));
    }

    public static String getResult(long uIDataInput){
        long n = uIDataInput;
        StringBuffer sb = new StringBuffer();
        while(n!=1){
            for(int i=2;i<=n;i++){
                if(n%i==0){
                    n/=i;
                    sb.append(i).append(" ");
                    break;
                }
            }
        }
        return sb.toString();
    }
}
