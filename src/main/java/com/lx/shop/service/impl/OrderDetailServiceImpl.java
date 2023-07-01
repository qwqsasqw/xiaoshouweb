package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.OrderDetailMapper;
import com.lx.shop.dao.pojo.OrderDetail;
import com.lx.shop.service.OrderDetailService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    OrderDetailMapper orderDetailMapper;

    @Override
    public Result saveOrderDetail(OrderDetail orderDetail) {
        return Result.success(orderDetailMapper.saveOrderDetail(orderDetail));
    }

    @Override
    public Result getOrderDetailByOnum(String onum) {
        return Result.success(orderDetailMapper.getOrderDetailByOnum(onum));
    }
}
