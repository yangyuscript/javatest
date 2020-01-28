package com.lin.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflexTest {
    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException,InstantiationException,NoSuchFieldException{
        //第一种方式
        Class c = Class.forName("com.lin.reflex.User");
        //第二种方式
        //java中每个类型都有class属性
        Class c2= User.class;
        //第三种方式
        //java语言中任何一个java对象都有getClass方法
        User user=new User();
        Class c3=user.getClass();//c3是运行时类（user的运行时类是User)

        //创建此Class对象所表示的类的一个新实例
        Object o=c.newInstance();//调用了User的无参构造方法

        //先看获取所有的属性的写法：
        Field[] fs = c.getDeclaredFields();
        System.out.println("all fields:");
        for (Field field:fs) {
            System.out.println(field);
        }

        //获取所有的构造方法
        Constructor[] constructors = c.getDeclaredConstructors();
        System.out.println("all constructors:");
        for (Constructor con : constructors) {
            System.out.println(con);
        }

        Method[] methods = c.getMethods();
        System.out.println("all methods:");
        for (Method method:methods) {
            System.out.println(method);
        }
        System.out.println("get method setName:");
        try {
            System.out.println(c.getMethod("setName", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //定义可变长的字符串，用来存储属性
        StringBuffer sb = new StringBuffer();
        //通过追加的方法，将每个属性拼接到此字符串中
        //最外边的public定义
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
        //里边的每一个属性
        for(Field field:fs){
            sb.append("\t");//空格
            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName()+";\n");//属性的名字+回车
        }

        sb.append("}");
        System.out.println(sb);

        //获取特定的属性，对比着传统的方法来学习：
        Field userIdF=c.getDeclaredField("userId");
        userIdF.setAccessible(true);
        userIdF.set(o,110);
        System.out.println(userIdF.get(o));
    }
}
