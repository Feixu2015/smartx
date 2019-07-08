package org.feixu.smartx.office;

import org.junit.Test;

/**
 * @author Feixu
 * @version $Id: WordXmlProcessTest.java, v 0.1 2017/10/16 Feixu Exp $$
 */
public class WordXmlProcessTest {
    @Test
    public void replaceVariables() throws Exception {
        WordXmlProcess.replaceVariables("E:\\Work\\wudi\\需求\\170930华贝安\\华贝安报告模板1.3.format.xml",
                "E:\\Work\\wudi\\需求\\170930华贝安\\华贝安报告模板1.3.format1.xml");
    }

    @Test
    public void validateVariables(){
        WordXmlProcess.validateVariables("E:\\Work\\wudi\\需求\\170930华贝安\\华贝安报告模板1.3.format1.xml");
    }
}