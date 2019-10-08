import com.sun.xml.internal.ws.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/3 19:48
 * @Modified By:
 **/
public class LockDataRule implements Serializable {
    private static final long serialVersionUID = -7823334038315505145L;
    String[][] keyNames = (String[][])null;
    String[][][] srcKeys = (String[][][])null;

    protected LockDataRule(String rules) {
        if (null!=rules && !"".equals(rules)) {
            String[] ruleArr = rules.split(";");
            int ruleCount = ruleArr.length;
            this.keyNames = new String[ruleCount][];
            this.srcKeys = new String[ruleCount][][];

            for(int i = 0; i < ruleCount; ++i) {
                String rule = ruleArr[i];
                String[] arr = rule.split("&&");
                int keyCount = arr.length;
                this.keyNames[i] = new String[keyCount];
                this.srcKeys[i] = new String[keyCount][];

                for(int j = 0; j < keyCount; ++j) {
                    String s = arr[j];
                    String[] perArr = s.split(":");
                    if (perArr.length == 2) {
                        this.keyNames[i][j] = perArr[0];
                        this.srcKeys[i][j] = perArr[1].split("\\|");
                    }
                }
            }

        }
    }

    protected String[] getLockNames(Map<?, ?> d) {
        int ruleCount = this.keyNames.length;
        Set<String> lockNames = new HashSet();

        label37:
        for(int i = 0; i < ruleCount; ++i) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < this.keyNames[i].length; ++j) {
                sb.append(this.keyNames[i][j]);
                String[] valueSrc = this.srcKeys[i][j];

                int k;
                for(k = 0; k < valueSrc.length; ++k) {
                    if (d.containsKey(valueSrc[k])) {
                        sb.append((String)d.get(valueSrc[k]));
                        break;
                    }
                }

                if (k == valueSrc.length) {
                    System.out.println(new Object[]{"未完成锁:", sb});
                    continue label37;
                }
            }

            lockNames.add(sb.toString());
        }

        return (String[])lockNames.toArray(new String[0]);
    }

    public static void main(String[] args) {
        LockDataRule ld = new LockDataRule("ACCT_ID:ACCT_ID");

        Map<String,LockDataRule> map = new HashMap<>();
        map.put("asset_IPaymentCSV_asyncPayment",ld);

        System.out.println(ld.getLockNames(map));
    }
}
