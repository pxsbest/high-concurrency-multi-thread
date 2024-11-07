package org.pinery.async;

import org.pinery.Channel;
import org.pinery.DynamicRouter;
import org.pinery.Event;
import org.pinery.MessageMatcherException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 以并发的方式 分配处理 消息
 **/
public class AsyncEventDispatcher implements DynamicRouter<Event> {
    //使用线程安全的 ConcurrentHaspMap 替换 HashMap
    private final Map<Class<? extends Event>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType
            , Channel<? extends Event> channel) {
        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channel for [" + message.getType() + "] type");
        }
    }

    public void shutdown() {
        //关闭所有的 Channel以释放资源
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
