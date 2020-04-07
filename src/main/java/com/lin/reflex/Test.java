package com.lin.reflex;

import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 17:15 2020/4/3
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Class clazz = User.class;
        User user = (User)clazz.newInstance();
        Method method = clazz.getMethod("setAge", int.class);
        method.invoke(user,12);
        Method method1 = clazz.getMethod("getAge");
        System.out.println(method1.invoke(user));
    }
}
