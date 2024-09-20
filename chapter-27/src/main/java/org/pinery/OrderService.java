package org.pinery;

import org.pinery.common.ActiveMethod;

/**
 *
 **/
public interface OrderService {
    /**
     * 根据订单编号查询订单明细,有入参也有返回值,但是返回值类型必须是 Future
     */
    @ActiveMethod
    Future<String> findOrderDetails(long orderId);

    /**
     * 提交订单,没有返回值
     */
    void order(String account, long orderId);
}
