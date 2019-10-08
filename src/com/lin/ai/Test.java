package com.lin.ai;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/23 21:47
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) {
        LockRule lockRule = new LockRule("ACCT_ID:ACCT_ID&&USER_ID:USER_ID|SUBSCRIBER_ID;ACCT_ID:ATTACH_ACCT_ID");
        lockRule.printKeyNames();
        lockRule.printSrcKeys();
    }
}
