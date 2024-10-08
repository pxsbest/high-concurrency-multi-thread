package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author ${USER}
 * @DateTime ${DATE} ${TIME}
 * @Description
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try{
                TimeUnit.SECONDS.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程结束");
    }
}