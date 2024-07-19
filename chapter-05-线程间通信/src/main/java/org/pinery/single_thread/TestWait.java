package org.pinery.single_thread;

/**
 * @Author gensci
 * @DateTime 2024/7/11 17:01
 * @Description
 **/
public class TestWait {


    //同步代码的 monitor必须 与执行 wait notify 方法的对象一致
    public static void main(String[] args) {
        TestWait obj = new TestWait();
        //obj.testWait();
        obj.testNotify();
    }

    private final Object MUTEX = new Object();

    private synchronized void testWait() {
        try {
            MUTEX.wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private synchronized void testNotify() {
        MUTEX.notify();
    }


    //必须在同步方法或代码块中 使用
    public static void main1(String[] args) {
        TestWait obj = new TestWait();
        try {
            /*
             * 报错: wait()和notify()方法必须在 同步方法中执行
             * */
            obj.wait();
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
