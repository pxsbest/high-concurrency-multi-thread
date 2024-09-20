package org.pinery;

import java.util.HashMap;
import java.util.Map;

/**
 * OrderService的代理类
 * 它的作用是将OrderService的每一个方法都封装成 MethodMessage,然后提交给ActiveMessage队列,
 * 在使用OrderService接口方法时,实际上是在调用 OrderServiceProxy中的方法
 **/
public class OrderServiceProxy implements OrderService {

    private final OrderService orderService;
    private final ActiveMessageQueue activeMessageQueue;

    public OrderServiceProxy(OrderService orderService, ActiveMessageQueue activeMessageQueue) {
        this.orderService = orderService;
        this.activeMessageQueue = activeMessageQueue;
    }


    @Override
    public Future<String> findOrderDetails(long orderId) {
        //定义一个ActiveFuture,并且可支持立即返回
        final ActiveFuture<String> activeFuture = new ActiveFuture<>();
        //收集方法入参 以及返回的 ActiveFuture封装成 MethodMessage
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("activeFuture", activeFuture);
        MethodMessage message = new FindOrderDetailMessage(params, orderService);
        //将MethodMessage 保存至activeMessageQueue中
        activeMessageQueue.offer(message);
        return activeFuture;
    }

    @Override
    public void order(String account, long orderId) {
        Map<String, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("orderId", orderId);
        MethodMessage message = new OrderMessage(params, orderService);
        activeMessageQueue.offer(message);
    }


}
