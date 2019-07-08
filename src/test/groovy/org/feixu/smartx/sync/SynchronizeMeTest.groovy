package org.feixu.smartx.sync;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Feixu
 * @version $Id: SynchronizeMeTest.java, v 0.1 2017/11/6 Feixu Exp $$
 */
class SynchronizeMeTest {
    @Test
    void getNextCode() throws Exception {
    }

    static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                void run() {
                    println SynchronizeMe.getNextCode()
                }
            })
            thread.start()
        }
    }

}