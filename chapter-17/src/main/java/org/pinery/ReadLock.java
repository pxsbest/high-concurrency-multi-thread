package org.pinery;

/**
 *
 **/
class ReadLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            System.out.println("线程: "+Thread.currentThread().getName()+" 进入 读锁 同步块");
            //若此时有线程在进行写操作,或者有写线程在等待并且偏向写锁的标识为 true时,就会无法获得读锁,只能被挂起
            while (readWriteLock.getWritingWriters() > 0
                    || readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() > 0) {
                System.out.println("线程: "+Thread.currentThread().getName()+" 处于读锁等待状态");
                readWriteLock.getMUTEX().wait();
            }
            //成功获得读锁,并且使 readingReaders的数量增加
            readWriteLock.incrementReadingReaders();
            System.out.println("线程: "+Thread.currentThread().getName()+" 退出 读锁 同步块");
        }
    }

    @Override
    public void unlock() {
        //使用Mutex作为锁,并且进行同步
        synchronized (readWriteLock.getMUTEX()) {
            System.out.println("线程: "+Thread.currentThread().getName()+" 进入 释放读锁 同步块");
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
            System.out.println("线程: "+Thread.currentThread().getName()+" 退出 释放讯锁 同步块");

        }
    }
}
