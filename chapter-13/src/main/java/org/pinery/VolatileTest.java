package org.pinery;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {

    //使用volatile修改共享资源i /ˈvɒlətaɪl/
    private static volatile int i = 0;

    //具有同步功能的锁
    private static final CountDownLatch latch = new CountDownLatch(10);

    private static void inc() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int x = 0; x < 1000; x++) {
                    inc();
                }
                //使计数器减1
                latch.countDown();
            }).start();
        }
        //等待所有的线程完成工作
        latch.await();
        System.out.println(i);
    }

}