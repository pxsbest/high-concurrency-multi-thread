package org.pinery;

/**
 * 业务逻辑执行接口
 **/
public interface Task<T> {
    //任务执行接口,该接口允许有返回值
    T call();
}
