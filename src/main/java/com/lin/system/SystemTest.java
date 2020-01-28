package com.lin.system;

import java.util.Properties;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/9/16 21:19
 * @Modified By:
 **/
public class SystemTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties);
    }
}
