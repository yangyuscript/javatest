package com.lin.file.ai;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:27 2020/2/18
 */
public class Test {
    public static void main(String[] args) throws Exception{
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        File file = new File("C:\\Users\\Administrator\\Desktop\\ACK.FR2020021821.20200206.DAT");
        String stmp = "";
        BufferedReader br=new BufferedReader(new FileReader(file));
        int b;
        while((b=br.read())!=-1){
            stmp += (char)b;
        }
        br.close();

        if("\n".equals(stmp.substring(stmp.length() - 1))){
            stmp = stmp.substring(0, stmp.length() - 1);
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            bw.write(stmp);
            bw.close();
        }
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.toString());
    }
}
