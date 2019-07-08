/**
 *
 * http://www.idcos.com
 * Copyright (c) 2015 All Rights Reserved.
 */
package org.feixu.smartx.sql

import groovy.sql.Sql
import org.feixu.smartx.util.MyUtil

/**
 *
 * @author Feixu
 * @version $Id: SqlUsage.java, v 0.1 2017/9/25 Feixu Exp $$
 */
class SqlUsage {
    private static def url
    private static def user
    private static def password

    /**
     * @param url db url
     * @param user user name for db
     * @param password password of the user
     * @return SqlUsage which is init by params.
     */
    static def init(url, user, password){
        SqlUsage.url = url
        SqlUsage.user = user
        SqlUsage.password = password
    }

    /**
     * 获取schema下的所有表
     * @param sqlString sql
     * @return List tablesName
     */
    static def queryDatas(def sqlString){
        def datas = new ArrayList()
        def sql = null
        try {
            sql = Sql.newInstance(url, user, password, "org.gjt.mm.mysql.Driver")
            sql.eachRow(sqlString) { row ->
                datas << row
            }
        } catch (Exception ex) {
            ex.printStackTrace()
        } finally {
            if (null != sql) {
                sql.close()
            }
        }
        datas
    }

    /**
     * 获取schema下的所有表
     * @param schema 模式名
     * @return List tablesName
     */
    static def queryTableInfo(schema){
        def names = new ArrayList()
        def sql = null
        try {
            sql = Sql.newInstance("jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root",
                    "Admin@2017", "org.gjt.mm.mysql.Driver")
            def sqlString = "select TABLE_NAME from information_schema.tables where TABLE_SCHEMA = '${schema}'"
            sql.eachRow(sqlString) { row ->
                names << MyUtil.tableNameToUpperCamel(row.table_name)
            }
        } catch (Exception ex) {
            ex.printStackTrace()
        } finally {
            if (null != sql) {
                sql.close()
            }
        }
        names
    }

    /**
     * 查询表里所有列
     * @param schema
     * @param table
     * @param hasTablePrefix2Comment 备注是否带表名做为前缀
     * @return
     */
    static def queryColumns(schema, table, hasTablePrefix2Comment = false){
        def names = new ArrayList()
        def sql = null
        try {
            sql = Sql.newInstance("jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root",
                    "Admin@2017", "org.gjt.mm.mysql.Driver")
            def sqlString = "select * from INFORMATION_SCHEMA.COLUMNS where TABLE_SCHEMA = '${schema}' and TABLE_NAME = '${table}'"
            sql.eachRow(sqlString) { row ->
                names << [
                        columnName   : MyUtil.tableNameToLowerCamel(row.column_name),
                        columnType   : row.column_type,
                        dataType     : row.data_type,
                        columnComment: (hasTablePrefix2Comment ? MyUtil.tableNameToLowerCamel(table):"") + row.column_comment,
                        isNull       : row.is_nullable,
                        columnKey    : row.column_key
                ]

            }
        } catch (Exception ex) {
            ex.printStackTrace()
        } finally {
            if (null != sql) {
                sql.close()
            }
        }
        names
    }
}
