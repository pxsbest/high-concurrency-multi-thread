package org.pinery;

/**
 *
 **/
public class OrderServiceFactory {
    private final static ActiveMessageQueue activeMessageQueue=new ActiveMessageQueue();

    private OrderServiceFactory() {

    }

    public static OrderService toActiveObject(OrderService orderService) {
        return new OrderServiceProxy(orderService, activeMessageQueue);
    }
}
