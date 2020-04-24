package com.lin.ai.parsexml;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:26 2020/4/13
 */
public class Tx {
    private List list = new ArrayList();

    public Tx() {
    }

    public void addMethod(Method method) {
        this.list.add(method);
    }

    public Method[] getMethods() {
        return (Method[])this.list.toArray(new Method[0]);
    }
}
