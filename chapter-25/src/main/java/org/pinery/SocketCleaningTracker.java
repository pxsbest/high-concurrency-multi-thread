package org.pinery;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;

/**
 * @Author gensci
 * @DateTime 2024/9/5 9:19
 * @Description
 **/
public class SocketCleaningTracker {
    //定义 ReferenceQueue
    private static final ReferenceQueue<Object> queue=new ReferenceQueue<>();

    static {
        //启动 Cleaner线程
        new Cleaner().start();
    }

    private static void track(Socket socket) {
        new Tracker(socket, queue);
    }

    private static class Cleaner extends Thread
    {
        private Cleaner() {
            super("SocketCleanerTracker");
            setDaemon(true);
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Tracker tracker = (Tracker) queue.remove();
                    tracker.close();
                } catch (InterruptedException e) {

                }
            }
        }
    }


    //Tracker是一个 PhantomReference
    private static class Tracker extends PhantomReference<Object>
    {
        private final Socket socket;
        public Tracker(Socket socket, ReferenceQueue<? super Object> queue) {
            super(socket, queue);
            this.socket = socket;
        }

        public void close() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
