package org.pinery.join;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// join 方法
public class Eight_join {
    public static void main(String[] args) throws InterruptedException {
        //1.定义两个线程,并保存到 threads中
        List<Thread> threads = IntStream.range(1, 3)
                .mapToObj(Eight_join::create)
                .collect(Collectors.toList());
        //2.启动这两个线程  ::双冒号运算操作符
        threads.forEach(Thread::start);
        //3.执行这两个线程的join方法
        for (Thread thread : threads) {
            thread.join(); //当前主线程 进入等待状态
        }
        //4.main线程循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }



    }

    //构造一个简单的线程,每个线程只是简单的循环输出
    public static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }


    public static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
