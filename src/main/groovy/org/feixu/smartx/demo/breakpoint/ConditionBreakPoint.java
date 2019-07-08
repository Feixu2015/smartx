/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.demo.breakpoint;

/**
 * @author Feixu
 * @version $Id: ConditionBreakPoint.java, v 0.1 2018/8/29 Feixu Exp $$
 */
public class ConditionBreakPoint {
    public static void main(String[] args) {
        String[] array = new String[] { "a", "b", "c" };
        for (String str :
                array) {
            System.out.println(str);
        }
    }
}
