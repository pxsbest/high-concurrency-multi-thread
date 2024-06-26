package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 */
public class Seven_Interrupt {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted? %s \n",thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted? %s \n",thread.isInterrupted());

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
