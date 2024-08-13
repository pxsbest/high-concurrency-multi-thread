package org.pinery.lazy.dbcheck;

import java.time.LocalDateTime;

/**
 * @Author gensci
 * @DateTime 2024/8/9 9:34
 * @Description
 **/
public class MyMain {
    public static void main2(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        System.out.println(minute);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20000; i++) {
            new Thread(() -> {
                while (LocalDateTime.now().getSecond() != 20) {
                    continue;
                }
                try {
                    boolean bl = Singleton.getInstances().file.exists();
                } catch (Exception ex) {
                    System.out.println("当前线程:" + Thread.currentThread().getName());
                    ex.printStackTrace();
                }
            }).start();
        }
    }


}
