/**
 *
 * http://www.idcos.com
 * Copyright (c) 2015 All Rights Reserved.
 */
package org.feixu.smartx.sql

import org.feixu.smartx.util.MyUtil

/**
 * 代码生成
 *
 * @author Feixu
 * @version $Id: CodeGeneratorBySql.java, v 0.1 2017/10/28 Feixu Exp $$
 */
class CodeGeneratorBySql {
    /**
     * 生成DO或者Form对象的字段
     *
     * @param schema 模式
     * @param table 表
     * @param hasAnnotation false，生成Form对象字段；true，生成VO对象字段。目前只支持非空注解 @NotBlank
     * @return unformated fields define string
     */
    static def generateFields(schema, table, hasAnnotation = false, hasTablePrefix = false) {
        def stringBuilder = new StringBuilder("")
        def tableName = MyUtil.tableNameToLowerCamel(table)
        SqlUsage.queryColumns(schema, table, hasTablePrefix).each {
            def columnMap = [
                    varchar : "String",
                    datetime: "Date"
            ]
            def isNotBlank = "YES" != it.isNull ? "@NotBlank( message = \"${it.columnComment}不能为空\")\r\n" : ""
            def fieldType = hasAnnotation && columnMap.containsKey(it.dataType) ? columnMap."${it.dataType}" : "String"
            def fieldName = hasTablePrefix ? "${tableName}${it.columnName[0].toUpperCase()}${it.columnName[1..-1]}"
                    : it.columnName
            stringBuilder << """
/**
 * ${it.columnComment}
 */${hasAnnotation ? isNotBlank : ""}
private ${fieldType} ${fieldName};
"""
        }
        stringBuilder.toString()
    }
}
