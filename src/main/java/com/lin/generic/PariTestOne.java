package com.lin.generic;

/**
 * @Author: lingx
 * @Description:
 * @Date: Created in 2019/3/12 9:27
 * @Modified By:
 **/
public class PariTestOne {
    public static void main(String[] args) {
        /*Pari pari = ArrayAlg.minmax(new String[]{"a","c","z"});
        System.out.println(pari.getFirst()+" "+pari.getSecond());*/
        String middle = ArrayAlg.getMiddle("j","k");
        System.out.println(middle);
    }
}

class ArrayAlg{
    public static Pari<String> minmax(String[] a){
        if(a==null||a.length==0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (String i: a) {
            if(min.compareTo(i)>0){
                min=i;
            }
            if(max.compareTo(i)<0){
                max=i;
            }
        }
        Pari<String> pari = new Pari<>();
        pari.setFirst(min);
        pari.setSecond(max);
        return pari;
    }

    public static <T> T getMiddle(T ...a){
        return a[a.length/2];
    }
}
