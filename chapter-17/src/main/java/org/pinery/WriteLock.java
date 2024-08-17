package org.pinery;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * 写锁
 **/
 class WriteLock  implements Lock{
     private final ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            System.out.println("线程-"+Thread.currentThread().getName()+" 进入 写锁 同步块");
            try{
                //首先使等待获取写入锁的数字加一
                readWriteLock.incrementWaitingWriters();
                //如果此时有其他线程正在进行读操作,或者写操作,那么当前线程将被挂起
                while (readWriteLock.getReadingReaders() > 0
                        || readWriteLock.getWritingWriters() > 0) {
                    System.out.println("线程-"+Thread.currentThread().getName()+" 进入写锁等待状态");
                    readWriteLock.getMUTEX().wait();
                }
            }finally {
                //成功获取到 写入锁,使得等待获取写入锁的计数器减一
                readWriteLock.decrementWaitingWriters();
            }
            //将正在写入的线程数量加一
            readWriteLock.incrementWritingWriters();
            System.out.printf("线程-"+Thread.currentThread().getName()+" 退出 写锁 同步块");
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            System.out.println("线程-"+Thread.currentThread().getName()+" 进入 释放写锁 同步块");
            //减少正在写入锁的线程计数器
            readWriteLock.decrementWritingWriters();
            //将偏好状态修改为 false,可以使得读锁被最快速的获得
            readWriteLock.changePrefer(false);
            //通知唤醒其他的 Mutex monitor waiter 中的线程
            readWriteLock.getMUTEX().notifyAll();
            System.out.println("线程-"+Thread.currentThread().getName()+" 退出 释放写锁 同步块");
        }
    }
}
