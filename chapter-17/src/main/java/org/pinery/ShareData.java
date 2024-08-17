package org.pinery;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 读写锁的使用
 **/
public class ShareData {
    private final List<Character> container = new ArrayList<>();
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
    private final Lock readLock= readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final int length;

    public ShareData(int length) {
        this.length = length;
        for (int i = 0; i < length; i++) {
            container.add(i, 'c');
        }
    }


    public char[] read() throws InterruptedException {
        try{
            readLock.lock();
            char[] newBuffer = new char[length];
            for (int i = 0; i < length; i++) {
                newBuffer[i] = container.get(i);
            }
            slowly();
            return newBuffer;
        }finally {
            //当所有的操作都完成之后,对读锁进行释放
            readLock.unlock();
        }
    }


    public void write(char c) throws InterruptedException
    {
        try{
            //使用写锁进行lock
            writeLock.lock();
            for (int i = 0; i < length; i++) {
                this.container.add(i, c);
            }
            slowly();
        }finally {
            //释放
            writeLock.unlock();
        }
    }
    //简单模拟操作的耗时
    private void slowly() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
