package org.pinery;

import org.pinery.service.DenyPolicy;
import org.pinery.service.RunnableQueue;
import org.pinery.service.ThreadFactory;
import org.pinery.service.ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池管理
 **/
public class BasicThreadPool extends Thread implements ThreadPool {
    //初始化线程数量
    private final int initSize;
    //线程池最大线程数量
    private final int maxSize;
    //线程池核心线程数量
    private final int coreSize;
    //当前活跃的线程数量
    private int activeCount;
    //创建线程所需的工厂
    private final ThreadFactory threadFactory;
    //任务队列
    private final RunnableQueue runnableQueue;
    //线程池是否已经被 shutdown
    private volatile boolean isShutdown = false;
    //工作线程队列
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();
    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
    private final long keepAliveTime;
    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY,
                queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory,
                           int queueSize, DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    //初始化时,先创建initSize个线程
    private void init() {
        start();
        for (int i = 0; i < initSize; i++) {
            System.out.println("初始化:newThread");
            newThread();
        }
    }

    /**
     * 在BasicThreadPool new的同时,自身轮循判断 当前活跃线程和 任务队列中任务数量 等数据,进行判断是否添加新线程还是减少线程;
     * 同时启动InternalTask 线程 不断从 RunnableQueue队列中取任务, execute()不断向 RunnableQueue队列中放任务
     */
    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }

            synchronized (this) {
                System.out.println("当前activeCount:" + activeCount);
                if (isShutdown) {
                    break;
                }
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }
                    continue;
                }
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; i++) {
                        newThread();
                    }
                }

                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }
            }


        }
    }

    //创建线程并加到线程队列中
    private void newThread() {
        //创建任务线程,并且启动
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        System.out.println("activeCount++:"+this.activeCount);
        thread.start();
    }

    private void removeThread() {
        //从线程池中移除某个线程
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        threadTask.thread.interrupt();
        this.activeCount--;
    }


    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        //提交任务只是简单地往任务队列中插入 Runnable
        this.runnableQueue.offer(runnable);
    }

    //region 属性
    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutdown) {
                return;
            }
            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy.");
        }
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy.");
        }
        return this.maxSize;

    }

    @Override
    public int getCoreSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy.");
        }
        return this.coreSize;

    }

    @Override
    public int getQueueSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy.");
        }
        return runnableQueue.size();

    }

    @Override
    public int getActiveCount() {
        synchronized (this) {
            return this.activeCount;
        }
    }
    //endregion

    private static class ThreadTask {
        Thread thread;
        InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());
        public static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group, runnable, "thread-pool-" + COUNTER.getAndDecrement());
        }
    }

}
