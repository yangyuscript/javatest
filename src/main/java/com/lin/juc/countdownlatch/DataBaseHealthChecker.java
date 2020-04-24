package com.lin.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DataBaseHealthChecker extends BaseHealthChecker{
    public DataBaseHealthChecker (CountDownLatch latch)  {
        super("DataBase Services", latch);
    }

    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(8000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
