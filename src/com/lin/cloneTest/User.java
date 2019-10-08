package com.lin.cloneTest;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/12 13:12
 * @Modified By:
 **/
public class User implements Cloneable{
    private String uid;
    private String name;

    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
