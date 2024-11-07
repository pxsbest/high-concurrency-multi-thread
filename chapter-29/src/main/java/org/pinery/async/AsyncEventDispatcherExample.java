package org.pinery.async;

import org.junit.rules.Timeout;
import org.pinery.Event;
import org.pinery.EventDispatcherExample;

import java.util.concurrent.TimeUnit;

/**
 * 测试
 **/
public class AsyncEventDispatcherExample {

    /**
     * 主要用于处理 InputEvent,但是需要继承 AsyncChannel
     */
    static class AsyncInputEventHandler extends AsyncChannel {
        private final AsyncEventDispatcher dispatcher;

        AsyncInputEventHandler(AsyncEventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        //不同于以同步的方式实现 dispatch,异步的方式需要实现 handler
        @Override
        protected void handle(Event message) {
            EventDispatcherExample.InputEvent inputEvent =
                    (EventDispatcherExample.InputEvent) message;
            System.out.printf("X:%d,Y:%d\n", inputEvent.getX(), inputEvent.getY());

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            int result = inputEvent.getX() + inputEvent.getY();
            dispatcher.dispatch(new EventDispatcherExample.ResultEvent(result));
        }
    }

    /**
     * 主要处理 InputEvent,但是需要继承 AsyncChannel
     */
    static class AsyncResultEventHandler extends AsyncChannel {
        @Override
        protected void handle(Event message) {
            EventDispatcherExample.ResultEvent resultEvent =
                    (EventDispatcherExample.ResultEvent) message;
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("The result is:"+resultEvent.getResult());
        }
    }

    public static void main(String[] args) {
        //定义AsyncEventDispatcher
        AsyncEventDispatcher dispatcher=new AsyncEventDispatcher();
        //注册Event 和 Channel 之间的关系
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class, new AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class, new AsyncResultEventHandler());

        //提交需要处理的 Message
        dispatcher.dispatch(new EventDispatcherExample.InputEvent(1, 2));
    }
/*
* 当dispatcher分配一个 Event的时候,如果执行非常缓慢也不会影响下一个Event被 dispatch,这主要得益于 采用了
* 异步的处理方式(ExecutorService本身存在任务队列可以允许异步提交一定数量级的数据)
* * */

}
