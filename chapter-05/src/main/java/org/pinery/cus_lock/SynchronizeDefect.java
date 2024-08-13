package org.pinery.cus_lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/7/18 16:31
 * @Description
 **/
public class SynchronizeDefect {
    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizeDefect defect = new SynchronizeDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();

        TimeUnit.MILLISECONDS.sleep(2);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());

    }





}
