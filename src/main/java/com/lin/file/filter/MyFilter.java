package com.lin.file.filter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/28 21:22
 * @Modified By:
 **/
public class MyFilter implements FilenameFilter {
    private Pattern pattern = Pattern.compile("^[a-z]*$");
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
