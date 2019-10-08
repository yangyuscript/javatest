package com.lin.DesignPatterns.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/21 11:51
 * @Modified By:
 **/
public class Subscriber implements Observer {
    public Subscriber(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("收到通知:"+((Publisher)o).getData());
    }
}
