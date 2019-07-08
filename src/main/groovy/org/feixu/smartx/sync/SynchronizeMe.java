/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.sync;

/**
 * @author Feixu
 * @version $Id: SynchronizeMe.java, v 0.1 2017/11/6 Feixu Exp $$
 */
public class SynchronizeMe {
    private static String NEXT_CODE = null;

    public static synchronized String getNextCode() {
        if (null == NEXT_CODE) {
            NEXT_CODE = "0001";
        } else {
            Integer curCode = Integer.parseInt(NEXT_CODE);
            NEXT_CODE = String.format("%04d", curCode + 1);
        }
        return NEXT_CODE;
    }
}
