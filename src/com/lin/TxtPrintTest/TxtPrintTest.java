package com.lin.TxtPrintTest;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/4 17:14
 * @Modified By:
 **/
public class TxtPrintTest {
    public static void main(String[] args) throws Exception{
        String str = "          中國移動香港有限公司\r\n" +
                " \r\n" +
                "                   發票及收據編號: 3770200\r\n" +
                "客戶姓名: MS. S*****, .\r\n" +
                "客戶號碼: 1.8219271\r\n" +
                "流動電話號碼:    69364140\r\n" +
                "付款日期:  26/04/2019\r\n" +
                "付款時間:  11:39:54 AM\r\n" +
                "收費項目                          付款金額\r\n" +
                "------------------------------------------\r\n" +
                "預繳                                $84.00\r\n" +
                "首月基本月費(折實金額)              $18.00\r\n" +
                "產品及其他費用(折實金額)           $554.00\r\n" +
                "                    ----------------------\r\n" +
                "總繳納款項                         $656.00\r\n" +
                " \r\n" +
                "手機及附件產品內容                產品售價\r\n" +
                "------------------------------------------\r\n" +
                " ChinaMobile A3 Handset Package-Black\r\n" +
                "  862469031280385                  $638.00\r\n" +
                " \r\n" +
                "    付款辨法: PTC - Cash\r\n" +
                "付款帳戶編號: -\r\n" +
                " \r\n" +
                " \r\n" +
                "手機配件購物獎賞\r\n" +
                "由2016年8月1日起, 累積購買金額為$0.00\r\n" +
                " \r\n" +
                "門市編號: PT01 - ZS02\r\n" +
                "門市地址: G/F, Far East Consortium Bldg., \r\n" +
                "          117 Des Voeux Road C, \r\n" +
                "          (Tel:29458175)\r\n" +
                "          貨物出門，恕不退款\r\n" +
                "             多謝 - CMHK\r\n" +
                "------------------------------------------\r\n" +
                " 下次繳費可憑此二維碼以現金於全港任何一間\r\n" +
                "            7-Eleven便利店繳費\r\n" +
                "   更方便、更快捷！繳費將於48小時內入賬。\r\n" +
                " \r\n" +
                "請拍攝並儲存此二維碼於手機內以便日後使用。\r\n" +
                " \r\n" +
                "\u001D(k\u0003 1C\u0006\u001D(k\u0003 1E3\u001D(k\u0016 1P00700420082192716236\u001Ba1\u001D(k\u0003 1Q0\u001Ba0\r\n" +
                " \r\n" +
                " \r\n" +
                " \r\n" +
                " \r\n" +
                "------------------------------------------\r\n" +
                "--客戶請保留此發票及收據作為購買憑證--\r\n" +
                "   --如需留存記錄，客戶可自行影印--";

        FileOutputStream fos = new FileOutputStream(new File("E:/test.txt"));
        fos.write(str.getBytes());
        fos.close();
    }
}
