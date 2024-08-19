package org.pinery;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主要作用在于 当提交任务时创建一个新的线程来受理该任务,进而达到任务异步执行的效果
 **/
public class FutureServiceImpl<IN,OUT> implements FutureService<IN,OUT>{
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";
    private final static AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THREAD_PREFIX+nextCounter.getAndDecrement();
    }
    @Override
    public Future<?> submit(Runnable runnable) {
        FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
           runnable.run();
           future.finish(null);
       },getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        return null;
    }
}
