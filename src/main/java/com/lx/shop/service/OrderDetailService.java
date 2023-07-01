package com.lx.shop.service;

import com.lx.shop.dao.pojo.OrderDetail;
import com.lx.shop.vo.Result;

public interface OrderDetailService {

   Result saveOrderDetail(OrderDetail orderDetail);

   Result getOrderDetailByOnum(String onum);
}
