package com.lin.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/10 15:38
 * @Modified By:
 **/
public class ReadProperties {
    public static void main(String[] args) {
        read();
        System.out.println("haha");
    }

    public static void read(){
        Properties pro = new Properties();
        Map<String,Object> pros = new ConcurrentHashMap<>();
        Map<String,Object> prefixMap = new ConcurrentHashMap<>();
        InputStream in = ReadProperties.class.getClassLoader().getResourceAsStream("dbroute.properties");
        if (in != null) {

            try {
                pro.load(in);
                Iterator var2 = pro.entrySet().iterator();

                while(var2.hasNext()) {
                    Map.Entry<Object, Object> entry = (Map.Entry)var2.next();
                    String key = entry.getKey().toString();
                    String val = entry.getValue().toString();
                    pros.put(key, val);
                    int index = 0;

                    while((index = key.indexOf(46, index + 1)) > 0) {
                        prefixMap.put(key.substring(0, index), true);
                    }
                }
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        }
        System.out.println("haha");
    }

}
