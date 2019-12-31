
import java.util.*;

public class TestLin {
    public static void main(String[] args) throws Exception{
        for (String arg:args) {
            System.out.println(arg);
        }
    }
    public static final int getYYYYMMDD() throws Exception {
        Calendar cal = Calendar.getInstance();
        return cal.get(1) * 10000 + (cal.get(2) + 1) * 100 + cal.get(5);
    }


    public static void parseUserStr(Map<String,Object> userInfo,String userStr) throws Exception{
        String[] userInfoArray = userStr.split("\\$");
        userInfo.put("SUBSCRIBER_ID", userInfoArray[0]);
        userInfo.put("SUBSCRIBER_INS_ID", userInfoArray[0]);
        userInfo.put("CUST_NAME", userInfoArray[1]);
        userInfo.put("CUST_CODE", userInfoArray[2]);
        userInfo.put("CUSTOMER_CODE", userInfoArray[2]);
        userInfo.put("ACCT_ID", userInfoArray[3]);
        userInfo.put("ACCESS_NO", userInfoArray[4]);
        userInfo.put("ACCESS_NUM", userInfoArray[4]);
        userInfo.put("CUST_ID", userInfoArray[5]);
        userInfo.put("REGION_ID", userInfoArray[6]);
        //用户开机状态 0-开机 2-停机 3-未知
        userInfo.put("PROD_STATUS", userInfoArray[7]);
        //由于预付费用户的三户资料除了号码其他信息均为虚拟门店，而虚拟门店的三户信息又会每月重新生成，所以此处注入预付费用户标志，查询汇总账单时根据手机号码查询。
        if(userInfoArray.length>8){
            userInfo.put("PREPAY_USER_FLAG", userInfoArray[8]);
        }
    }


    public static String maskName(String name){
        if(null!=name && !"".equals(name.trim())){
            String nameNoTrim = name.trim();
            String[] nameArray = nameNoTrim.split(" ");
            StringBuffer sb = new StringBuffer();
            if(nameArray.length>1){
                for (String n:nameArray) {
                    if("".equals(n.trim())){
                        continue;
                    }
                    sb.append(n.charAt(0));
                    sb.append("*** ");
                }
                return sb.toString();
            }else{
                return name.charAt(0)+"***";
            }
        }else{
            return "";
        }
    }
}
