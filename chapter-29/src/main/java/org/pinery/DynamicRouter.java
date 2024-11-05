package org.pinery;

/**
 **/
public interface DynamicRouter<E extends Message> {
    /**
     * 针对每一种Message类型注册相关的 Channel, 只有找到合适的 Channel 该Message才会被处理
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * 为相应的 Channel分配 Message
     * @param message
     */
    void dispatch(E message);



}


