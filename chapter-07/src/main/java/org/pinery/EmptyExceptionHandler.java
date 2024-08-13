package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/7/20 7:54
 * @Description
 **/
public class EmptyExceptionHandler {
    public static void main1(String[] args) {

        //get current thread's thread group
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        final Thread thread=new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
            //抛出 unchecked异常
            System.out.println(1/0);
        },"Test-Thread");
        thread.start();
    }
}
