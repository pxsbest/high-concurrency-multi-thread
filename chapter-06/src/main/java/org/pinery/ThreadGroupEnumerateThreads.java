package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/7/19 21:19
 * @Description
 **/
public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        //创建一个线程组
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        //创建线程,并传入到 线程组
        Thread thread=new Thread(myGroup,()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        },"MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list, false);
        System.out.println(recurseSize);
    }
}
