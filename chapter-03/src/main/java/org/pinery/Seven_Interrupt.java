package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 */
public class Seven_Interrupt {


    public static void main(String[] args) {
        //1.判断当前线程是否被中断
        System.out.println("Main thread is interrupted? " + Thread.interrupted());

        //2.中断当前线程
        Thread.currentThread().interrupt();

        //3.判断当前线程是否已经被中断
        //System.out.println("Main thread id interrupted? " + Thread.currentThread().isInterrupted());
        System.out.println("Main thread id interrupted? " + Thread.interrupted());

        try {
            //4. 当前线程执行 可中断方法
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException ex) {
            //5.获取中断信号
            System.out.println("I will be interrupted still");
        }
    }


    //Thread.interrupted()
    public static void main4(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();

    }


    //线程可执行体中 sleep()代码,此种情况下,线程中断之后会发现中断异常且会清除中断标识
    public static void main3(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    //忽略异常,此处中断标识会清除
                    System.out.printf("I am be interrupted ? %s \n", isInterrupted());
                }
            }
        };

        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted? %s \n", thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted? %s \n", thread.isInterrupted());

    }

    /**
     * isInterrupted 是Thread的一个成员方法,它主要判断当前线程是否被中断,该方法仅仅是对 interrupt标识的一个判断
     */
    public static void main2(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted? %s \n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted? %s \n", thread.isInterrupted());

    }


    //线程中断
    public static void main_1(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("Oh, i am be interrupted.");
            }
        });

        thread.start();
        // TimeUnit.MILLISECONDS.sleep(2);
        //  thread.interrupt();

    }
}
