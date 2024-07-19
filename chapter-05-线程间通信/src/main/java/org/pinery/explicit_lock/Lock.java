package org.pinery.explicit_lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Author gensci
 * @DateTime 2024/7/18 17:22
 * @Description
 **/
public interface Lock {
    void lock() throws InterruptedException;
    void lock(long mills) throws InterruptedException, TimeoutException;
    void unlock();
    List<Thread> getBlockedThreads();
}
