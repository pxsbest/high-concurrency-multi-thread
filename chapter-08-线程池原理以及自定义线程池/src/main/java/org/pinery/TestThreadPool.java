package org.pinery;

import org.pinery.service.ThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程池
 **/
public class TestThreadPool {

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池,初始化线程数为2,核心线程数为4,最大线程数为6,任务队列最多允许 1000 任务
        final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);

                    System.out.println(Thread.currentThread().getName() + " is running and done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        for (; ; ) {
//            System.out.println("getActiveCount: " + threadPool.getActiveCount());
//            System.out.println("getQueueSize:" + threadPool.getQueueSize());
//            System.out.println("getCoreSize:" + threadPool.getCoreSize());
//            System.out.println("getMaxSize:" + threadPool.getMaxSize());
//
//            System.out.println("================================================");
//            TimeUnit.SECONDS.sleep(5);
//        }

        for (; ; ) {
            TimeUnit.SECONDS.sleep(12);
            threadPool.shutdown();
            System.out.println("线程池关闭");
            Thread.currentThread().join();
        }




    }
}
