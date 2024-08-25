package org.pinery;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author gensci
 * @DateTime 2024/8/24 5:09
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        ThreadLocal<Integer> counter = new ThreadLocal<>();
        IntStream.range(1, 3)
                .forEach(i -> {
                    Thread thread = new Thread(() -> {
                        counter.set(0);
                        while (true) {
                            Integer num = counter.get();
                            counter.set(++num);
                            System.out.println(Thread.currentThread() + " counter 值: " + counter.get());
                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            if (counter.get() > 10) {
                                break;
                            }
                        }

                    });
                    thread.setDaemon(false); //true和 false 现象是不同的
                    thread.start();
                });
        System.out.println("主线程执行完结");
    }
}
