package org.feixu.smartx.hibernate

import org.junit.BeforeClass
import org.junit.Test
/**
 * @author Feixu
 * @version $Id: JpaQueryTest.java, v 0.1 2018/3/13 Feixu Exp $
 */
class JpaQueryTest {
    private static JpaQuery jpaQuery
    def jpaFields = """sch.fullname, sci.id, sci.srvNo, sci.tenantId, sci.srvCatalogSrvId, sas.code, sas.version, sci.cname, sci.ctype, sci.gmtCreate, sci.description, sci.supportDept, sci.sla, sci.wfType, sas.srvInputParamsUi, sci.wfInstId, sci.srvInputParams, sci.srvInputParamsFull, sci.wfOutputParams, sci.createUser, sci.createUserId, sci.gmtImplStart, sci.gmtImplEnd, sci.srvInfoStatus, sci.approvalStatus, sci.approvalUser, sci.implLog, sci.approvalIssue, sci.wfInputParams, sci.gmtApprovalStart, sci.gmtApprovalEnd, sci.approvalRoleId, sci.remark, sci.approvalMethod, sci.implMethod, sci.actionCode, sci.actionDescription, sci.ifDoubleCheck, sci.doubleCheckUserGroupId"""

    @BeforeClass
    static void init(){
        jpaQuery = new JpaQuery()
    }

    @Test
    void jpaQueryFields2VOConstructorArgs() throws Exception {
        jpaQuery.jpaQueryFields2VOConstructorArgs(jpaFields)
    }

    @Test
    void jpaQueryFields2VOConstructorSetter() {
        jpaQuery.jpaQueryFields2VOConstructorSetter(jpaFields)
    }
}