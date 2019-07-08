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
 * @version $Id: TablesUtilTest.java, v 0.1 2018/3/12 Feixu Exp $
 */
class TablesUtilTest {
    @Test
    void tableNamesJoinCopedFromClient() {
        def tableNames = """SRV_AUTH_RES
SRV_CATALOG_HIERARCHY
SRV_CATALOG_INST
SRV_CATALOG_INST_20171018
SRV_CATALOG_INST_20171129
SRV_CATALOG_SRV
SRV_DATA_PERMISSION
SRV_ORDER_OPERATE_HISTORY
SRV_ROLE_OPERATE_REL
SRV_RULE
SRV_SERVICE_SET_TEMP
SRV_SYS_OPERATE
SRV_SYS_ROLE
SRV_SYS_USER
SRV_USER_ROLE_REL"""
        def nameArray = []
        tableNames.eachLine {
            nameArray << it
        }
        print nameArray.join(" ")
    }

    @Test
    void tableNamesJoinCopedFromConsole() {
        def tables = """| SRV_AUTH_RES                         |
| SRV_CATALOG_HIERARCHY                |
| SRV_CATALOG_HIERARCHY_USER_GROUP_REL |
| SRV_CATALOG_INST                     |
| SRV_CATALOG_SRV                      |
| SRV_DATA_PERMISSION                  |
| SRV_ORDER_OPERATE_HISTORY            |
| SRV_ROLE_OPERATE_REL                 |
| SRV_RULE                             |
| SRV_SERVICE_SET_TEMP                 |
| SRV_SYS_OPERATE                      |
| SRV_SYS_ROLE                         |
| SRV_SYS_USER                         |
| SRV_USER_ROLE_REL                    |"""
        def nameArray = []
        tables.eachLine {
            nameArray << it.replace('|', '').trim()
        }
        print nameArray.join(" ")
    }

    @Test
    void playWithTableNames() {
        def prefix = "DROP TABLE IF EXISTS "
        def subfix = ";\r\n"
        def specialSymbolBefore = "`"
        def specialSymbolAfter = "`"
        def tables = """SRV_DATA_PERMISSION
SRV_ROLE_OPERATE_REL
SRV_RULE
SRV_SYS_OPERATE
SRV_SYS_ROLE
SRV_SYS_USER
SRV_USER_ROLE_REL"""
        def nameArray = []
        tables.eachLine {
            nameArray << it
        }
        nameArray.each {
            print "${prefix}${specialSymbolBefore}$it${specialSymbolAfter}${subfix}"
        }
    }

    @Test
    void jpql2sql() {
        def jpql = """select 
sch.fullname, sci.id, sci.srvNo, sci.tenantId, sci.srvCatalogSrvId, sas.code, sas.version,
sci.cname, sci.ctype, sci.gmtCreate, sci.description, sci.supportDept, sci.sla, sci.wfType,
sas.srvInputParamsUi, sci.wfInstId, sci.srvInputParams, sci.srvInputParamsFull,
sci.wfOutputParams, sci.createUser, sci.createUserId, sci.gmtImplStart, sci.gmtImplEnd,
sci.srvInfoStatus, sci.approvalStatus, sci.approvalUser, sci.implLog, sci.approvalIssue, 
sci.wfInputParams, sci.gmtApprovalStart, sci.gmtApprovalEnd, sci.approvalRoleId, sci.remark,
sci.approvalMethod, sci.actionCode, sci.actionDescription, sci.ifDoubleCheck, sci.doubleCheckUserGroupId 
from SRV_CATALOG_INST sci, SRV_CATALOG_SRV sas, SRV_CATALOG_HIERARCHY sch where sci.srvCatalogSrvId = sas.id 
and sas.srvCatalogHirId = sch.id and sci.isActive = :isActive  and sci.tenantId = :tenantId and 
(( sci.srvInfoStatus in ('INIT') and sci.approvalStatus = 'INIT' and sci.approvalMethod = 'DEFAULT'   
and sas.approvalRoleId in :roleIdList  ) or ((sci.srvInfoStatus in ('WAITING') or 
(sci.srvInfoStatus = 'INIT' and sci.approvalStatus in ('ABORT','PASS')))  
and sci.createUserId = :userId  )) order by sci.gmtCreate DESC"""


    }

    @Test
    void orgnizeBackupTables(){
        // 用户名
        def userName = "root"
        // 库名
        def databaseName = "cloudres"
        // 备份文件名
        def sqlFileName = "srv_catalog_${databaseName}_backup_${new Date().format("yyyyMMddHHmmss")}.sql"
        print "mysqldump -u${userName} -p ${databaseName} "
        """SRV_AUTH_RES
SRV_CATALOG_HIERARCHY
SRV_CATALOG_HIERARCHY_USER_GROUP_REL
SRV_CATALOG_INST
SRV_CATALOG_SRV
SRV_ORDER_OPERATE_HISTORY
SRV_RULE
SRV_SERVICE_SET_TEMP
SYS_DICT
""".eachLine {
            if(it){
                print "$it "
            }
        }
        println " > ${sqlFileName}"
    }

    @Test
    void sqlChange(){
        println """-- author: 毕敏立
-- description: 
-- date: ${new Date().format('yyyy-MM-dd HH:mm:ss')}"""
    }

    @Test
    void sqlToStringBuilder(){
        println 'StringBuilder stringBuilder = new StringBuilder("");'
        """select  new com.idcos.srvcatalog.biz.manage.vo.SrvCatalogSrvFavoriteDO(
  srv.id,
  srv.srvCatalogHirId as pid,
  srv.cname              as name,
  srv.code,
  srv.description,
  srv.version,
  srv.status,
  srv.gmtCreate,
  srv.gmtModified,
  srv.orderNum          as ordernumber,
  case when serviceId is not null
    then true
  else false end         as favorite,
  inst.lastUsageTime)
from SrvCatalogSrvDO srv left join (select f1.serviceId
                                    from SrvCatalogSrvFavoriteDO f1
                                    where userId = :USER_ID and tenantId = :TENANT_ID) favorite on srv.id = favorite.serviceId
  left join (select
               code,
               max(gmtCreate) as last_usage_time
             from SrvCatalogInstDO
             where tenantId = :DEFAULT_TENANT_ID
             group by code) inst on srv.code = inst.code
where srv.tenantId = :DEFAULT_TENANT_ID and srv.isActive = 'Y' and srv.id in :IDS and srv.status in :STATUS
order by srv.orderNum asc, srv.gmtCreate desc""".eachLine {
            if (it) {
                println "stringBuilder.append(\"${it.trim()} \");"
            }
        }
    }
}
