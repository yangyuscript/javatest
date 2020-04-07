package com.lin.sfa;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/30 23:23
 * @Modified By:
 **/
public class AnalysisSfile {
    public static void main(String[] args) throws Exception{
        if(null == args || args.length==0){
            System.out.println("请输入至少一个参数！！！\r\n" +
                    "第一个参数（必填）：待解析S文件绝对路径 \r\n" +
                    "第二个参数（非必填）：解析后生成的sql脚本路径及名称，默认在C:\\YYYYMMDDHHmmss.sql");
            return;
        }

        //生成的sql文件
        String fpath = args.length > 1 ? args[1] : "C:\\"+getNowTime()+".sql";
        System.out.println("解析的S文件路径为："+args[0]);
        System.out.println("解析后脚本路径为："+fpath);
        File file = new File(fpath);
        FileWriter fileWriter = new FileWriter(file);
        //待解析的文件
        Map<String,List<String>> map = getSql(args[0]);
        System.out.println("BILL_AR_SQL:");
        for (String sql:map.get("AR_SQL")) {
            System.out.println(sql);
            fileWriter.append(sql);
            fileWriter.append("\n");
        }
        fileWriter.append("\n");
        fileWriter.append("\n");
        System.out.println("");
        System.out.println("BILL_ITEM_SQL:");
        for (String sql:map.get("ITEM_SQL")) {
            System.out.println(sql);
            fileWriter.append(sql);
            fileWriter.append("\n");
        }
        fileWriter.append("\n");
        fileWriter.append("\n");
        System.out.println("");
        System.out.println("BILL_COLLECT_SQL:");
        for (String sql:map.get("COLLECT_SQL")) {
            System.out.println(sql);
            fileWriter.append(sql);
            fileWriter.append("\n");
        }
        fileWriter.close();
    }

    public static List<Map<String,Object>> parseSfile(String filePath) throws Exception{
        List<Map<String,Object>> arList = new ArrayList<>();
        File pathFile = new File(filePath);
        if (pathFile.isFile() && pathFile.exists()) {
            //创建文件字节读取流文件，明确与之关联的数据源
            FileInputStream is = new FileInputStream(pathFile);
            //将字节流包装成字符流
            InputStreamReader isReader = new InputStreamReader(is, "utf-8");
            //提供缓冲式文本读本
            BufferedReader br = new BufferedReader(isReader);
            String lineTxt = null;
            //按行读取
            while ((lineTxt = br.readLine()) != null) {
                getSourceArData(lineTxt,arList);
            }
            is.close();
            isReader.close();
            br.close();
        } else {
            throw new Exception("文件不存在");
        }
        return arList;
    }


    public static void getSourceArData(String lineTxt,List<Map<String,Object>> list){
        String[] strs = lineTxt.split(",");
        Map<String,Object> map = new HashMap<>();
        map.put("ACCT_ID",strs[1]);
        map.put("SUBSCRIBER_ID",strs[2]);
        map.put("ACCESS_NO",strs[3]);
        map.put("BILL_MONTH",strs[4]);
        map.put("BILL_ITEM_ID",strs[5]);
        map.put("INIT_FEE",Long.valueOf(strs[6])-Long.valueOf(strs[8]));
        map.put("FEE",Long.valueOf(strs[6])-Long.valueOf(strs[7]));
        map.put("ACCT_BEGIN_DATE",strs[11]);
        map.put("ACCT_DAY",strs[12]);
        map.put("MIX_SPLIT_ITEM_ID",strs[17]);
        map.put("MIX_SPLIT_FEE",Long.valueOf(strs[6])-Long.valueOf(strs[7]));
        map.put("CREATE_DATE","to_date('"+strs[12]+"', 'yyyymmdd')");
        map.put("REGION_ID","852");
        map.put("DEFAULT_ACCT_ID",strs[18]);
        map.put("PRODUCT_OFFERING_ID",strs[19]);
        map.put("PRODUCT_ID",strs[20]);
        map.put("COLLECT_ID","SEQ_COLLECT_ID.NEXTVAL");
        map.put("PRE_FLAG",strs[21]);
        map.put("MAIN_PROMOTION",strs[22]);
        map.put("GLCODE",strs[23]);
        map.put("USED_DAYS",strs[24]);
        map.put("USED_BEGIN_DATE",strs[25]);
        map.put("USED_END_DATE",strs[26]);
        list.add(map);
    }

    public static Map<String,List<String>> getSql(String filePath) throws Exception{
        List<Map<String,Object>> arList = parseSfile(filePath);
        Map<String,List<String>> sqlMap = new HashMap<>(3);
        List<String> arSqlList = new LinkedList<>();
        List<String> itemSqlList = new LinkedList<>();
        List<String> collectSqlList = new LinkedList<>();
        Map<String,Map<String,Object>> itemMap = new HashMap<>();
        for (Map<String,Object> arMap:arList) {
            String billMonth = MapGetString(arMap,"BILL_MONTH");
            //ar表
            getArSql(billMonth,arMap,arSqlList);

            //item表
            String itemKey = billMonth+MapGetString(arMap,"ACCT_ID")+MapGetString(arMap,"SUBSCRIBER_ID")+MapGetString(arMap,"BILL_ITEM_ID");
            if(itemMap.containsKey(itemKey)){
                Map<String,Object> temp = itemMap.get(itemKey);
                temp.put("INIT_FEE",(long)temp.get("INIT_FEE") + (long)arMap.get("INIT_FEE"));
                temp.put("FEE",(long)temp.get("FEE") + (long)arMap.get("FEE"));
            }else{
                itemMap.put(itemKey,arMap);
            }
        }
        //处理itemMap
        Map<String,Map<String,Object>> collectMap = solveItemMap(itemMap,itemSqlList);
        //处理collectMap
        solveCollectMap(collectMap,collectSqlList);

        sqlMap.put("AR_SQL",arSqlList);
        sqlMap.put("ITEM_SQL",itemSqlList);
        sqlMap.put("COLLECT_SQL",collectSqlList);
        return sqlMap;
    }

    public static void solveCollectMap(Map<String,Map<String,Object>> collectMap,List<String> collectSqlList){
        for (Map<String,Object> collect:collectMap.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into ucr_ac1.am_bill_collect (COLLECT_ID, PARTITION_ID, ACCT_ID, SUBSCRIBER_ID, ACCESS_NO, BILL_TYPE, BILL_MONTH, ACCT_BEGIN_DATE, ACCT_DAY, FEE, BALANCE, PEER_BUSINESS_ID, PEER_OPER_DATE, CREATE_DATE, OP_DATE, TRADE_DATE, TRADE_OP_ID, TRADE_ORG_ID, TRADE_COUNTY_CODE, TRADE_REGION_ID, REGION_ID, CANCEL_FLAG, CANCEL_DATE, CANCEL_OP_ID, CANCEL_ORG_ID, CANCEL_COUNTY_CODE, CANCEL_REGION_ID, CANCEL_BUSINESS_ID, BACK_MONEY) values (");
            sb.append(MapGetString(collect,"COLLECT_ID"));
            sb.append(",");
            sbAppend(sb,String.valueOf(MapGetLong(collect,"ACCT_ID")%10000));
            sbAppend(sb,MapGetString(collect,"ACCT_ID"));
            sbAppend(sb,MapGetString(collect,"SUBSCRIBER_ID"));
            sbAppend(sb,MapGetString(collect,"ACCESS_NO"));
            sbAppend(sb,"M");
            sbAppend(sb,MapGetString(collect,"BILL_MONTH"));
            sbAppend(sb,MapGetString(collect,"ACCT_BEGIN_DATE"));
            sbAppend(sb,MapGetString(collect,"ACCT_DAY"));
            //sbAppend(sb,MapGetString(collect,"INIT_FEE"));
            sbAppend(sb,MapGetString(collect,"FEE"));
            sbAppend(sb,MapGetString(collect,"FEE"));
            sbAppend(sb,"");
            sbAppend(sb,"");
            sb.append(MapGetString(collect,"CREATE_DATE"));
            sb.append(",");
            // OP_DATE
            sb.append(MapGetString(collect,"CREATE_DATE"));
            sb.append(",");
            // TRADE_DATE
            sb.append(MapGetString(collect,"CREATE_DATE"));
            sb.append(",");
            sbAppend(sb,"BATCH");
            sbAppend(sb,"21000100");
            sbAppend(sb,"852");
            sbAppend(sb,"852");
            sbAppend(sb,"852");
            sbAppend(sb,"U");
            sbAppend(sb,"");
            sbAppend(sb,"");
            sbAppend(sb,"");
            sbAppend(sb,"");
            sbAppend(sb,"");
            sbAppend(sb,"");
            sbAppend(sb,"",false);
            sb.append(");");
            collectSqlList.add(sb.toString());
        }
    }

    public static Map<String,Map<String,Object>> solveItemMap(Map<String,Map<String,Object>> itemMap,List<String> itemSqlList){
        Map<String,Map<String,Object>> collect = new HashMap<>();
        for (Map<String,Object> item:itemMap.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into ucr_ac1.am_bill_item (BILL_ID, PARTITION_ID, ACCT_ID, SUBSCRIBER_ID, ACCESS_NO, BILL_MONTH, ACCT_BEGIN_DATE, ACCT_DAY, BILL_ITEM_ID, FEE, BALANCE, BILL_FLAG, WRITEOFF_FLAG, CREATE_DATE, OP_DATE, REGION_ID, COLLECT_ID, GLCODE) values (");
            sb.append("223030||SEQ_BILL_ID.NEXTVAL");
            sb.append(",");
            sbAppend(sb,String.valueOf(MapGetLong(item,"ACCT_ID")%10000));
            sbAppend(sb,MapGetString(item,"ACCT_ID"));
            sbAppend(sb,MapGetString(item,"SUBSCRIBER_ID"));
            sbAppend(sb,MapGetString(item,"ACCESS_NO"));
            sbAppend(sb,MapGetString(item,"BILL_MONTH"));
            sbAppend(sb,MapGetString(item,"ACCT_BEGIN_DATE"));
            sbAppend(sb,MapGetString(item,"ACCT_DAY"));
            sbAppend(sb,MapGetString(item,"BILL_ITEM_ID"));
            //sbAppend(sb,MapGetString(item,"INIT_FEE"));
            sbAppend(sb,MapGetString(item,"FEE"));
            sbAppend(sb,MapGetString(item,"FEE"));
            sbAppend(sb,"U");
            sbAppend(sb,"N");
            sb.append(MapGetString(item,"CREATE_DATE"));
            sb.append(",");
            sb.append("sysdate");
            sb.append(",");
            sbAppend(sb,"852");
            //sbAppend(sb,MapGetString(item,"COLLECT_ID"));
            sb.append("(SELECT T.COLLECT_ID FROM UCR_AC1.AM_BILL_COLLECT T WHERE T.BILL_TYPE='M' AND T.ACCT_DAY="+ MapGetString(item,"ACCT_DAY") +" AND T.ACCT_ID="+ MapGetString(item,"ACCT_ID") +"),");
            sbAppend(sb,MapGetString(item,"GLCODE"),false);
            sb.append(");");
            itemSqlList.add(sb.toString());

            //处理collect
            if(collect.containsKey(MapGetString(item,"ACCT_ID"))){
                Map<String,Object> temp = collect.get(MapGetString(item,"ACCT_ID"));
                if(!"-1".equals(MapGetString(temp,"SUBSCRIBER_ID")) && !MapGetString(temp,"SUBSCRIBER_ID").equals(MapGetString(item,"SUBSCRIBER_ID"))){
                    temp.put("SUBSCRIBER_ID","-1");
                    temp.put("ACCESS_NO","-1");
                }
                temp.put("INIT_FEE",(long)temp.get("INIT_FEE") + (long)item.get("INIT_FEE"));
                temp.put("FEE",(long)temp.get("FEE") + (long)item.get("FEE"));
            }else{
                collect.put(MapGetString(item,"ACCT_ID"),item);
            }
        }
        return collect;
    }

    public static void getArSql(String billMonth, Map<String, Object> arMap,List<String> arSqlList){
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ucr_ac1.am_bill_ar_");
        sb.append(billMonth);
        sb.append(" (ACCT_ID, PARTITION_ID, SUBSCRIBER_ID, ACCESS_NO, BILL_MONTH, ACCT_BEGIN_DATE, ACCT_DAY, BILL_ITEM_ID, INIT_FEE, FEE, MIX_SPLIT_ITEM_ID, MIX_SPLIT_FEE, CREATE_DATE, REGION_ID, DEFAULT_ACCT_ID, PRODUCT_OFFERING_ID, PRODUCT_ID, COLLECT_ID, PRE_FLAG, MAIN_PROMOTION, GLCODE, USED_DAYS, USED_BEGIN_DATE, USED_END_DATE) values (");
        sbAppend(sb,MapGetString(arMap,"ACCT_ID"));
        sbAppend(sb,String.valueOf(MapGetLong(arMap,"ACCT_ID")%10000));
        sbAppend(sb,MapGetString(arMap,"SUBSCRIBER_ID"));
        sbAppend(sb,MapGetString(arMap,"ACCESS_NO"));
        sbAppend(sb,MapGetString(arMap,"BILL_MONTH"));
        sbAppend(sb,MapGetString(arMap,"ACCT_BEGIN_DATE"));
        sbAppend(sb,MapGetString(arMap,"ACCT_DAY"));
        sbAppend(sb,MapGetString(arMap,"BILL_ITEM_ID"));
        sbAppend(sb,MapGetString(arMap,"INIT_FEE"));
        sbAppend(sb,MapGetString(arMap,"FEE"));
        sbAppend(sb,MapGetString(arMap,"MIX_SPLIT_ITEM_ID"));
        sbAppend(sb,MapGetString(arMap,"MIX_SPLIT_FEE"));
        sb.append(MapGetString(arMap,"CREATE_DATE"));
        sb.append(",");
        sbAppend(sb,MapGetString(arMap,"REGION_ID"));
        sbAppend(sb,MapGetString(arMap,"DEFAULT_ACCT_ID"));
        sbAppend(sb,MapGetString(arMap,"PRODUCT_OFFERING_ID"));
        sbAppend(sb,MapGetString(arMap,"PRODUCT_ID"));
        //sbAppend(sb,MapGetString(arMap,"COLLECT_ID"));
        sb.append("(SELECT T.COLLECT_ID FROM UCR_AC1.AM_BILL_COLLECT T WHERE T.BILL_TYPE='M' AND T.ACCT_DAY="+ MapGetString(arMap,"ACCT_DAY") +" AND T.ACCT_ID="+ MapGetString(arMap,"ACCT_ID") +"),");
        sbAppend(sb,MapGetString(arMap,"PRE_FLAG"));
        sbAppend(sb,MapGetString(arMap,"MAIN_PROMOTION"));
        sbAppend(sb,MapGetString(arMap,"GLCODE"));
        sbAppend(sb,MapGetString(arMap,"USED_DAYS"));
        sbAppend(sb,MapGetString(arMap,"USED_BEGIN_DATE"));
        sbAppend(sb,MapGetString(arMap,"USED_END_DATE"),false);
        sb.append(");");
        arSqlList.add(sb.toString());
    }


    public static long getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return Long.valueOf(sdf.format(new Date()));
    }

    public static String MapGetString(Map<String,Object> map,String key){
        return String.valueOf(map.get(key));
    }

    public static Long MapGetLong(Map<String,Object> map,String key){
        return Long.valueOf(String.valueOf(map.get(key)));
    }

    public static void sbAppend(StringBuilder sb,String value){
        sbAppend(sb,value,true);
    }

    public static void sbAppend(StringBuilder sb,String value,boolean flag){
        sb.append("'");
        sb.append(value);
        sb.append("'");
        if(flag){
            sb.append(",");
        }
    }
}
