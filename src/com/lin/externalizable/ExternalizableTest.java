package com.lin.externalizable;

import com.lin.externalizable.User;

import java.io.*;

public class ExternalizableTest {
    public static void main(String[] args) {
        //writeExternalizableObject();
        readExternalizableObject();
    }

    // Externalizable的序列化对象
    public static void writeExternalizableObject() {
        User user = new User("huhx", 22);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Externalizable.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Externalizable的反序列化对象
    public static void readExternalizableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Externalizable.txt"));
            User user = (User) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("name: " + user.getName() + ", age: " + user.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
