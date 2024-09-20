package org.pinery;

import java.util.Map;

/**
 * @Author gensci
 * @DateTime 2024/9/11 9:19
 * @Description
 **/
public class OrderMessage extends MethodMessage {

    public OrderMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }


    @Override
    public void execute() {
        String account = (String) params.get("account");
        long orderId = (long) params.get("orderId");
        //执行真正的 order方法
        orderService.order(account,orderId);
    }

}
