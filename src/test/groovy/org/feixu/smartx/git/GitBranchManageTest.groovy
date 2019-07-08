package org.feixu.smartx.git;

import org.junit.Test;

/**
 * @author Feixu
 * @version $Id: GitBranchManageTest.java, v 0.1 2018/3/20 Feixu Exp $
 */
class GitBranchManageTest {
    @Test
    public void generateDeleteBranch() throws Exception {
        def branchLines = """release/1.8.0
  release/1.8.1
  release/1.8.2
  release/1.9.0
  release/1.9.1
  release/1.9.2
  release/1.9.3
  release/1.9.4
  release/2.0.0
  release/2.1.1
  release/2.2.0
  release/2.2.1
  release/2.2.2
  release/2.3.0
  release/2.4
"""
        GitBranchManage.generateDeleteBranch(branchLines);
    }

    @Test
    void filterWhatIDone(){
        def logs = """Merge branch 'enhancement/95' into 'release/2.1.1' 毕敏立 2018/6/24 下午10:20 
【优化】查询工单审核信息，导出工单审核信息 swagger的page,limit字段增加默认值提示 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/95 毕敏立 2018/6/24 下午10:18 
Merge branch 'bug/94' into 'release/2.1.1' 毕敏立 2018/6/24 下午10:07 
【Bug】GET /catalog/inst/approvalinfo 去掉无效参数ids http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/94 毕敏立 2018/6/24 下午10:05 
Merge branch 'bug/91' into 'release/2.1.1' 毕敏立 2018/6/24 下午9:28 
【优化】修改服务目录分类树信息orderNum不能为负数 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/91 毕敏立 2018/6/24 下午9:26 
Merge branch 'bug/90' into 'release/2.1.1' 毕敏立 2018/6/24 下午8:58 
【优化】创建服务目录显示顺序不能为负数 POST /catalog/categoryTree/create http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/90 毕敏立 2018/6/24 下午8:55 
Merge branch 'enhancement/85' into 'release/2.1.1' 毕敏立 2018/6/24 下午7:32 
【优化】/catalog/v2/inst/todo/{num} 查询待办限制数量最大为20 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/85 毕敏立 2018/6/24 下午7:31 
Merge branch 'enhancement/83' into 'release/2.1.1' 毕敏立 2018/6/22 下午4:08 
【优化】接口废弃 POST /catalog/inst/srvinst 查询服务实例通用属性列表 GET /catalog/inst/srvinst/{srvid} 根据id查询服务实例通用属性 POST /catalog/srv/ 创建服务项 PUT /catalog/srv/{srvid}/base 修改服务项基本信息 GET /catalog/inst/executes/day 查询某天已执行或待执行的定时任务服务实例列表 GET /catalog/inst/statuslist/run 查询所有服务项实例运行状态枚举列表 待确认该接口是干什么的没有返回有用信息 GET /catalog/inst/run/status 查询服务项实例运行状态 http://gitlab.idcos.com:8082/IDCOS/hf-srv-catalog/issues/83 毕敏立 2018/6/22 下午4:01 """
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