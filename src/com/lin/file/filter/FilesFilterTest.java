package com.lin.file.filter;

import java.io.File;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/28 21:21
 * @Modified By:
 **/
public class FilesFilterTest {
    public static void main(String[] args) {
        File file = new File("H://");
        String[] fileNames = file.list(new MyFilter());
        for (String fn:fileNames) {
            System.out.println(fn);
        }
    }
}
