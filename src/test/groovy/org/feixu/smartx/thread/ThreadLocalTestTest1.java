package org.feixu.smartx.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feixu
 * @version $Id: ThreadLocalTestTest1.java, v 0.1 2017/12/19 Feixu Exp $$
 */
public class ThreadLocalTestTest1 {
    @Test
    public void auto() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final int cur = i;
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(cur);
                }
            }));
            /*try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        for (int i = 0; i < 1000; i++) {
            threads.get(i).start();
        }
    }
}