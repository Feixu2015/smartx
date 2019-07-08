/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.event

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * @author Feixu
 * @version $Id: ExecutorsSample.java, v 0.1 2017/12/5 Feixu Exp $$
 */
class ExecutorsSample<T> {
    private ExecutorService threadPool = Executors.newFixedThreadPool(8);

    void ExecutorTest() {
        final List<T> batches = new ArrayList<T>()

        Callable<T> t = new Callable<T>() { // *1
            @Override
            T call() throws Exception {
                synchronized (batches) { // *2
                    T result = callDatabase(msg) // *3
                    batches.add(result)
                    return result
                }
            }
        };

        Future<T> f = threadPool.submit(t) // *4
        T result = f.get() // *5
    }
}
