package com.lin.print;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/26 16:22
 * @Modified By:
 **/
public class PrintHelper implements Printable {
    private static Map<String,Object> ticketMap;

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }
}
