package org.pinery;

/**
 * Bus接口定义了 EventBus 的所有使用方法
 **/
public interface Bus {
    /**
     * 将某个对象注册到 Bus上,从此之后该类就成为 Subscriber了
     */
    void register(Object subscriber);

    /**
     * 将某个对象从 Bus上取消注册,取消注册之后就不会再接收到来自 Bus的任务消息
     */
    void unregister(Object subscriber);

    /**
     * 提交Event到默认的topic
     */
    void post(Object event);

    /**
     * 提交 Event 到指定的 topic
     */
    void post(Object event,String topic);

    /**
     * 关闭该bus
     */
    void close();

    /**
     * 返回 Bus的名称标识
     */
    String getBusName();

}
