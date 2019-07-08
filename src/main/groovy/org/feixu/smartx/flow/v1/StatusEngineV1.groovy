/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.flow.v1

import java.text.Collator

/**
 * 状态引擎
 *
 * @author Feixu
 * @version $Id: StatusEngineOld.java, v 0.1 2018/4/26 Feixu Exp $
 */
class StatusEngineV1 {
    static void generateFlowMd(){
        def curDate = new Date().format("yyyyMMddHHmmss")
        def strBuilder = new StringBuilder()
        strBuilder.append "${curDate}\n"
        strBuilder.append '```mermaid\n'
        strBuilder.append 'graph TB;\n'
        def paths = [:]
        run(StatusEnum.START, paths)
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA)
        def order = [StatusEnum.START, StatusEnum.DRAFT, StatusEnum.DELETED, StatusEnum.PENDING_APPROVAL, StatusEnum.PENDING_IMPLEMENTION, StatusEnum.REJECTED, StatusEnum.DISCARDED, StatusEnum.IMPLEMENTING, StatusEnum.SUCCEED, StatusEnum.FAILED]
        def codeOrder = []
        order.each {
            codeOrder << it.desc
        }
        paths.sort{a,b->
            int indexA = codeOrder.indexOf(a.value)
            int indexB = codeOrder.indexOf(b.value)
            //println "compare: ${a.value} -> ${b.value} ${indexA} -> ${indexB}"
            return indexA <=> indexB
        }.each {
            strBuilder.append "${it.key}\n"
        }
        strBuilder.append '```'

        // 打印
        println strBuilder.toString()

        // 写文件
        /*new File("flow_${curDate}.md").withWriter {
            it.write(strBuilder.toString())
        }*/
    }

    static void run(StatusEnum status, Map<String, String> paths) {
        if (null != status && null != status.actions) {
            for(String it : status.actions) {
                def path = null
                def action = OperationTypeEnum.getByCode(it)
                if (!action?.resultStatus) {
                    path = "${status.desc}-->${action.code};".toString()
                    if (!paths.containsKey(path)) {
                        paths.put(path, status.desc)
                    }
                } else {
                    for(String result : action.resultStatus) {
                        StatusEnum resultStatus = StatusEnum.getByCode(result)
                        path = "${status.desc}--${action.desc}${action.code.toLowerCase()}-->${resultStatus.desc};".toString()
                        if (!paths.containsKey(path)) {
                            paths.put(path, status.desc)
                            if (status.code != it) {
                                run(resultStatus, paths)
                            }
                        }
                    }
                }
            }
        }
    }

    static void iterOperationPreStatus(){
        def map = [:]
        OperationTypeEnum.values().each {
            map.put(it, new ArrayList<StatusEnum>())
        }

        StatusEnum.values().each { status ->
            if (status.actions) {
                status.actions.each {
                    def action = OperationTypeEnum.getByCode(it)
                    if(!map.get(action).contains(status)) {
                        map.get(action) << status
                    }
                }
            }
        }
        /*def json = new JsonBuilder(map)
        println json.toPrettyString()*/
        map.entrySet().each {
            def key = it.key
            def value = it.value
            def result = []
            it.value.each{
                result << "${it.desc} ${it.code.toLowerCase()}"
            }
            println "${key.desc} ${key.code.toLowerCase()} : ${result.join('、 ')}"
        }
    }

    class PrePosStatus {
        String preStatus
        String postStatus
    }
}
