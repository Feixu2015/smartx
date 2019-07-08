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
 * @version $Id: SqlFormatTest.java, v 0.1 2018/4/29 Feixu Exp $
 */
class SqlFormatTest {
    /**
     * 格式化的文本转单行
     */
    @Test
    void formated2SingleLine(){
        """SELECT t3.*,
               t4.CNAME
        FROM
          (SELECT t2.CODE,
                  SRV_INFO_STATUS,
                  count(1) num
           FROM SRV_CATALOG_INST t1
           JOIN SRV_CATALOG_SRV t2 ON t1.SRV_CATALOG_SRV_ID = t2.ID
           WHERE t1.TENANT_ID = :tenantId
             AND t1.IS_ACTIVE = 'Y'
             AND t1.SRV_INFO_STATUS IN ('SUCCEED',
                                        'FAILED')
             AND t1.GMT_CREATE >= :startDate
             AND t1.GMT_CREATE < :endDate
           GROUP BY t2.CODE,
                    SRV_INFO_STATUS) t3
        LEFT JOIN
          (SELECT srv1.CNAME,
                  srv2.CODE
           FROM SRV_CATALOG_SRV srv1
           JOIN
             (SELECT MAX(VERSION) VERSION,
                                  CODE
              FROM SRV_CATALOG_SRV
              WHERE TENANT_ID = :tenantId
              GROUP BY CODE) srv2 ON srv1.CODE = srv2.CODE
           AND srv1.VERSION = srv2.VERSION) t4 ON t3.CODE = t4.CODE""".eachLine {
            if(it){
                print " ${it.trim()}"
            }
        }
        println ''
    }

    /**
     * 格式化的文本转StringBuilder构建代码
     */
    @Test
    void formated2StringBuilderCode(){
        def varName = "conditionBuilder"
        println "StringBuilder ${varName} = new StringBuilder(\"\");"
        """SELECT
  t1.CODE srvCode,
  t2.CNAME srvName,
  t1.CNAME title,
  t1.SRV_NO orderNo,
  t1.CREATE_USER createUser,
  t1.APPROVAL_USER approvalUser,
  t3.start,
  t3.end,
  t3.timeUsed
FROM SRV_CATALOG_INST t1
  JOIN SRV_CATALOG_SRV t2 ON t1.SRV_CATALOG_SRV_ID = t2.ID
  JOIN
  (SELECT
     ORDER_NO                                                    orderNo,
     MIN(OPERATE_TIME)                                           start,
     MAX(OPERATE_TIME)                                           end,
     TIMESTAMPDIFF(SECOND, MIN(OPERATE_TIME), MAX(OPERATE_TIME)) timeUsed
   FROM SRV_ORDER_OPERATE_HISTORY
   WHERE ORDER_NO IN (
     SELECT DISTINCT ORDER_NO
     FROM SRV_ORDER_OPERATE_HISTORY
     WHERE ORDER_NO IN (SELECT SRV_NO
                        FROM SRV_CATALOG_INST
                        WHERE
                          SRV_INFO_STATUS IN ('SUCCEED', 'FAILED') AND TENANT_ID = :tenantId AND IS_ACTIVE = 'Y')
           AND TYPE IN ('SUCCEED', 'FAILED')
           AND OPERATE_TIME >= :startDate AND OPERATE_TIME <= :endDate) AND
         TYPE IN ('SUBMIT', 'APPROVAL_SKIP', 'SUCCEED', 'FAILED')
   GROUP BY ORDER_NO) t3
    ON t1.SRV_NO = t3.orderNo;""".eachLine {
            if(it){
                println "${varName}.append(\"${it.trim()} \");"
            }
        }
        println ''
    }

}
