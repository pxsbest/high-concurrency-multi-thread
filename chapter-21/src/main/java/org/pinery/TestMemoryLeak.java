package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 新版JDK 保证了 线程 不发生泄漏,在此做下测试
 **/
public class TestMemoryLeak {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set(new byte[1024*1024*100]);//100MB
            threadLocal.set(new byte[1024*1024*100]);//100MB
            threadLocal.set(new byte[1024*1024*100]);//100MB

            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            threadLocal = null;
            System.out.println("线程退出");
        }).start();
        //等待当前线程结束(无限等待)
        Thread.currentThread().join();
    }
}
