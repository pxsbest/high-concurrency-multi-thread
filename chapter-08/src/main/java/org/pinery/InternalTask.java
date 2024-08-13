package org.pinery;

import org.pinery.service.RunnableQueue;

/**
 * 主要用于线程池内部,该类会使用到Runnable,然后不断地从queue中取出某个runnable,
 * 并运行runnable的run方法
 **/
public class InternalTask implements Runnable {
    private final RunnableQueue runnableQueue;
    private volatile boolean running =true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务
     */
    public void stop() {
        this.running = false;
    }
}
