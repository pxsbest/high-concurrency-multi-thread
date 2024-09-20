package org.pinery;

import java.util.LinkedList;

/**
 * 对应 Worker-Thread 模式中的传送带,主要用于传送调用线程通过 Proxy提交过来的 MethodMessage
 **/
public class ActiveMessageQueue {
    //用于存放提交的 MethodMessage
    private final LinkedList<MethodMessage> messages = new LinkedList<>();

    //启动Worker线程
    public ActiveMessageQueue() {
        new ActiveDaemonThread(this).start();
    }

    public void offer(MethodMessage methodMessage) {
        synchronized (this) {
            messages.addLast(methodMessage);
            this.notify();
        }
    }

    protected MethodMessage take() {
        synchronized (this) {
            while (messages.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            //获取其中一个 MethodMessage 并且从队列中 移除
            return messages.removeFirst();
        }
    }




}
