package com.lin.spi;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 20:16 2020/2/25
 */
public class OneSPIService implements SPIService {
    @Override
    public void execute() {
        System.out.println("OneSPIService is executing");
    }
}
