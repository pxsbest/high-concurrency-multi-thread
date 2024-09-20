package org.pinery;

import org.pinery.common.ActiveMethod;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class OrderServiceImpl implements OrderService{
    @Override
    public Future<String> findOrderDetails(long orderId) {
        org.pinery.Future<String> submit = FutureService.<Long, String>newService().submit(input -> {
            try {
                //通过休眠来模拟该方法执行比较耗时
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderID->" + orderId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "The order Details Information";
        }, orderId);
        return submit;
    }

    @Override
    public void order(String account, long orderId) {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account " + account + ",orderId " + orderId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
