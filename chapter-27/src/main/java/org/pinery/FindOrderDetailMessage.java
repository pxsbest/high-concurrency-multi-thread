package org.pinery;

import java.util.Map;

/**
 *
 **/
public class FindOrderDetailMessage extends MethodMessage {
    public FindOrderDetailMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        //1.执行orderService 的 findOrderDetails 方法
        Future<String> realFuture = orderService.findOrderDetails((Long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try {
            //2.调用 orderServiceImpl返回的 Future.get(),此方法会导致阻塞直到 findOrderDetails方法完全执行结束.
            String result = realFuture.get();
            //3. 当findOrderDetails 方法执行完毕,将结果返回给调用者.
            activeFuture.finish(result);
        } catch (InterruptedException e) {
            activeFuture.finish(null);
        }
    }
}
