package org.pinery.async;

import org.pinery.Channel;
import org.pinery.Event;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 **/
public abstract class AsyncChannel implements Channel<Event> {
    //在AsyncChannel 中将使用 ExecutorService 多线程的方式提交给 Message
    private final ExecutorService executorService;

    public AsyncChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    //默认的构造,提供了CPU的核数*2的线程数量
    public AsyncChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    //重写 dispatch方法,并且用 final 修饰,避免子类重写
    @Override
    public final void dispatch(Event message) {
        executorService.submit(() -> this.handle(message));
    }

    //提供抽象方法,供子类实现具体的 Message处理
    protected abstract void handle(Event message);

    //提供 关闭 ExecutorService的方法
    void stop() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }


}
