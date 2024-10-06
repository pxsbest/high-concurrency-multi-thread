package org.pinery;

import java.util.concurrent.Executor;

/**
 *
 **/
public class EventBus implements Bus {

    private final Registry registry = new Registry();
    private String busName;
    private final static String DEFAULT_BUS_NAME = "default";
    private final static String DEFAULT_TOPIC = "default-topic";
    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName) {
        this(busName, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    EventBus(String busName, EventExceptionHandler exceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = Dispatcher.newDispatcher(exceptionHandler, executor);
    }

    public EventBus(EventExceptionHandler exceptionHandler) {
        this(DEFAULT_BUS_NAME, exceptionHandler, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }


    //将注册Subscriber的动作直接委托给 Registry
    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    //接触注册同样委托给 Registry
    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    //提交Event到默认的topic
    @Override
    public void post(Object event) {
        this.post(event,DEFAULT_TOPIC);
    }

    //提交Event到指定的 topic,具体的动作是由 Dispatcher 来完成的
    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return this.busName;
    }

}
