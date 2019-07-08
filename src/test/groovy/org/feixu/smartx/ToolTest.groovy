/**
 *
 * http://www.idcos.com
 * Copyright (c) 2015 All Rights Reserved.
 */
package org.feixu.smartx

import org.feixu.smartx.validate.God
import org.junit.Test

/**
 *
 * @author Feixu
 * @version $Id: ToolTest.java, v 0.1 2017/10/26 Feixu Exp $$
 */
class ToolTest {
    @Test
    void generateFormItem(){
        def fields = [
                [
                        field:"name",
                        cn:"资产名称"
                ]
        ]
        def formItemStr = new StringBuilder("")
        fields.each {
            formItemStr << """<FormItem label="${it.cn}">
    {getFieldDecorator('${it.field}', {
        rules: [{required: true, message: '请输入${it.cn}!'}],
    })(
        <Input suffix={<Icon type="field" style={{fontSize: 13}}/>} placeholder="${it.cn}"
               ref={(input) => {
                   this.textInput = input;
               }}/>
    )}
</FormItem>\r\n"""
        }
        println formItemStr
    }

    @Test
    void generateTableColumns() {
        def fields = [
                [field: "", cn: ""]
        ]
        def columnDefineStr = new StringBuilder("")
        fields.each {

        }
        println columnDefineStr
    }

    void God(){
        God god = new God()
        println god
    }

    @Test
    void test(){

    }
}
