package org.pinery.stop;

import java.util.concurrent.TimeUnit;

/**
 * 如何关闭线程
 **/
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
//                while (!isInterrupted()) {
//                    //working
//                }

                for (; ; ) {
                        try {
                            TimeUnit.MINUTES.sleep(1);
                        } catch (InterruptedException e) {
                            break;
                        }
                }

               System.out.println("I will be exiting");



            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("System will be shutdown");
        t.interrupt();
    }

}
