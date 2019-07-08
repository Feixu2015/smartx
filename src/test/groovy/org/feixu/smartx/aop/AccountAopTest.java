package org.feixu.smartx.aop;

import org.junit.Test;

/**
 * @author Feixu
 * @version $Id: AccountAopTest.java, v 0.1 2018/7/10 Feixu Exp $
 */
public class AccountAopTest {
    @Test
    public void withdraw() throws Exception {
        AccountAop accountAop = new AccountAop();
        accountAop.withdraw(5);
    }

}