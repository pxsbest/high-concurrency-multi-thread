package org.pinery;

/**
 * 用于提交任务
 **/
public interface FutureService<IN, OUT> {
    /**
     * 提交不需要返回值的任务,Future.get()返回的将会是null
     */
    Future<?> submit(Runnable runnable);

    /**
     * 提交需要返回值的任务,其中Task接口代替了Runnable接口
     */
    Future<OUT> submit(Task<IN, OUT> task, IN input);

    /**
     * 提交需要返回值的任务,通过回调函数接收
     */
    Future<OUT> submit(Task<IN, OUT> task, IN input, Callback callback);

    //使用静态方法创建一个FutureService的实现
    static <T,R> FutureService<T,R> newService() {
        return new FutureServiceImpl<>();
    }
}
