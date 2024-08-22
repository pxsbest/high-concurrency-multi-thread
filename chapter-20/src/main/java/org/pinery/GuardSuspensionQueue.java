package org.pinery;

import java.util.LinkedList;

/**
 * 确保挂起设计模式
 **/
public class GuardSuspensionQueue {
    //定义存放 Integer类型的queue
    private final LinkedList<Integer> queue = new LinkedList<>();
    //定义queue的最大容量为 100
    private final Integer LIMIT = 100;

    //往queue中插入数据,如果 queue中的元素超过了最大容量,则会陷入阻塞
    public void offer(Integer data) throws InterruptedException {
        synchronized (this) {
            //判断queue的当前元素是否超过 LIMIT
            while (queue.size() >= LIMIT) {
                this.wait();
            }
            this.queue.add(data);
            this.notify();
        }
    }

    //从队列中获取元素,如果队列此时为空,则会使当前线程阻塞
    public Integer take() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                //则挂起当前线程
                this.wait();
            }
            //通知offer线程可以继承插入数据了
            this.notifyAll();
            return this.queue.removeFirst();
        }
    }
}
