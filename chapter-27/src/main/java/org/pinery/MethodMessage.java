package org.pinery;

import java.util.Map;

/**
 * 收集每一个接口的方法参数,并且提供 execute 方法供 ActiveDaemonThread 直接调用
 **/
public abstract class MethodMessage {
    //用于收集方法参数,如果又返回Future类型,则一并收集
    protected final Map<String,Object> params;
    protected final OrderService orderService;

    public MethodMessage(Map<String, Object> params, OrderService orderService) {
        this.params=params;
        this.orderService = orderService;
    }
    //抽象方法,扮演 work thread 的说明书
    public abstract void execute();

}
