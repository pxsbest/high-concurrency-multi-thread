package org.pinery;

/**
 * 主要用于通知任务提交者,任务队列已无法再接收 新的任务
 **/
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
