package org.pinery;

/**
 * Lock接口
 **/
public interface Lock {

    //获取显式锁,没有获得锁的线程将被阻塞
    void lock() throws InterruptedException;
    //释放获取锁
    void unlock();
}
