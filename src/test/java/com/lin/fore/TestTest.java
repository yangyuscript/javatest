package com.lin.fore;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:34 2020/3/25
 */
public class TestTest {
    @Test
    public void test(){
        Stack<String> stack = new Stack<>();
        stack.push("ddd");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.size());
    }
}