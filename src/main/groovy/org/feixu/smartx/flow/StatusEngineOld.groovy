/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.flow

import java.text.Collator

/**
 * 状态引擎
 *
 * @author Feixu
 * @version $Id: StatusEngineOld.java, v 0.1 2018/4/26 Feixu Exp $
 */
class StatusEngineOld {
    static void generateFlowMd(){
        def curDate = new Date().format("yyyyMMddHHmmss")
        def strBuilder = new StringBuilder()
        strBuilder.append "${curDate}\n"
        strBuilder.append '```mermaid\n'
        strBuilder.append 'graph TB;\n'
        def paths = new ArrayList()
        run(StatusEnum.START, paths)
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA)
        paths.sort{a,b-> cmp.compare(a, b)}.each {
            strBuilder.append "${it}\n"
        }
        strBuilder.append '```'

        // 打印
        println strBuilder.toString()

        // 写文件
        /*new File("flow_${curDate}.md").withWriter {
            it.write(strBuilder.toString())
        }*/
    }

    static void run(StatusEnum status, List paths) {
        if (null != status && null != status.actions) {
            for(String it : status.actions) {
                def path = null
                def action = OperationTypeEnum.getByCode(it)
                if (!action?.resultStatus) {
                    path = "${status.desc}-->${action.code};"
                    if (!paths.contains(path)) {
                        paths.add(path)
                    }
                } else {
                    for(String result : action.resultStatus) {
                        StatusEnum resultStatus = StatusEnum.getByCode(result)
                        path = "${status.desc}--${action.desc}${action.code.toLowerCase()}-->${resultStatus.desc};"
                        if (!paths.contains(path)) {
                            paths.add(path)
                            if (status.code != it) {
                                run(resultStatus, paths)
                            }
                        }
                    }
                }
            }
        }
    }
}
