package com.lin.java8.defaultmethod4interface;
/**
 * @Desc: java8特性之接口的默认方法
 * @Author: lingx
 * @Date: 23:57 2020/1/15
 */
public interface Formula {
    double caculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }

    static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double caculate(int a) {
                return sqrt(a)+1;
            }
        };

        System.out.println(formula.caculate(10));
        System.out.println(formula.sqrt(10));
    }
}
