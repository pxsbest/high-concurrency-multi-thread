package org.pinery;

/**
 * 任务执行完的回调函数
 **/
@FunctionalInterface
public interface Callback<T> {
    /**
     * 任务完成后会调用该方法,其中T为任务执行后的结果
     */
    void call(T t);
}
