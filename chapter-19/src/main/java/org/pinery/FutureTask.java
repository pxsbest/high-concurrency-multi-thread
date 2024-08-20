package org.pinery;

/**
 * FutureTask充分利用了线程间通信 wait 和 notifyAll ,当任务没有被执行完成之前通过get方法获取结果,调用者会进入阻塞,
 * 直到任务完成并接收到其他线路的唤醒信息,finish方法接收到了任务完成通知,唤醒了因调用get而进入阻塞的线程.
 **/
public class FutureTask<T> implements Future<T> {

    //计算结果
    private T result;
    private boolean isDone = false;
    //定义对象锁
    private final Object LOCK = new Object();

    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            //当任务还没有完成时,调用get会被挂起而进入阻塞状态
            while (!isDone) {
                LOCK.wait();
            }
            //返回最终的计算结果
            return result;
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }

    protected void finish(T result) {
        synchronized (LOCK){
            if (isDone) {
                return;
            }
            this.isDone=true;
            this.result=result;
            LOCK.notifyAll();
        }
    }
    /*
    * 注意:
    * 所有同步方法一定要在 synchronized 代码块中,
    * 否则会报 监听器状态异常 错误 : java.lang.IllegalMonitorStateException
    * */
}
