/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.doc

import org.junit.Test

/**
 *
 * @author Feixu
 * @version $Id: swaggerGenerator.java, v 0.1 2018/2/8 Feixu Exp $$
 */
class swaggerGenerator {

    private data = """License相关的接口 : Conf App License Controller Show/Hide List Operations Expand Operations
POST /conf/v2/app/license 保存license信息
GET /conf/v2/app/license/ 解析license信息
SSO接口 : 提供认证和当前用户的rest接口。 Show/Hide List Operations Expand Operations
GET /conf/v2/authenticator/auth 对Token进行认证的接口
GET /conf/v2/authenticator/sso 获取sso业务信息
st2服务相关 : Conf St 2 Server Controller Show/Hide List Operations Expand Operations
POST /conf/v2/st2 新增一个st2的服务器
GET /conf/v2/st2/ 获取所有的st2的服务器列表
POST /conf/v2/st2/test 测试st2服务器是否有效
DELETE /conf/v2/st2/{id} 删除st2服务器信息
PUT /conf/v2/st2/{id} 更新st2服务器信息
主机属性相关的接口 : Conf Host Attr Controller Show/Hide List Operations Expand Operations
POST /conf/v2/host/attr/add 新增主机属性
GET /conf/v2/host/attr/all 查询所有的应用模块列表
DELETE /conf/v2/host/attr/delete/{id} 删除主机属性
GET /conf/v2/host/attr/export 导出应用节点列表
POST /conf/v2/host/attr/import/file/{appId} 导入应用节点
GET /conf/v2/host/attr/name/list 获取主机属性名称列表
GET /conf/v2/host/attr/page/list 分页查询主机属性列表
PUT /conf/v2/host/attr/update/{id} 修改主机属性
主机操作记录相关的接口 : Conf Host Operate Record Controller Show/Hide List Operations Expand Operations
GET /conf/v2/host/operate/record/export 导出主机操作记录记录
GET /conf/v2/host/operate/record/list 分页查询主机操作记录
GET /conf/v2/host/operate/record/{id} 查询主机操作记录详情
主机标记相关的接口 : Conf Host Tag Controller Show/Hide List Operations Expand Operations
POST /conf/v2/host/tag/add 新增主机标记
DELETE /conf/v2/host/tag/delete/{id} 删除主机标记
GET /conf/v2/host/tag/findAll 查询所有主机标记
GET /conf/v2/host/tag/findTagsByHostId 查询当前主机下的所有标记
GET /conf/v2/host/tag/findTagsByName 根据name查询标记列表
DELETE /conf/v2/host/tag/membership 主机删除标签
POST /conf/v2/host/tag/membership 主机添加标签
PUT /conf/v2/host/tag/membership 主机更新标签
PUT /conf/v2/host/tag/update/{id} 修改主机标记
作业上传,下载相关的接口 : Conf Job File Controller Show/Hide List Operations Expand Operations
GET /conf/v2/job/download 批量下载作业定义
POST /conf/v2/job/import 导入作业定义
作业实例相关的接口 : Conf Job Instance Controller Show/Hide List Operations Expand Operations
GET /conf/v2/job/instance/executes/day 查询某天已执行或待执行的定时任务作业实例列表
GET /conf/v2/job/instance/findByExecuteType/{executeType} 根据执行类型获取作业实例列表
GET /conf/v2/job/instance/findRecordResult/{id} 根据作业实例ID查询作业历史记录结果
GET /conf/v2/job/instance/pageList 分页查询作业实例列表
GET /conf/v2/job/instance/{id} 根据作业实例ID查询作业实例详情
作业执行历史相关的接口 : Conf Job Record Controller Show/Hide List Operations Expand Operations
GET /conf/v2/job/record/countByHistoryDate 统计执行任务历史记录的成功和失败数量
GET /conf/v2/job/record/countToday 统计当日执行任务的成功和失败数量
GET /conf/v2/job/record/export 导出作业执行记录
GET /conf/v2/job/record/find/{id} 根据作业ID查询作业详情
GET /conf/v2/job/record/pageList 分页查询作业执行历史列表
作业执行结果相关的接口 : Conf Job Host Result Controller Show/Hide List Operations Expand Operations
GET /conf/v2/job/node/result/export 导出主机执行记录
GET /conf/v2/job/node/result/find/{id} 根据ID查询作业实例-节点执行日志详情
GET /conf/v2/job/node/result/findByJobRecordId 根据作业执行记录ID查询作业节点执行结果
GET /conf/v2/job/node/result/host/exection/history/pageList 根据主机id和作业type分页过滤执行历史
GET /conf/v2/job/node/result/host/exection/pageList/{jobInstanceId} 根据作业实例id分页查询节点执行结果列表
作业标签相关的接口 : Conf Job Tag Controller Show/Hide List Operations Expand Operations
GET /conf/v2/job/tag/findJobTagsByName 根据标签名称查询作业标签列表
DELETE /conf/v2/job/tag/relation 作业删除标签
GET /conf/v2/job/tag/relation 根据作业code查询当前作业所有标签
POST /conf/v2/job/tag/relation 作业添加标签
PUT /conf/v2/job/tag/relation 作业更新标签
作业目录相关的接口 : Conf Job Folder Controller Show/Hide List Operations Expand Operations
POST /conf/v2/job/folder/add 新增作业目录
DELETE /conf/v2/job/folder/delete/{id} 删除作业目录
GET /conf/v2/job/folder/tree 查询作业目录树
PUT /conf/v2/job/folder/{id} 修改作业目录
作业相关的接口 : Conf Job Controller Show/Hide List Operations Expand Operations
POST /conf/v2/job/add 新增作业
PUT /conf/v2/job/approval/{id} 审核作业
DELETE /conf/v2/job/delete/{id} 删除作业
PUT /conf/v2/job/edit/{id} 修改作业
POST /conf/v2/job/execute 执行作业
POST /conf/v2/job/execute/{id} 根据作业实例ID直接执行作业实例
GET /conf/v2/job/find/{id} 根据作业ID查询作业详情
GET /conf/v2/job/findAll 查询所有作业
GET /conf/v2/job/findByPage 分页查询作业
GET /conf/v2/job/third/findByFolderId 根据作业目录ID查询作业定义(对外接口)
GET /conf/v2/job/third/findById 根据作业ID查询作业详情(对外接口)
GET /conf/v2/job/{code} 根据作业code查询作业详情
作业相关的接口(对外) : Conf Job Out Controller Show/Hide List Operations Expand Operations
POST /o/conf/v2/job/execution 执行作业(对外接口)
GET /o/conf/v2/job/findByJobRecordId/{jobRecordId} 根据作业执行记录ID查询作业节点执行结果(对外)
GET /o/conf/v2/job/list 分页查询作业(对外)
GET /o/conf/v2/job/tree 查询作业目录树(对外)
GET /o/conf/v2/job/{code} 根据作业code查询作业详情(对外)
字典表相关的接口 : Sys Dict Controller Show/Hide List Operations Expand Operations
GET /conf/v2/dict/listByTypeCode 根据typeCode查找对应的字典数据
POST /conf/v2/dict/{typeCode} 新增一个typeCode的对应字典数据
DELETE /conf/v2/dict/{typeCode}/{code} 删除一个typeCode的对应字典数据
PUT /conf/v2/dict/{typeCode}/{code} 更新一个typeCode的对应字典数据
DELETE /conf/v2/param 根据code值删除对应的值
POST /conf/v2/param 根据code值设置对应的值
PUT /conf/v2/param 更新对应的code的value值
GET /conf/v2/param/ 根据code值找到对应的value
定时任务相关的接口 : Conf Cron Job Controller Show/Hide List Operations Expand Operations
GET /conf/v2/cron/job/pageList 分页查询正在执行定时任务列表
POST /conf/v2/cron/job/stop/{id} 根据ID终止正在执行的定时任务
巡检结果相关的接口 : Conf Job Patrol Result Controller Show/Hide List Operations Expand Operations
POST /conf/v2/job/patrol/result 添加巡检结果
GET /conf/v2/job/patrol/result/findByPage 分页查询巡检结果列表
GET /conf/v2/job/patrol/result/findJobTags 查询作业标签列表信息
GET /conf/v2/job/patrol/result/{id} 根据id获取巡检结果信息
应用中心相关的接口 : Conf Application Controller Show/Hide List Operations Expand Operations
POST /conf/v2/application 新增应用中心
GET /conf/v2/application/findByPage 根据appId和tags分页查询主机
GET /conf/v2/application/host/page/{id} 通过应用id分页获取主机列表
DELETE /conf/v2/application/host/{id} 移除主机
POST /conf/v2/application/host/{id} 分配主机
GET /conf/v2/application/runAs/list/{id} 通过应用id获取runAs用户列表
GET /conf/v2/application/srv/page/{id} 通过应用id分页获取服务项列表
DELETE /conf/v2/application/srv/{id} 移除服务项
POST /conf/v2/application/srv/{id} 分配服务项
GET /conf/v2/application/tree 获取应用中心树
GET /conf/v2/application/user/group/{id} 获取已绑定的用户组
POST /conf/v2/application/user/group/{id} 绑定用户组
DELETE /conf/v2/application/{id} 删除应用中心
GET /conf/v2/application/{id} 获取应用中心详情
PUT /conf/v2/application/{id} 修改应用中心
应用属性模板相关的接口 : Conf App Attr Template Controller Show/Hide List Operations Expand Operations
POST /conf/v2/app/attr/template/add 新增应用属性模板
DELETE /conf/v2/app/attr/template/delete/{id} 删除应用属性模板
GET /conf/v2/app/attr/template/find/{id} 查询属性模板详情
GET /conf/v2/app/attr/template/findByPage 分页查询应用属性模板
PUT /conf/v2/app/attr/template/update/{id} 修改应用属性模板
应用属性相关的接口 : Conf App Attr Controller Show/Hide List Operations Expand Operations
POST /conf/v2/app/attr/add 新增应用属性
DELETE /conf/v2/app/attr/delete/{id} 删除应用属性
GET /conf/v2/app/attr/findByPage 分页查询应用属性
PUT /conf/v2/app/attr/update/{id} 修改应用属性
操作定义分类相关接口 : Conf Opdefine Category Controller Show/Hide List Operations Expand Operations
GET /conf/v2/opdefine/category 查询操作定义目录树
POST /conf/v2/opdefine/category 新增操作定义目录节点
DELETE /conf/v2/opdefine/category/{id} 删除操作定义目录节点
PUT /conf/v2/opdefine/category/{id} 修改操作定义目录节点
操作定义相关接口 : Conf Opdefine Controller Show/Hide List Operations Expand Operations
DELETE /conf/v2/opdefine 删除操作定义
GET /conf/v2/opdefine 查询操作定义信息
POST /conf/v2/opdefine 新增操作定义
POST /conf/v2/opdefine/export 导出操作定义信息
POST /conf/v2/opdefine/file 读取文件内容
GET /conf/v2/opdefine/find/{id} 根据操作定义id查询操作定义详情
GET /conf/v2/opdefine/history/{code} 根据code查询历史版本的操作定义(对比用)
GET /conf/v2/opdefine/status 查询操作定义所有状态值
PUT /conf/v2/opdefine/{id} 修改操作定义信息
PUT /conf/v2/opdefine/{id}/approval 审核操作定义
POST /conf/v2/opdefine/{id}/import 导入操作定义信息
GET /conf/v2/opdefine/{id}/opdefineInfo 获取操作定义脚本信息
GET /conf/v2/opdefine/{key} 根据操作定义key查询操作定义信息(作业用)
操作定义相关的接口 : Conf Action Controller Show/Hide List Operations Expand Operations
POST /conf/v3/action 新增操作定义
GET /conf/v3/action/code/{code} 根据操作定义code查询详情
POST /conf/v3/action/execute 执行操作定义
GET /conf/v3/action/export 导出操作定义
POST /conf/v3/action/file 读取文件内容
GET /conf/v3/action/history/{code} 根据code查询历史版本的操作定义(对比用)
POST /conf/v3/action/import 导入操作定义
GET /conf/v3/action/list 分页查询操作定义
DELETE /conf/v3/action/{id} 删除操作定义
GET /conf/v3/action/{id} 根据操作定义ID查询详情
PUT /conf/v3/action/{id} 修改操作定义
操作定义相关的接口(对外) : Conf Action Out Controller Show/Hide List Operations Expand Operations
GET /o/conf/v3/action/all 查询所有操作定义
GET /o/conf/v3/action/code/{code} 根据操作定义code查询详情
POST /o/conf/v3/action/execute 执行操作定义
GET /o/conf/v3/action/hostResult/{jobRecordId} 根据作业执行记录ID查询作业节点执行结果
GET /o/conf/v3/action/list 分页查询操作定义
GET /o/conf/v3/action/tree 查询操作定义目录树
GET /o/conf/v3/action/{id} 根据操作定义id查询作业详情
GET /o/conf/v3/job/instance/{id} 根据作业实例ID查询作业实例详情
GET /o/conf/v3/job/record/{instanceId} 根据作业实例ID查询作业执行记录
用户相关的接口 : Conf User Group Controller Show/Hide List Operations Expand Operations
GET /conf/v2/user/account/group 请求uam中accountGroup接口
用户退出的接口 : Logout Controller Show/Hide List Operations Expand Operations
POST /conf/v2/logout 退出账号，刷新缓存
POST /conf/v2/password 修改密码
节点源相关的接口 : Conf Host Source Controller Show/Hide List Operations Expand Operations
POST /conf/v2/nodeSource 添加节点源
POST /conf/v2/nodeSource/discovery 发现
GET /conf/v2/nodeSource/findByPage 分页查询节点源列表
POST /conf/v2/nodeSource/timerSwitch 定时发现开关
DELETE /conf/v2/nodeSource/{id} 删除节点源
GET /conf/v2/nodeSource/{id} 根据id获取节点源
PUT /conf/v2/nodeSource/{id} 修改节点源
节点相关的接口 : Conf Host Controller Show/Hide List Operations Expand Operations
POST /conf/v2/node 添加节点
GET /conf/v2/node/attr 获取机器的属性信息
POST /conf/v2/node/deleteHost 删除设备
GET /conf/v2/node/findByPage 分页查询节点列表
GET /conf/v2/node/findByTags 根据一组主机标记ID查询对应的主机列表
GET /conf/v2/node/findTagsByIp 根据主机ip查询主机上的标签
GET /conf/v2/node/list 获取全部节点列表
GET /conf/v2/node/listByGroupId 根据节点组ID查询节点列表
POST /conf/v2/node/listByIds 根据节点ID列表查询节点列表
POST /conf/v2/node/listByNames 根据节点名称列表查询节点列表
GET /conf/v2/node/listByTag/{hostTagId} 根据主机标记ID查询主机列表
POST /conf/v2/node/membership 添加节点到节点组
POST /conf/v2/node/offline 设备下线
DELETE /conf/v2/node/{id} 根据id删除节点
GET /conf/v2/node/{id} 根据id获取节点信息
PUT /conf/v2/node/{id} 修改节点信息
节点组相关的接口 : Conf Host Group Controller Show/Hide List Operations Expand Operations
POST /conf/v2/nodeGroup 添加节点组
GET /conf/v2/nodeGroup/findByPage 分页查询节点组列表
POST /conf/v2/nodeGroup/listByIds 根据节点组ID列表查询节点列表
POST /conf/v2/nodeGroup/listByNames 根据节点组名称列表查询节点列表
GET /conf/v2/nodeGroup/listByNodeId 根据节点ID分页查询节点组列表
POST /conf/v2/nodeGroup/membership 向节点组添加成员节点
POST /conf/v2/nodeGroup/setPermission 设置节点组与用户组的对应关系
DELETE /conf/v2/nodeGroup/{id} 删除节点组
GET /conf/v2/nodeGroup/{id} 根据id获取节点组
PUT /conf/v2/nodeGroup/{id} 修改节点组
设备导入相关接口 : Conf Host File Controller Show/Hide List Operations Expand Operations
POST /conf/v2/host/import 导入设备"""
    // API信息
    private AbstractLineHandler apiInfoHandler = new AbstractLineHandler() {
        @Override
        void doPrint(String line) {
            if (null != line && line.trim().length() > 0) {
                def isChar = (-1 == line.indexOf(':')) && (-1 == line.indexOf('Show/Hide')) && (-1 == line.indexOf('List Operations')) && (-1 == line.indexOf('Expand Operations'))
                if (isChar) {
                    def row = line.split(' ')
                    // 在此调整每行的内容
                    println("| ${row[2]} | ${row[1]} | ${row[0]} | ")
                } else {
                    println()
                    def title = '#####' + line.split(':')[0]
                    println(title)
                    // 在此调整表头
                    println('| name            | url | action |\n' +
                            '| --------------- | ------ | ---- |')
                }
            }
        }
    }
    // API分类对比
    private AbstractLineHandler apiCatalogCompareHandler = new AbstractLineHandler() {
        @Override
        void doPrint(String line) {
            if (null != line && line.trim().length() > 0) {
                def isChar = (-1 == line.indexOf(':')) && (-1 == line.indexOf('Show/Hide')) && (-1 == line.indexOf('List Operations')) && (-1 == line.indexOf('Expand Operations'))
                if (!isChar) {
                    println("| ${(line.split(':')[0])} |  |   |  |  |")
                }
            }
        }
    }
    // API对比
    private AbstractLineHandler apiCompareHandler = new AbstractLineHandler() {
        @Override
        void doPrint(String line) {
            if (null != line && line.trim().length() > 0) {
                def isChar = (-1 == line.indexOf(':')) && (-1 == line.indexOf('Show/Hide')) && (-1 == line.indexOf('List Operations')) && (-1 == line.indexOf('Expand Operations'))
                if (isChar) {
                    def row = line.split(' ')
                    println("| ${row[2]} | ${row[1]} | ${row[0]} | ")
                } else {
                    println()
                    def title = '#####' + line.split(':')[0]
                    println(title)
                    println('| name            | url | Res | Conf | result | check |\n' +
                            '| --------------- | ------ | ---- | ---- | ---- | ---- |')
                }
            }
        }
    }

    // 文本处理
    @Test
    void analyseApiInfoFromText(){
        // API信息表格
        data.eachLine {
            apiInfoHandler.doPrint(it)
        }
    }

    @Test
    void analyseApiCompareFromText(){
        // API对比表格
        data.eachLine {
            apiCompareHandler.doPrint(it)
        }
    }

    // 文件处理
    /**
     * 将swagger ui页面拷贝出来的API 分类打印
     */
    @Test
    void analyseApiCatalogCompareFromFile() {
        // API模块分类对比表格
        println('| API分类            | Res | Conf  | result | check |\n' +
                '| --------------- | ------ | ---- | ------ | ------ |')
        readSwaggerHtmlCopyFile('/Users/biml/Documents/idcos/服务目录/Res/controller', apiCompareHandler)
    }

    /**
     * 将swagger ui页面拷贝出来的API 转为md对比表格
     */
    @Test
    void analyseApiInfoFromFile() {
        // API信息表格
        readSwaggerHtmlCopyFile('/Users/biml/Documents/idcos/服务目录/Conf/controller', apiInfoHandler)
    }

    /**
     * 将swagger ui页面拷贝出来的API 转为md对比表格
     */
    @Test
    void analyseApiCompareFromFile() {
        // API对比表格
        readSwaggerHtmlCopyFile('/Users/biml/Documents/idcos/服务目录/Res/controller', apiCatalogCompareHandler)
    }

    private readSwaggerHtmlCopyFile(String path, AbstractLineHandler handler) {
        new File(path).withReader('utf-8') {
            it.each { line ->
                handler.doPrint(line)
            }
        }
    }

    abstract class AbstractLineHandler {
        abstract void doPrint(String line)
    }
}
