package org.pinery;

import java.util.concurrent.TimeUnit;


public class TryConcorrency {
    public static void main(String[] args) {
        //browseNews();
        //enjoyMusic();

        //通过匿名内部类的方式创建线程,并且重写其中的run方法
        //new Thread(() -> enjoyMusic()).start();

        //用Java 8 Lambda改造后的
        new Thread(TryConcorrency::enjoyMusic).start();

        browseNews();
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh,the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-hub,the nice music.");
            sleep(1);
        }
    }



    /**
     * Simulate the wait and ignore exceptioni
     * @param seconds
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }





}