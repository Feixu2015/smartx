/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.validate

import org.hibernate.validator.constraints.NotBlank

/**
 *
 * @author Feixu
 * @version $Id: God.java, v 0.1 2017/12/8 Feixu Exp $$
 */
class God {
    @NotBlank(message = "不能为空")
    private String name

    @Override
    String toString() {
        return "name:" + name
    }
}
