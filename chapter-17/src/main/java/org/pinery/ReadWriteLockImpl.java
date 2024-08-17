package org.pinery;

/**
 * 包可见,创建时使用 ReadWriterLock 的 create方法
 **/
class ReadWriteLockImpl implements ReadWriteLock {
    //定义对象锁
    private final Object MUTEX = new Object();

    //当前有多少个线程正在写入
    private int writingWriters = 0;
    //当前有多少个线程正在等待写入
    private int waitingWriters = 0;
    //当前有多少个线程正在read
    private int readingReaders = 0;
    //read和write的偏好设置
    private boolean preferWriter;

    //默认情况下 preferWriter 为true
    public ReadWriteLockImpl() {
        this(true);
    }

    //构造 ReadWriterLockImpl 并且传入 preferWriter
    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    //创建 read lock
    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    //创建 write lock
    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    //使写线程的数量增加
    void incrementWritingWriters() {
        this.writingWriters++;
    }

    void incrementWaitingWriters() {
        this.waitingWriters++;
    }


    //使写线程的数量减少
    void decrementWritingWriters() {
        this.writingWriters--;
    }

    //使等待获取写入锁的数量减少
    void decrementWaitingWriters() {
        this.waitingWriters--;
    }

    //使读线程的数量增加
    void incrementReadingReaders() {
        this.readingReaders++;
    }

    //使读取线程的数量减少
    void decrementReadingReaders() {
        this.readingReaders--;
    }


    //获取当前有多少个线程正在进行写操作
    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    //获取对象锁
    Object getMUTEX() {
        return this.MUTEX;
    }
    //获取当前是否偏向写锁
    boolean getPreferWriter() {
        return this.preferWriter;
    }

    //设置写锁偏好
    void changePrefer(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

}
