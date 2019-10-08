package com.lin.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User implements Externalizable {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        System.out.println("user constructor two.");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
        System.out.println("user constructor none.");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("write external.");
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("read external.");
        name = (String) in.readObject();
        age = in.readInt();
    }
}
