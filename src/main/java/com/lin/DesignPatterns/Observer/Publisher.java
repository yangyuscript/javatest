package com.lin.DesignPatterns.Observer;

import java.util.Observable;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/21 11:54
 * @Modified By:
 **/
public class Publisher extends Observable {
    private String data="";

    public String getData(){
        return data;
    }

    public void setData(String data){
        if(!this.data.equals(data)){
            this.data=data;
            setChanged(); //改变通知这状态
        }
        notifyObservers();
    }
}
