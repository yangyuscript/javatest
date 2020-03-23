package com.lin.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 20:18 2020/2/25
 */
public class SPITest {
    public static void main(String[] args) {
        Iterator<SPIService> provoiders = Service.providers(SPIService.class);
        ServiceLoader<SPIService>  load = ServiceLoader.load(SPIService.class);

        while(provoiders.hasNext()){
            SPIService spiService = provoiders.next();
            spiService.execute();
        }

        System.out.println("-------------");

        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()){
            SPIService spiService = iterator.next();
            spiService.execute();
        }
    }
}
