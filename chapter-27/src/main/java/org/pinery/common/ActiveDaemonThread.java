package org.pinery.common;


public class ActiveDaemonThread extends Thread {
    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue) {
        super();
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            this.queue.take().execute();
        }
    }
}
