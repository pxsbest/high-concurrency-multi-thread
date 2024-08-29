package org.pinery;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;


/**
 * 用于处理每一个提交的 Rquest请求,由于 TaskHandler将被 Thread执行,因此需要 实现  Runnable
 **/
public class TaskHandler implements Runnable {

    //需要处理的 Request请求
    private final Request request;

    public TaskHandler(Request request) {
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("Begin handle " + request);
        slowly();
        System.out.println("End handle " + request);
    }

    private void slowly() {
        try {
            TimeUnit.SECONDS.sleep(current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
