package com.lin.file.filter;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/28 22:00
 * @Modified By:
 **/
public class MySecondFilter implements FileFilter {
    private Pattern pattern = Pattern.compile("^[a-z]*$");
    @Override
    public boolean accept(File pathname) {
        return pattern.matcher(pathname.getName()).matches();
    }
}
