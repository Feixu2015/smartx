/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.swing

import java.awt.MouseInfo

/**
 *
 * @author Feixu
 * @version $Id: MockClickAndRun.java, v 0.1 2018/4/21 Feixu Exp $$
 */
class MockClickAndRun {
    public static void main(String[] args) throws InterruptedException{
        while(true){
            //Thread.sleep(100);
            System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +
                    ", " +
                    MouseInfo.getPointerInfo().getLocation().y + ")");
        }
    }
}
