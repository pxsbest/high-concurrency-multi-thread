package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 线程 sleep
 */
public class One_Sleep {
    public static void main(String[] args) {

        //自定义线程
        new Thread(()->{
            long startTime=System.currentTimeMillis();
            sleep(2_000L);
            long endTime=System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms", (endTime - startTime)));
        }).start();

        //主线程
        long startTime=System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms", (endTime - startTime)));

    }


    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);

// 使用Thread.sleep() 的地方 ,都可以使用 TimeUnit 来代替
//            TimeUnit.SECONDS.sleep(1);
//            TimeUnit.MINUTES.sleep(1);
//            TimeUnit.MILLISECONDS.sleep(1);


        } catch (InterruptedException exception) {

        }
    }

}
