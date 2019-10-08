package com.lin.ProxyTest.jdkProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/1 11:38
 * @Modified By:
 **/
public class Client {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();

        InvocationHandler invocationHandler = new DynamicProxy(realSubject);
        //realSubject.getClass().getInterfaces() 可替换成 new Class<?>[]{Subject.class}
        Subject subject = (Subject)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),invocationHandler);
        String clazzPath = subject.getClass().getName();
        System.out.println(clazzPath);
        String clazzName = clazzPath.split("\\.")[clazzPath.split("\\.").length-1];
        System.out.println(clazzName);
        getProxyClassFile(clazzPath);


        subject.rent();

        subject.hello("lingx");
    }

    public static void getProxyClassFile(String clzzName){
        byte[] classFile = ProxyGenerator.generateProxyClass(clzzName, RealSubject.class.getInterfaces());
        String path = "E:/SubjectProxy4.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
