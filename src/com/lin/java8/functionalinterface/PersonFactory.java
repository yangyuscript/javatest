package com.lin.java8.functionalinterface;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 1:19 2020/1/16
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String firstName,String lastName);
}
