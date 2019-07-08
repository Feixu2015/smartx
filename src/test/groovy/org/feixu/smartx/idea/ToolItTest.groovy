/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.idea

import org.junit.Test

/**
 *
 *
 * @author Feixu
 * @version $Id: ToolItTest.java, v 0.1 2018/4/22 Feixu Exp $
 */
class ToolItTest {
    @Test
    void logGet(){
        def logs = """【Changelog】增加1.8.2changelog 毕敏立 2018/5/25 上午11:54 
【优化】创建or更新服务项信息时，form的wfType字段转为大写 毕敏立 2018/5/25 上午11:50 
【Bug】增加taskResult、taskResultSchema字段后查询sql字段错误 毕敏立 2018/5/24 下午5:32 
【Changelog】release/1.9.2 毕敏立 2018/5/24 上午10:42 
Merge branch 'feature/71' into 'release/1.9.2' 毕敏立 2018/5/24 上午12:17 
【需求】增加根据工单号查询工单id,根据工单号批量查询工单状态和任务执行结果 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/71 毕敏立 2018/5/24 上午12:13 
Merge branch 'bug/75' into 'release/2.0.0' 毕敏立 2018/5/23 下午10:03 
【Bug】Srv后台报：查询流程实例状态失败，未查询到用户信息,请确定是否已登录! 原因： 定时轮询的租户id不能通过uam的AuthorService获取应用默认租户ID（default) http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/75 毕敏立 2018/5/23 下午10:01 
Merge branch 'bug/74' into 'release/1.9.2' 毕敏立 2018/5/23 下午2:51 
【Bug】服务目录编排创建目录的接口API改为Conf的时，由于API未存CreateUserId导致不能立即回显 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/74 毕敏立 2018/5/23 下午2:48 
Merge branch 'bug/73' into 'release/1.9.2' 毕敏立 2018/5/23 下午12:17 
【Bug】从第三方创建创建工单API，后台日志提示srvNo不能为null http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/73 毕敏立 2018/5/23 下午12:14 
Merge branch 'bug/72' into 'release/1.9.2' 毕敏立 2018/5/23 上午11:15 
【Bug】工单申请报String Format '%s'错误 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/72 毕敏立 2018/5/23 上午11:12 
【需求】调整 查询、导出工单审批记录支持根据id多选 cherry-pick from 1.9.2 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/71 http://gitlab.idcos.com:8082/CloudConf/cloud-davinci/issues/936 毕敏立 2018/5/21 下午2:22 
Merge branch 'feature/71' into 'release/1.9.2' 毕敏立 2018/5/21 下午9:11 
【Sql变更】Conf 文件下发、网络设备ActionCode再次修改 毕敏立 2018/5/21 下午7:33 
【需求】调整 查询、导出工单审批记录支持根据id多选 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/71 http://gitlab.idcos.com:8082/CloudConf/cloud-davinci/issues/936 毕敏立 2018/5/21 下午2:22 """
        logs.eachLine {
            if(it && !it.startsWith('Merge')){
                def tmp = it
                def index = it.indexOf('毕敏立')
                if (-1 != index) {
                    tmp = it.substring(0, index - 1)
                }
                println tmp
            }
        }
    }
}
