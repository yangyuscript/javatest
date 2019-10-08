package com.lin.serializable;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) {
        writeSerializableObject();
        readSerializableObject();
    }

    /**
     * Serializable：把对象序列化
     */
    public static void writeSerializableObject() {
        try {
            Man man = new Man("lingx", "123456");
            Man.setA(1);
            Person person = new Person(man, "刘力", 21);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
            objectOutputStream.writeObject("string");
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Serializable：反序列化对象
     */

    public static void readSerializableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("output.txt"));
            String string = (String) objectInputStream.readObject();
            Person person = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(string);
            System.out.println("man username is: " + person.getMan().getUsername()+", man password is:"+person.getMan().getPassword()+"  "+Man.getA());
            System.out.println("person username is: " + person.getUsername() +", person age is"+person.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
