package com.lin.exception;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/1 20:20
 * @Modified By:
 **/
public class TestMain {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test() throws Exception{
        throw new Exception("test exception");
    }

    public static void test2() throws Exception{
        String a = new String();
        try {
            test();
        } catch (Exception e) {
            System.out.println("2");
            a=e.getMessage();
            //e.printStackTrace();
        } finally {
            System.out.println("1");
            throw new Exception("test2 cexption:"+a);
        }
    }
}
