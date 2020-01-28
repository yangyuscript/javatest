package com.lin.generic;

/**
 * @Author: lingx
 * @Description:
 * @Date: Created in 2019/3/12 9:24
 * @Modified By:
 **/
public class Pari<T> {
    private T first;
    private T second;

    public Pari() {
    }

    public Pari(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
