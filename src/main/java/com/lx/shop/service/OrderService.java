package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Order;
import com.lx.shop.vo.Result;

public interface OrderService {

    Result reCharge(Order order);

    Result updateOrderStatus(String onum);

    Result createOrder(Order order);

    Result selectOrderByONum(String onum);

    Result getPayOrders(IPage<Order> page, String username);

    Result updateOrderStatusByAcceptRefund(String onum);
}
