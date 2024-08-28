package org.pinery;

/**
 * 当子任务线程执行超时的时候会抛出异常
 **/
public class WaitTimeoutException extends Exception {
    public WaitTimeoutException(String message) {
        super(message);
    }
}
