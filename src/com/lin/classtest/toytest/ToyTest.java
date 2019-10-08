package com.lin.classtest.toytest;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/3 11:35
 * @Modified By:
 **/
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:"+cc.getName()+"is interfaces?["+cc.isInterface()+"]");
        System.out.println("Simple name:"+cc.getSimpleName());
        System.out.println("Canonical name:"+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c=Class.forName("com.lin.classtest.toytest.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for(Class face:c.getInterfaces()){
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("can not instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("can not access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
