package serialization;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

/**
 * @author Feixu
 * @version $Id: MainTest.java, v 0.1 2018/4/1 Feixu Exp $$
 */
public class MainTest{

    private File file;

    private final static Lock lock = new ReentrantLock();

    @Test
    public void abc() {
        file.getPath();

        String abc = null;
        if (abc == null) {

        }
    }

    @Test
    public void abcd() {
        //int a = "aaa";
        abc();
        //int b = "aaaa";

        String abc = "abcdefg" +
                "" +
                "" +
                "" +
                "" +
                "hkl";
    }

    @Test
    public void floatTest01() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a-b);
    }

    @Test
    public void floatTest02() {
        float a = Float.valueOf(1.0f - 0.9f);
        float b = Float.valueOf(0.9f - 0.8f);
        System.out.println(a-b);
    }

    @Test
    public void decimalTest02() {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void switchNull() {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void decimalTest01() {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }

    @Test
    public void lockTes01() {
        try {
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}