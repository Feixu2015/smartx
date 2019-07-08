package org.feixu.smartx.task

import org.junit.Test
/**
 * @author Feixu
 * @version $Id: ComTaskTest.java, v 0.1 2017/11/20 Feixu Exp $$
 */
class ComTaskTest {
    @Test
    public void writeTaskLine() throws Exception {
        def date = new Date() //DateUtil.parse()
        ComTask.writeTaskLine(date)
    }

    @Test
    void abc(){
     }
}