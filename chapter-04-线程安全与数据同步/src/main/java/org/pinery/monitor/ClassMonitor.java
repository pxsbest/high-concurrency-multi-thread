package org.pinery.monitor;

import java.util.concurrent.TimeUnit;

/**
 * 同步一个类的不同静态方法
 * **/
public class ClassMonitor {
    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void method2() {
        synchronized (ClassMonitor.class)
        {
            System.out.println(Thread.currentThread().getName() + " enter to method2");
            try{
                TimeUnit.MINUTES.sleep(10);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(ClassMonitor::method1, "T1").start();
        new Thread(ClassMonitor::method2,"T2").start();

    }

}
