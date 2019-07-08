package org.feixu.smartx.flow

import org.junit.Test
/**
 * @author Feixu
 * @version $Id: StatusEngineOldTest.java, v 0.1 2018/4/27 Feixu Exp $
 */
class StatusEngineOldTest {
    @Test
    void generateFlowMd() throws Exception {
        StatusEngineNew.generateFlowMd()
    }

    @Test
    void iterOperationPreStatus(){
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

    @Test
    void status2Form() {
        """草稿 draft
待审核 pending_approval
未通过 rejected
已删除 deleted
已废弃 discarded
待实施 pending_implemention
实施中 implementing
已成功 succeed
已失败 failed""".eachLine {
            if (it) {
                println "| ${it} | "
            }
        }
    }
}