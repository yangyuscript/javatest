package com.lin.string;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/23 20:01
 * @Modified By:
 **/
public class StringFormatTest {
    public static void main(String[] args) {
        String a = "                                           test\n" +
                "test\n" +
                "Lorem ipsum dolor sit amet,\n" +
                " consectetur adipiscing elit, sed do eiusmod tempor.\n" +
                "                                              null\n" +
                "                                               null\n" +
                "                    null\n" +
                "                              null\n" +
                "                        null\n" +
                "                     null\n";

        StringBuffer sbBcfileInfo = new StringBuffer();
        String[] adContentArray = a.split("\n");
        if(null!=adContentArray && adContentArray.length>0){
            for (String adStr:adContentArray) {
                sbBcfileInfo.append("BTXT");
                if(adStr.length()==adStr.trim().length()){
                    sbBcfileInfo.append(adStr);
                }else{
                    //sbBcfileInfo.append(String.format("%"+String.valueOf(adStr.length()-adStr.trim().length())+"s",adStr));
                    sbBcfileInfo.append(adStr);
                }
                sbBcfileInfo.append("\n");
            }
        }
        System.out.println(sbBcfileInfo.toString());
    }
}
