/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.sql

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.sql.Sql
import org.junit.Test

/**
 * 数据迁移
 *
 * @author Feixu
 * @version $Id: DataMigrationTest.java, v 0.1 2018/8/15 Feixu Exp $
 */
class DataMigrationTest {
    @Test
    void readDataDiff() {
        def db = [url: 'jdbc:mysql://localhost:3306/srv_catalog_conf_2.2.3?characterEncoding=UTF-8&autoReconnect=true', user: 'root', password: 'admin', driver: 'com.mysql.jdbc.Driver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        sql.withTransaction {
            sql.eachRow("SELECT TASK_TYPE, SRV_INPUT_PARAMS, STARTABLE_BEGIN, STARTABLE_END, CRONTAB FROM SRV_CATALOG_INST WHERE WF_TYPE = 'JOB' LIMIT 1") {
                if (it.SRV_INPUT_PARAMS) {
                    def data = new JsonSlurper().parseText(it.SRV_INPUT_PARAMS)
                    println new JsonBuilder(data).toPrettyString()
                }
            }
        }
    }

    @Test
    void good() {
        def abc = [
                abc: "123",
                a12: [
                        ab1: 123,
                        ab2: 345,
                        cd3: [
                                name: 'abc'
                        ]
                ],
                a13: [1, 2, 3, 4]
        ]
        def abc1 = [
                abc: "123",
                a12: [
                        ab1: 123,
                        ab2: 345,
                        cd3: 10
                ],
                a13: 678
        ]
        def abc2 = [
                abc: "124",
                a12: [
                        ab1: 123,
                        ab2: 345,
                        cd3: 10
                ],
                cd3: [
                        name: 'abc'
                ],
                a14: 678
        ]

        println new JsonBuilder(abc + abc1 + abc2).toPrettyString()
    }

    def walk(obj) {
        println obj
        if (obj) {
            obj.each { it ->
                if (it) {
                    if (it instanceof Map.Entry) {
                        if (it.value) {
                            if (it.value instanceof Map.Entry || it.value instanceof Iterable) {
                                walk it.value
                            } else {
                                println "${it.key}:${it.value}"
                            }
                        }
                    } else if (it instanceof Iterable) {
                        walk(it)
                    }
                } else {
                    println it
                }
            }
        }
    }
}
