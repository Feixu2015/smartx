/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.aop

/**
 *
 *
 * @author Feixu
 * @version $Id: AccountAop.java, v 0.1 2018/7/5 Feixu Exp $
 */
class AccountAop {
    int balance = 20

    boolean withdraw(int amount) {
        if(balance < amount) {
            return false
        } else {
            balance = balance - amount
            return true
        }
    }
}
