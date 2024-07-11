package org.pinery.sync;

/**
 * 有问题的案例demo
 **/
public class TicketWindowRunnable implements Runnable {
    private int index = 1;
    private final static int MAX = 5000;

    //增加同步机制
    private final static Object MUTEX = new Object();


    @Override
    public void run() {

        //为了防止线程干扰和内存一致性错误,增加线程同步机制 synchronized
        synchronized (MUTEX) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");
        Thread windowThread5 = new Thread(task, "五号窗口");
        Thread windowThread6 = new Thread(task, "六号窗口");
        Thread windowThread7 = new Thread(task, "七号窗口");
        Thread windowThread8 = new Thread(task, "八号窗口");
        Thread windowThread9 = new Thread(task, "九号窗口");
        Thread windowThread10 = new Thread(task, "十号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
        windowThread4.start();
        windowThread5.start();
        windowThread6.start();
        windowThread7.start();
        windowThread8.start();
        windowThread9.start();
        windowThread10.start();
    }
}

