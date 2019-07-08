package org.feixu.smartx.sql;

import org.junit.Test;

/**
 * @author Feixu
 * @version $Id: CodeGeneratorBySqlTest.java, v 0.1 2017/10/28 Feixu Exp $$
 */
class CodeGeneratorBySqlTest {
    @Test
    void generateFields() throws Exception {
        def all = new StringBuilder()
        all << "//employee字段-->"
        all << CodeGeneratorBySql.generateFields("assets", "employee", false, true)
        all << "//asset_use_record字段-->"
        all << CodeGeneratorBySql.generateFields("assets", "asset_use_record", false, true)
        all << "//equipment字段-->"
        all << CodeGeneratorBySql.generateFields("assets", "equipment", false, true)
        println all
    }
}