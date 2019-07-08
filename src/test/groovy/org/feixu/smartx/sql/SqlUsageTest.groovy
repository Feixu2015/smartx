package org.feixu.smartx.sql

import groovy.sql.Sql
import org.feixu.smartx.util.MyUtil
import org.junit.Test
/**
 * @author Feixu
 * @version $Id: SqlUsageTest.java, v 0.1 2017/10/27 Feixu Exp $$
 */
class SqlUsageTest {
    private def url = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8&useSSL=false"
    private def user = "root"
    private def password = "admin"

    @Test
    void queryTableInfo() throws Exception {
        SqlUsage.queryTableInfo("assets").each {
            println it
        }
    }

    /**
     * generate add form fields
     */
    @Test
    void queryTableColumns() {
        SqlUsage.queryColumns("assets", "asset_use_record").each {
            def columnMap = [
                    varchar : "String",
                    datetime: "Date"
            ]
            println "/**\r\n * ${it.columnComment}\r\n */\r\n${"YES" != it.isNull ? "@NotBlank( message = \"${it.columnComment}不能为空\")\r\n" : ""}private String ${it.columnName};//${it.columnComment}\r\n"
        }
    }

    @Test
    void queryColumnInfo(){
        def datas = new ArrayList()
        def sql = null
        try {
            sql = Sql.newInstance(url, user, password, "org.gjt.mm.mysql.Driver")
            sql.eachRow("""SELECT COLUMN_NAME,COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'srv_catalog_uml' AND TABLE_NAME = 'SRV_ORDER_OPERATE_HISTORY'""") { row ->
                datas << [
                        key: MyUtil.tableNameToLowerCamel(row.column_name),
                        value: row.column_comment
                ]
            }
        } catch (Exception ex) {
            ex.printStackTrace()
        } finally {
            if (null != sql) {
                sql.close()
            }
        }
        println ""

        datas.sort{a,b-> a.key.compareTo(b.key)}.each {
            println "${it.key}\t${it.value}"
        }
        println "---------"

        datas.sort{a,b-> a.key.compareTo(b.key)}.each {
            println "| ${it.key} | ${it.value} | | | | |"
        }
        println "---------"
        datas.each {
            println "filedNameMap.put(\"${it.key}\", \"${it.value}\");"
        }
        println "---------"
        datas.each {
            print " \"${it.value}\","
        }
        println ""
        datas.each {
            println "srv.get${it.key[0].toUpperCase()}${it.key[1..-1]}(),"
        }
    }


}