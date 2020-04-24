package com.lin.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BaseHealthChecker{
    public CacheHealthChecker (CountDownLatch latch)  {
        super("Cache Services", latch);
    }

    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(6000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
