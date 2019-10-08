package com.lin.exception;

public class Test {
    public static void main(String[] args) {
        Father[] objs = new Father[2];
        objs[0] = new Father();
        objs[1] = new Son();

        for(Father obj:objs)
        {
            //因为Son类抛出的实质是SQLException，而IOException无法处理它。
            //那么这里的try。。catch就不能处理Son中的异常。
            //多态就不能实现了。
            try {
                obj.start();
            }catch(Exception e)
            {
                //处理IOException
                System.out.println("处理异常:"+e);
            }
        }
    }
}
