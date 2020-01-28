package com.lin.serializable;
import java.io.Serializable;

public class Man implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;

    private transient String password;

    private static int a = 1;

    public Man() {
    }

    public Man(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        Man.a = a;
    }
}
