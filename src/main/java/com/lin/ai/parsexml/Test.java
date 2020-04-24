package com.lin.ai.parsexml;

import org.apache.commons.digester.Digester;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:27 2020/4/13
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("services", Services.class.getName());
        digester.addSetProperties("services");
        digester.addObjectCreate("services/service", Service.class.getName());
        digester.addSetProperties("services/service");
        digester.addObjectCreate("services/service/property", Property.class.getName());
        digester.addSetProperties("services/service/property");
        digester.addObjectCreate("services/service/property/ref", Ref.class.getName());
        digester.addSetProperties("services/service/property/ref");
        digester.addObjectCreate("services/service/tx", Tx.class.getName());
        digester.addSetProperties("services/service/tx");
        digester.addObjectCreate("services/service/tx/method", Method.class.getName());
        digester.addSetProperties("services/service/tx/method");
        digester.addSetNext("services/service", "addService", Service.class.getName());
        digester.addSetNext("services/service/property", "addProperty", Property.class.getName());
        digester.addSetNext("services/service/property/ref", "setRef", Ref.class.getName());
        digester.addSetNext("services/service/tx", "setTx", Tx.class.getName());
        digester.addSetNext("services/service/tx/method", "addMethod", Method.class.getName());

        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.xml");
        Services services = (Services)digester.parse(input);
        System.out.println(services);
    }
}
