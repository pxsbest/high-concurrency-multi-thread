package org.pinery;

/**
 * Future提供了获取计算结果和判断任务是否完成的功能
 **/
public interface Future <T>{
    /**
     * 返回计算后的结果,该方法会陷入阻塞状态
     */
    T get() throws InterruptedException;


    /**
     * 判断任务是否已经被执行完成
     */
    boolean done();
}
