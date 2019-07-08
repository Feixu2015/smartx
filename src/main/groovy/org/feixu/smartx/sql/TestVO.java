/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.sql;

/**
 * @author Feixu
 * @version $Id: TestVO.java, v 0.1 2018/6/3 Feixu Exp $
 */
public class TestVO {
    private String reeditable;

    public Boolean getReeditable() {
        return "Y".equalsIgnoreCase(reeditable);
    }

    public void setReeditable(String reeditable) {
        this.reeditable = reeditable;
    }
}
