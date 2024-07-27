package org.pinery.load;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author gensci
 * @DateTime 2024/7/27 10:25
 * @Description
 **/
public class ClassInit2 {
    //<clinit>()方法在多线程的执行环境下是同步的
    static {
        try {
            System.out.println("The static method block is invoked.");
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(ClassInit2::new));
    }
}
