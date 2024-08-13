package org.pinery.explicit_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @Author gensci
 * @DateTime 2024/7/18 17:56
 * @Description
 **/
public class BooleanLockTest {
    private final BooleanLock lock = new BooleanLock();

    public void syncMethod() {
        try {
            //加锁
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main0(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();
        IntStream.range(0, 10)
                .mapToObj(i -> new Thread((blt::syncMethod)))
                .forEach(Thread::start);
    }

    //可中断
    public static void main1(String[] args) throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();
        new Thread(blt::syncMethod, "T1").start();
        TimeUnit.MICROSECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethod, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t2.interrupt();
    }

    //阻塞的线程可超时
    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();
        new Thread(blt::syncMethod,"T1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2=new Thread(blt::syncMethodTimeoutable,"T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);

    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock.");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);

        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
