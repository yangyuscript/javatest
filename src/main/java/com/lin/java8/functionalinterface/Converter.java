package com.lin.java8.functionalinterface;

/**
 * @Desc: 函数式接口之方法引用
 * @Author: lingx
 * @Date: 0:53 2020/1/16
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);


    public static void main(String[] args) {
        Converter<String,Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);


        //方法与构造函数引用
        Converter<String,Integer> c = Integer::valueOf;
        System.out.println(c.convert("123"));

        String a = "abc";
        Converter<String,Boolean> c2 = a::startsWith;
        System.out.println(c2.convert("a"));
    }
}
