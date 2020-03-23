package com.lin.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 19:38 2020/1/31
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket("127.0.0.1",port);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));// in
            printWriter = new PrintWriter(socket.getOutputStream(),true);// out
            printWriter.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed.");
            String resp = bufferedReader.readLine();
            System.out.println("Now is : " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bufferedReader = null;

            if(printWriter != null){
                printWriter.close();
            }
            printWriter = null;

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            socket = null;
        }
    }
}
