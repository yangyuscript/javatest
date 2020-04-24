package com.lin.ai.parsexml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:20 2020/4/13
 */
public class Services {
    private List list = new ArrayList();

    public Services() {
    }

    public void addService(Service service) {
        this.list.add(service);
    }

    public Service[] getServices() {
        return (Service[])this.list.toArray(new Service[0]);
    }
}
