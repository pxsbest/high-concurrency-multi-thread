package org.pinery;

import java.util.HashMap;
import java.util.Map;

/**
 * EventDispatcher 不是一个线程安全的类
 **/
public class EventDispatcher implements DynamicRouter {
    //用于保存 Channel 与 Message 之间的关系
    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {
        //初始化 RouterTable, 但是在该实现中,我们使用 HashMap 作为路由表
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class messageType, Channel channel) {
        this.routerTable.put(messageType, channel);
    }

    @Override
    public void dispatch(Message message) {
        if (routerTable.containsKey(message.getType())) {
            //直接获取对应的Channel,进行下得Message
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channel for [ " + message.getType() + " ] type");
        }
    }
}
