package org.pinery.common;



import java.util.LinkedList;

public class ActiveMessageQueue {
    private final LinkedList<ActiveMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        new ActiveDaemonThread(this).start();
    }

    public void offer(ActiveMessage activeMessage) {
        synchronized (this) {
            messages.addLast(activeMessage);
            this.notify();
        }
    }

    public ActiveMessage take() {
        synchronized (this) {
            while (messages.isEmpty()) {
                try{
                    this.wait();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            //获取其中一个 MethodMessage ,并且从队列中移除
            return messages.removeFirst();
        }
    }
}
