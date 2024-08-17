package org.pinery;

/**
 *
 **/
public interface ReadWriteLock {
    //创建 reader锁
    Lock readLock();

    //创建 write 锁
    Lock writeLock();

    //获取当前有多少线程正在执行写操作
    int getWritingWriters();
    //获取当前有多少线程正在等待写入锁
    int getWaitingWriters();
    //获取当前有多少线程正在等待获取reader锁
    int getReadingReaders();

    //工厂方法,创建ReadWriteLock
    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    //工厂方法,创建ReadWriteLock,并且传入 preferWriter
    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }
}
