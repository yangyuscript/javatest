package com.lin.ai.parsexml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:21 2020/4/13
 */
public class Service {
    private List list = new ArrayList();
    private String id;
    private String invoke;
    private String type;
    private Tx tx;

    public Service() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoke() {
        return this.invoke;
    }

    public void setInvoke(String invoke) {
        this.invoke = invoke;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addProperty(Property property) {
        this.list.add(property);
    }

    public Property[] getPropertys() {
        return (Property[])this.list.toArray(new Property[0]);
    }

    public Tx getTx() {
        return this.tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }
}
