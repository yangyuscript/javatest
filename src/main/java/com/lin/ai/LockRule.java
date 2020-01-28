package com.lin.ai;


import java.util.Arrays;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/23 21:45
 * @Modified By:
 **/
public class LockRule {
    private String[][] keyNames = (String[][])null;
    private String[][][] srcKeys = (String[][][])null;

    public LockRule(String rules) {
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

    public void printKeyNames(){
        System.out.println(Arrays.deepToString(keyNames));
    }

    public void printSrcKeys(){
        System.out.println(Arrays.deepToString(srcKeys));
    }
}
