package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 实现类
 **/
public class CountDownLatch extends Latch {

    private Runnable runnable;
//    public CountDownLatch(int limit) {
//        super(limit);
//    }

    public CountDownLatch(int limit, Runnable runnable) {
        super(limit);
        this.runnable = runnable;
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (this) {
            //当 limit>0 时, 当前线程进行阻塞状态
            while (limit > 0) {
                this.wait();
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException {
        if (time < 0) {
            throw new IllegalArgumentException("The time is invalid");
        }
        //将time转换成为纳秒
        long remainingNanos = unit.toNanos(time);
        //等待任务将在 endNanos秒后超时
        final long endNanos = System.nanoTime() + remainingNanos;
        synchronized (this) {
            while (limit > 0) {
                if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) < 0)
                    throw new WaitTimeoutException("The wait time over specify time.");

                this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endNanos - System.nanoTime();
            }
        }

        if (runnable != null) {
            runnable.run();
        }
    }

    @Override
    public void countDown() {
        synchronized (this) {
            if (limit < 0) {
                throw new IllegalStateException("all of task already arrived");
            }
            //使 limit 减一,并且通知阻塞线程
            limit--;
            this.notifyAll();

        }
    }

    @Override
    public int getUnarrived() {
        //返回有多少线程还未完成任务
        return limit;
    }
}
