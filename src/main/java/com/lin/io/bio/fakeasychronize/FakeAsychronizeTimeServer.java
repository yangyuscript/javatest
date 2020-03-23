package com.lin.io.bio.fakeasychronize;

import com.lin.io.bio.TimeServerHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc: 伪异步
 * @Author: lingx
 * @Date: 20:29 2020/1/31
 */
public class FakeAsychronizeTimeServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            //创建I/O任务线程池
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(50,10000);
            while (true){
                socket = serverSocket.accept();
                timeServerHandlerExecutePool.execute(new TimeServerHandler(socket));
            }
        } catch (Exception e){

        } finally {
            if(serverSocket != null){
                System.out.println("The time server close");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket = null;
            }
        }

    }
}
