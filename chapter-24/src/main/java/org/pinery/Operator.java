package org.pinery;


import org.pinery.service.ThreadPool;

/**
 *
 **/
public class Operator {

    private final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);


    public void call(String business) {
        TaskHandler taskHandler = new TaskHandler(new Request(business));
        //new Thread(taskHandler).start();
        threadPool.execute(taskHandler);

    }
}
