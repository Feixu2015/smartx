/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.sql

import org.junit.Test

/**
 *
 *
 * @author Feixu
 * @version $Id: DoGeneratorTest.java, v 0.1 2018/4/29 Feixu Exp $
 */
class DoGeneratorTest {

    @Test
    void VoGenerator(){
        // 字段名,字段描述
        """srvCode,服务项编码
srvName,服务项名称
title,工单标题
orderNo,工单号
createUser,申请人
approvalUser,审核人
status,工单状态
start,申请时间
end,完成时间
timeUsed,耗时（秒）""".eachLine {
            if(it){
                def values = it.split(",")
                def name = values[0]
                def desc = values[1]
                println "/** ${desc} */\nprivate Integer ${name};\n"
            }
        }
    }
}
