package org.pinery;


public class ActiveDaemonThread extends Thread {
    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue) {
        super("ActiveDaemonThread");
        this.queue=queue;
        //ActiveDaemonThread为守护线程
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            //从 MethodMessage队列中获取一个 MethodMessage,然后执行 execute方法
            MethodMessage methodMessage = this.queue.take();
            methodMessage.execute();
        }
    }
}
