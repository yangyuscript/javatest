package com.lin.DesignPatterns.singleton;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/8 19:48
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) {
        /*System.out.println(SingletonEnum.DATASOURCE.getConnectionC3P0());
        System.out.println(SingletonEnum.DATASOURCE.getConnectionDBCP());
        System.out.println(SingletonEnum.DATASOURCE.getConnectionDruid());*/

        SingletonHungry instance1 = SingletonHungry.getInstance();
        SingletonHungry instance2;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
            oos.writeObject(instance1);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.txt"));
            instance2 = (SingletonHungry)ois.readObject();

            System.out.println(instance1 == instance2);
            System.out.println(instance1);
            System.out.println(instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 懒汉模式(线程不安全)
 */
class SingletonLazyNotSafe{
    private static SingletonLazyNotSafe singletonLazyNotSafe;
    private SingletonLazyNotSafe(){};
    public static SingletonLazyNotSafe getInstance(){
        if(null == singletonLazyNotSafe){
            singletonLazyNotSafe = new SingletonLazyNotSafe();
        }
        return singletonLazyNotSafe;
    }
}

/**
 * 懒汉模式(线程安全)
 */
class SingletonLazy {
    private static SingletonLazy singletonLazy;
    private SingletonLazy(){};
    public static synchronized SingletonLazy getInstance(){
        if(null == singletonLazy){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }


}

/**
 * 饿汉式(线程安全)
 */
class SingletonHungry implements Serializable{
    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){};
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }

    //防止反序列化生成新的实例对象
    /*private Object readResolve(){
        System.out.println("read resolve");
        return singletonHungry;
    }*/

}

/**
 * DCL模式(DOUBLE CHECK LOCK)
 */
class SingletonDCL{
    private volatile static SingletonDCL singletonDCL;
    private SingletonDCL(){}
    public static SingletonDCL getInstance(){
        if(null == singletonDCL){
            synchronized (SingletonDCL.class){
                if(singletonDCL == null){
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}

/**
 * 静态内部类模式
 */
class SingletonStaticInnerClazz{
    private SingletonStaticInnerClazz(){}
    public static SingletonStaticInnerClazz getInstance(){
        return SingletonHolder.singletonStaticInnerClazz;
    }

    private static class SingletonHolder{
        private final static SingletonStaticInnerClazz singletonStaticInnerClazz = new SingletonStaticInnerClazz();
    }
}

/**
 * 枚举类模式
 */
enum SingletonEnum{
    DATASOURCE;

    private String connectionC3P0;
    private String connectionDruid;
    private String connectionDBCP;

    SingletonEnum(){
        connectionC3P0 = "C3P0";
        connectionDruid = "Druid";
        connectionDBCP = "DBCP";
        System.out.println("调用了构造方法");
    }

    public String getConnectionC3P0(){
        return connectionC3P0;
    }
    public String getConnectionDruid(){
        return connectionDruid;
    }
    public String getConnectionDBCP(){
        return connectionDBCP;
    }
}

/**
 * 容器模式
 */
class SingletonContainer{
    private static Map<String,Object> map = new HashMap<>();
    private SingletonContainer(){

    }
    public static void registInstance(String key,Object instance){
        if(!map.containsKey(key)){
            map.put(key,instance);
        }
    }
    public static Object getInstance(String key){
        return map.get(key);
    }
}