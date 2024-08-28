package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 测试门闩设计模式
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Latch latch = new CountDownLatch(4,()-> System.out.println("执行完毕"));
        new ProgrammerTravel(latch,"Alex","Bus").start();
        new ProgrammerTravel(latch,"Gavin","Walking").start();
        new ProgrammerTravel(latch,"Jack","Subway").start();
        new ProgrammerTravel(latch,"Dillon","Bicycle").start();

        //等待所有人完成任务
        //latch.await();
        //System.out.println("== all of programmer arrived ==");

        //设置超时时间,到时间未完成给出通知
        try {
            latch.await(TimeUnit.SECONDS,50);
            System.out.println("== all of programmer arrived ==");

            //java.util.concurrent.CountDownLatch


        } catch (WaitTimeoutException e) {
            e.printStackTrace();
        }
    }
}