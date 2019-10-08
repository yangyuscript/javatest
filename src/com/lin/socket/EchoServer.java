package com.lin.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket=null;
        PrintWriter out=null;
        BufferedReader in=null;
        try{
            //实例化监听端口
            serverSocket=new ServerSocket(1111);
            System.out.println("服务器启动...");
        }catch (IOException e){
            System.err.println("Could not listen on port:1111");
            System.exit(1);
        }
        Socket incoming=null;
        while(true){
            incoming=serverSocket.accept();
            out=new PrintWriter(incoming.getOutputStream(),true);
            //将字节流放入字符流缓冲之中
            in=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            out.println("Hello!...");
            out.println(("Enter BYE to exit"));
            out.flush();
            //在没有异常的情况下不断循环
            while(true){
                //只有当用户输入数据的时候才返回数据内容
                String str=in.readLine();
                //当用户连接断掉的时候回返回空值null
                if(str==null){
                    //退出循环
                    break;
                }else{
                    //对用户输入子串加前缀Echo：，将此信息打印到客户端
                    out.println("Echo:"+str);
                    out.flush();
                    //退出命令，equalsIgnoreCase()是不区分大小写的比较
                    if(str.trim().equalsIgnoreCase("BYE"))
                        break;
                }
            }
            //收尾工作
            out.close();
            in.close();
            incoming.close();
            serverSocket.close();
        }
    }
}
