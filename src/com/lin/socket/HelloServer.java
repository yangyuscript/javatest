package com.lin.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer{
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket=null;
        PrintWriter out=null;
        try{
            //在下面实例化一个服务器端的Socket连接
            serverSocket=new ServerSocket(9999);
        }catch(IOException e){
            System.err.println("Could not listen on port:9999");
            System.exit(1);
        }

        Socket clientSocket=null;
        try{
            //accept()方法用来监听客户端的连接
            clientSocket=serverSocket.accept();
        }catch(IOException e){
            System.err.println("Accept failed");
            System.exit(1);
        }
        out=new PrintWriter(clientSocket.getOutputStream(),true);
        out.println("hello world!");
        clientSocket.close();
        serverSocket.close();
    }
}
