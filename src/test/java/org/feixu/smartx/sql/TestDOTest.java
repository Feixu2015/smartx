package org.feixu.smartx.sql;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author Feixu
 * @version $Id: TestDOTest.java, v 0.1 2018/6/3 Feixu Exp $
 */
public class TestDOTest {
    @Test
    public void propsCopy() {
        TestDO testDO = new TestDO();
        testDO.setReeditable("Y");

        TestVO testVO = new TestVO();
        BeanUtils.copyProperties(testDO, testVO);

        JSONObject.toJSONString(testVO);
    }
}