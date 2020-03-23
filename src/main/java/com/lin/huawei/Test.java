package com.lin.huawei;

import java.util.*;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 17:11 2020/2/10
 */
public class Test {
    public static void main(String[] args){
        System.out.println(1+2*4);
        System.out.println(Integer.valueOf(String.valueOf('1')));

        System.out.println(Integer.valueOf('1'));
        //get2();
    }

    public static void get(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            for(int i = 0;i<num;i++){
                int temp = sc.nextInt();
                if(map.containsKey(String.valueOf(temp))){

                }else{
                    list.add(temp);
                    map.put(String.valueOf(temp),"1");
                }
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 > o2){
                        return 1;
                    }else if(o1 == o2){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            });

            for(int i = 0;i<list.size();i++){
                System.out.println(list.get(i));
            }


        }
    }


    public static void get2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.next();
            int len = str.length();
            int flag = 0;
            boolean flagTwo = true;
            while(flag < len && flagTwo){
                if(len-flag>8){
                    System.out.println(str.substring(flag,8+flag));
                    flag = flag + 8;
                }else{
                    flagTwo = false;
                    String str1 = str.substring(flag);
                    StringBuffer sb = new StringBuffer();
                    for(int i =0;i<8-str1.length();i++){
                        sb.append("0");
                    }
                    System.out.println(str1+sb.toString());
                }
            }
        }
    }
}
