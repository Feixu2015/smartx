/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Feixu
 * @version $Id: DataTypeTest.java, v 0.1 2018/3/22 Feixu Exp $
 */
public class DataTypeTest {
    @Test
    public void SetOK() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("a");
        set1.add("b");
        set1.add("c");
        System.out.println(set1);
    }

    @Test
    public void testEmptyArray() {
        String[] fields = new String[0];
    }

    @Test
    public void good() {
        int[] abc = {10, 20, 30, 40};
        System.out.println(abc.equals(Arrays.asList(abc).get(0)));
        MatcherAssert.assertThat("good", "q".equals("f"));
    }
}
