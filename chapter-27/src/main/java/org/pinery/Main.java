package org.pinery;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //在创建 OrderService 时需要 创建 OrderService接口的具体实现
        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());

        //        orderService.order("hello", 453453);
        //        System.out.println("Return immediately");
        Future<String> orderDetails = orderService.findOrderDetails(453453);
        System.out.println(orderDetails.get());
        Thread.currentThread().join();
    }
}