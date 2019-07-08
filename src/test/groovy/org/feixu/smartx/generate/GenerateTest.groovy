/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.generate

import org.junit.Test

/**
 *
 *
 * @author Feixu
 * @version $Id: GenerateTest.java, v 0.1 2018/4/26 Feixu Exp $
 */
class GenerateTest {
    @Test
    void toEnum(){
        println "/** TODO */"
        """draft 草稿
pending_approval 待审核
rejected 未通过
deleted 已删除
discarded 已废弃
pending_implemention 待实施
implementing 实施中
succeed 已成功
failed 已失败""".eachLine {
            if (it) {
                def code = it.split(" ")[0]
                def desc = it.split(" ")[1]
                println "${code.toUpperCase()}(\"${code.toUpperCase()}\", \"${desc}\"),"
            }
        }
        println ";"
    }
}
