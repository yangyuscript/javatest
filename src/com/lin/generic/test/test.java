package com.lin.generic.test;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/12 10:03
 * @Modified By:
 **/
public class test {
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{2,3,4,5};
        printArray(arrays);
        String[] strArrays = new String[]{"a","b","c"};
        printArray(strArrays);
        printT("1");
        printT(1);
    }

    public static <E> void printArray(E[] inputArray){
        for (E e:inputArray) {
            System.out.println(e);
        }
    }

    public static <T> void printT(T t){
        System.out.println(t);
    }
}
