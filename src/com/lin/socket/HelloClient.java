package com.lin.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloClient {
    public static void main(String[] args) throws IOException{
        Socket helloSocket=null;
        BufferedReader in=null;
        //下面这段程序，用来将输入输出流与socket关联
        try{
            helloSocket=new Socket("localhost",9999);
            System.out.println("已成功连接"+args);
            in=new BufferedReader(new InputStreamReader(helloSocket.getInputStream()));
        }catch(UnknownHostException e){
            System.err.println("Don't know about host:localhost!");
            System.exit(1);
        }catch(IOException e){
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }
        System.out.println(in.readLine()+"wtf");
        in.close();
        helloSocket.close();
    }
}
