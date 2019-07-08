package org.feixu.smartx.json

import com.alibaba.fastjson.JSONObject
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import org.junit.Test

/**
 * @author Feixu
 * @version $Id: JsonUtilTest.java, v 0.1 2018/3/12 Feixu Exp $
 */
public class JsonUtilTest {

    private static final String jsonTextInner = """{
            "status": "success",
            "message": "处理成功",
            "item": {
        "id": "b8e2ce64-ae16-4c29-a886-f0797ad37891",
                "tenantId": "egfbank",
                "srvCatalogHirId": "4456b272-efaf-44e2-99cf-c56a6daa640f",
                "catalogId": "4456b272-efaf-44e2-99cf-c56a6daa640f",
                "catalogName": "场景测试",
                "code": "b8e2ce64-ae16-4c29-a886-f0797ad37891",
                "cname": "根据应用节点过滤主机",
                "ctype": null,
                "description": null,
                "supportDept": null,
                "sla": "中",
                "wfType": "JOB",
                "wfTemplateId": "ba20a663-49be-433c-8140-05ca5a645fd0",
                "wfTemplateName": "查看当前主机编码",
                "wfInputParams": null,
                "wfOutputParams": null,
                "wfOutputParamsUi": null,
                "srvInputParams": "{\\"jobParams\\":{\\"jobParams\\":{\\"values\\":{}},\\"id\\":\\"a506cfa1-7fc8-421f-980d-78afe0478816\\",\\"jobCode\\":\\"ba20a663-49be-433c-8140-05ca5a645fd0\\",\\"jobName\\":\\"查看当前主机编码\\",\\"type\\":\\"operation-job\\",\\"values\\":{}},\\"id\\":\\"a506cfa1-7fc8-421f-980d-78afe0478816\\",\\"jobCode\\":\\"ba20a663-49be-433c-8140-05ca5a645fd0\\",\\"jobName\\":\\"查看当前主机编码\\",\\"type\\":\\"operation-job\\"}",
                "srvInputParamsUi": "{\\"iframeURL\\":\\"conf-service-job\\"}",
                "inputParamsMapping": null,
                "ifApproval": false,
                "startImmediate": "N",
                "approvalMethod": "DEFAULT",
                "approvalRoleId": null,
                "ifDoubleCheck": "N",
                "doubleCheckUserGroupId": null,
                "ifDependence": null,
                "remark": null,
                "needDoubleCheck": false,
                "status": "RELEASED"
    }
}"""

    @Test
    void json2SwaggerYaml() {
        def sluper = new JsonSlurper()
        def response = sluper.parseText(jsonTextInner)
        response.item.each { key, value ->
            println """$key:
  type: "${null == value ? "string" : value.class.simpleName }"
  default: """ + String.format("\"%s\"", (null == value ? null : value.toString()))
        }
    }

    @Test
    void jsonToObj(){
        def json = new JsonSlurper().parseText("""
{
  "accept": "application/json",
  "action": "POST",
  "body": "{\\"biz\\":{\\"deviceType\\":\\"host\\",\\"deviceIds\\":[\\"5fbfd163-0975-4d29-989c-b3f497236598\\"],\\"hosts\\":[{\\"source\\":\\"excel\\",\\"operatingSystem\\":\\"CentOS-7.4.1708-x86_64\\",\\"hostname\\":\\"主机设备128\\",\\"netIp\\":\\"10.0.3.128\\",\\"id\\":\\"5fbfd163-0975-4d29-989c-b3f497236598\\",\\"apps\\":[],\\"entityId\\":\\"8c971b82-2778-4c3a-b4fa-f9fd1178a4d0\\",\\"encoding\\":\\"UTF-8\\",\\"version\\":\\"20180813144049.2072\\",\\"tags\\":[],\\"macAddress\\":\\"02:42:ac:19:0a:19\\",\\"site\\":\\"hangzhou\\",\\"createTime\\":\\"2018-08-13 14:40:50\\",\\"tenantId\\":\\"default\\",\\"name\\":\\"主机设备128\\",\\"online\\":\\"1\\",\\"lastUpdateTime\\":\\"2018-08-13 14:40:50\\",\\"status\\":\\"0\\"}],\\"innerParams\\":{\\"password\\":\\"55D6BFF217521ABE\\",\\"empty_password\\":false,\\"shell\\":\\"/bin/bash\\",\\"name\\":\\"ceshi\\",\\"groups\\":[\\"ceshi\\"],\\"home\\":\\"/user/ceshi\\"},\\"userId\\":\\"59df5960cd6ac35f53135b31\\"},\\"extra\\":{},\\"orderName\\":\\"测试添加账户\\",\\"orderNo\\":\\"1808151416489993\\",\\"origin\\":\\"CLOUDSRV\\",\\"provider\\":{\\"code\\":\\"ADD_USER\\",\\"executionUserId\\":\\"59df5960cd6ac35f53135b31\\",\\"executionUserName\\":\\"管理员\\",\\"type\\":\\"INNERCONF\\"},\\"scheduler\\":{\\"executeTime\\":\\"2018-08-15 14:16:46\\",\\"type\\":\\"INSTANT\\"},\\"source\\":\\"CLOUDSRV\\",\\"traceId\\":\\"afb0d0d1-e5d4-42d4-afb8-338660df33c6\\"}",
  "pathParams": {},
  "queryParams": {},
  "readTimeOut": 30000,
  "resultType": "java.lang.String",
  "token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLnrqHnkIblkZgiLCJ1c2VySWQiOiI1OWRmNTk2MGNkNmFjMzVmNTMxMzViMzEiLCJuYW1lIjoi566h55CG5ZGYIiwibG9naW5JZCI6ImFkbWluIiwibG9naW5OYW1lIjoiYWRtaW4iLCJ0ZW5hbnRJZCI6ImRlZmF1bHQiLCJ0aW1lb3V0IjoyMTYwMCwiZXhwIjoyMTM3OTkzMjAwLCJjcmVhdFRpbWUiOjE1MjU3MDY2NDUxODgsInRlbmFudE5hbWUiOiLnrqHnkIbnp5_miLcifQ.enM9Fk3CX17k2QgOW7-Cw1C8gDYvT8GjNQFO9_jjc3w",
  "url": "http://cloud.davinci.conf.idcos.net:9080/o/conf/v3/schedule/execute"
}
""")
        println JSONObject.toJSONString(JSONObject.parse(json.body), true)
    }

    /**
     * opGroup to json
     */
    @Test
    void test123() {

        def abc = '''<a><OptGroup label='通用服务项'>
        {/*虚拟机相关*/}
        <Option value='CommonCreateVm'>
          <Tooltip title='路径:common/virtual-machine/create-vm'>通用-虚机创建</Tooltip>
        </Option>
        <Option value='DestroyVm'>
          <Tooltip title='路径:common/virtual-machine/destroy-vm'>虚拟机销毁</Tooltip>
        </Option>
        <Option value='EditVmManager'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-manager'>修改虚拟机运维负责人</Tooltip>
        </Option>
        <Option value='EditVmOwner'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-owner'>修改虚拟机负责人</Tooltip>
        </Option>
        <Option value='EditVmPeriod'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-period'>虚拟机使用期限续期</Tooltip>
        </Option>
        <Option value='EditVmProject'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-project'>修改虚拟机所属项目</Tooltip>
        </Option>
        <Option value='EditVmUsage'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-usage'>修改虚拟机用途</Tooltip>
        </Option>
        <Option value='RestartVm'>
          <Tooltip title='路径:common/virtual-machine/restart-vm'>虚拟机重启</Tooltip>
        </Option>
        <Option value='StartVm'>
          <Tooltip title='路径:common/virtual-machine/start-vm'>虚拟机开机</Tooltip>
        </Option>
        <Option value='StopVm'>
          <Tooltip title='路径:common/virtual-machine/stop-vm'>虚拟机关机</Tooltip>
        </Option>
        <Option value='VmAddDisk'>
          <Tooltip title='路径:common/virtual-machine/vm-reconfig-disk'>虚拟机新增硬盘</Tooltip>
        </Option>
        <Option value='VmReconfig'>
          <Tooltip title='路径:common/virtual-machine/vm-reconfig'>虚拟机规格扩容（new)</Tooltip>
        </Option>
        <Option value='VmReconfigDisk'>
          <Tooltip title='路径:common/virtual-machine/vm-reconfig-disk'>虚拟机硬盘扩容</Tooltip>
        </Option>
        <Option value='VmSpecUpgrade'>
          <Tooltip title='路径:common/virtual-machine/vm-spec-upgrade'>虚拟机规格扩容</Tooltip>
        </Option>
        <Option value='QuickBackupVm'>
          <Tooltip title='路径:common/virtual-machine/backup-vm'>虚拟机快速备份</Tooltip>
        </Option>
        <Option value='RestoreVm'>
          <Tooltip title='路径:common/virtual-machine/restore-vm'>虚拟机备份点恢复</Tooltip>
        </Option>
        <Option value='EditVmBackupStrategy'>
          <Tooltip title='路径:common/virtual-machine/edit-vm-backup-strategy'>修改虚拟机备份策略</Tooltip>
        </Option>
        {/*标签管理*/}
        <Option value='AddTags'>
          <Tooltip title='路径:common/tag-manage/add-tags'>添加标签</Tooltip>
        </Option>
        <Option value='DeleteTags'>
          <Tooltip title='路径:common/tag-manage/delele-tags'>删除标签</Tooltip>
        </Option>
        {/*小型机*/}
        <Option value='EditMcOwner'>
          <Tooltip title='路径:common/mini-computer/edit-mc-owner'>修改小型机负责人</Tooltip>
        </Option>
        <Option value='EditMcUsage'>
          <Tooltip title='路径:common/mini-computer/edit-mc-usage'>修改小型机用途</Tooltip>
        </Option>
        <Option value='EditMcProject'>
          <Tooltip title='路径:common/mini-computer/edit-mc-project'>修改小型机所属项目</Tooltip>
        </Option>
        {/*f5*/}
        <Option value='ApplyVs'>
          <Tooltip title='路径:common/f5/apply-vs'>申请virtualServer</Tooltip>
        </Option>

        {/*物理机*/}
        <Option value='CommonApplyPm'>
          <Tooltip title='路径:common/physical-machine/apply-pm'>通用-申请物理机</Tooltip>
        </Option>
        <Option value='EditPmIp'>
          <Tooltip title='路径:common/physical-machine/edit-pm-ip'>修改物理机IP</Tooltip>
        </Option>
        <Option value='EditPmMgtCardInfo'>
          <Tooltip title='路径:common/physical-machine/edit-pm-mgt-card-info'>修改物理机带外卡信息</Tooltip>
        </Option>
        <Option value='StartPm'>
          <Tooltip title='路径:common/physical-machine/start-pm'>物理机开机</Tooltip>
        </Option>
        <Option value='StopPm'>
          <Tooltip title='路径:common/physical-machine/stop-pm'>物理机关机</Tooltip>
        </Option>
        <Option value='RestartPm'>
          <Tooltip title='路径:common/physical-machine/restart-pm'>物理机重启</Tooltip>
        </Option>
        <Option value='OfflinePm'>
          <Tooltip title='路径:common/physical-machine/offline-pm'>物理机下线</Tooltip>
        </Option>
        <Option value='EditPmProject'>
          <Tooltip title='路径:common/physical-machine/edit-pm-project'>修改物理机所属项目</Tooltip>
        </Option>
        <Option value='EditPmUsage'>
          <Tooltip title='路径:common/physical-machine/edit-pm-usage'>修改物理机用途</Tooltip>
        </Option>
        <Option value='EditPmOwner'>
          <Tooltip title='路径:common/physical-machine/edit-pm-owner'>修改物理机负责人</Tooltip>
        </Option>
        <Option value='EditPmOS'>
          <Tooltip title='路径:common/physical-machine/edit-pm-os'>修改物理机操作系统</Tooltip>
        </Option>
        <Option value='EditStockPmOwner'>
          <Tooltip title='路径:common/physical-machine/edit-stock-pm-owner'>修改库存物理机业务负责人</Tooltip>
        </Option>
        <Option value='EditPmLocation'>
          <Tooltip title='路径:common/physical-machine/edit-pm-location'>修改物理机位置</Tooltip>
        </Option>
      </OptGroup>,

      <OptGroup label='广发自定义服务项'>
        <Option value='Test1'>
          <Tooltip title='路径:gf/virtual-machine/test1'>广发自定义虚拟机申请页面</Tooltip>
        </Option>
        <Option value='CreateVm'>
          <Tooltip title='路径:gf/virtual-machine/create-vm'>广发自定义虚拟机申请页面(新)</Tooltip>
        </Option>
        <Option value='ApplyPm'>
          <Tooltip title='路径:gf/physical-machine/apply-pm'>广发申请物理机页面</Tooltip>
        </Option>
        <Option value='BatchApplyPm'>
          <Tooltip title='路径:gf/physical-machine/batch-apply-pm'>广发批量申请物理机页面</Tooltip>
        </Option>
      </OptGroup>,

      <OptGroup label='浙商自定义服务项'>
        <Option value='ZsCreateVm'>
          <Tooltip title='路径:czbank/create-vm'>浙商自定义虚拟机申请页面</Tooltip>
        </Option>
        <Option value='ZsCloneVm'>
          <Tooltip title='路径:czbank/clone-vm'>浙商自定义虚拟机克隆申请页面</Tooltip>
        </Option>
      </OptGroup>,

      <OptGroup label='农行自定义服务项'>
        <Option value='PoolOpenStackLinux'>
          <Tooltip title='路径:abc/catalog-linux'>虚拟机供给</Tooltip>
        </Option>
        <Option value='PoolWin'>
          <Tooltip title='路径:abc/catalog-win'>WINDOWS加域供给</Tooltip>
        </Option>
        <Option value='PoolOracle'>
          <Tooltip title='路径:abc/catalog-oracle'>Oracle单机供给</Tooltip>
        </Option>
        <Option value='PoolLinuxWas'>
          <Tooltip title='路径:abc/catalog-linux-was'>WAS集群供给</Tooltip>
        </Option>
        <Option value='PoolOpenStackLinuxProduction'>
          <Tooltip title='路径:abc/catalog-linux-production'>虚拟机供给-生产</Tooltip>
        </Option>
        <Option value='PoolOracleProduction'>
          <Tooltip title='路径:abc/catalog-oracle-production'>Oracle单机供给-生产</Tooltip>
        </Option>
        <Option value='PoolLinuxWasProduction'>
          <Tooltip title='路径:abc/catalog-linux-was-production'>WAS集群供给-生产</Tooltip>
        </Option>
      </OptGroup>,

      <OptGroup label='华夏自定义服务项'>
        <Option value='HxbCreateVm'>
          <Tooltip title='路径:hxb/create-vm'>华夏自定义虚拟机申请页面</Tooltip>
        </Option>
        <Option value='HxbBranchesCreateVm'>
          <Tooltip title='路径:hxb/branches-create-vm'>华夏分行自定义虚拟机申请页面</Tooltip>
        </Option>
      </OptGroup>,

      <OptGroup label='公有云通用服务项'>
        <Option value='PublicCloud'>
          <Tooltip title='路径:public-cloud/aliyun-qcloud'>公有云通用申请页面</Tooltip>
        </Option>
        <Option value='HuaWeiPublicCloud'>
          <Tooltip title='路径:public-cloud/huawei'>公有云通用申请页面（华为公有云）</Tooltip>
        </Option>
        <Option value='AzurePublicCloud'>
          <Tooltip title='路径:public-cloud/azure'>公有云通用申请页面（Azure）</Tooltip>
        </Option>
      </OptGroup>
</a>'''

        def response = new XmlSlurper().parseText(abc)
        '''{
    // OptGroup分组名
    group: '华夏云服务套餐自定义页面',
    // Option单个Select选项
    options: [
      {
        // 页面code
        code: 'HxbCreateVm',
        name: '华夏云服务套餐页面',
        description: `${baseDesc}hxb/create-vm`,
        // 是否可以设置约束json
        hasContract: true
      }
    ]
  }'''
        def opGroups = []
        response.OptGroup.each {
            def group = [ group: it['@label'].toString(), options: [] ]
            opGroups << group
            it.Option.each{ it
                group.options << [
                        code : it.@value.toString(),
                        name : it.Tooltip.toString(),
                        description: it.Tooltip.@title.toString(),
                        hasContract: false
                ]
            }
        }

        def json = new JsonBuilder(opGroups)
        println StringEscapeUtils.unescapeJavaScript(
                json.toPrettyString()
                        .replace("\"","'")
                        .replace("\'group\'", "group")
                        .replace("\'options\'", "options")
                        .replace("\'code\'", "code")
                        .replace("\'name\'", "name")
                        .replace("\'description\'", "description")
                        .replace("\'hasContract\'", "hasContract")
        )
    }
}