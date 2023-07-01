package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.OrderMapper;
import com.lx.shop.dao.pojo.Order;
import com.lx.shop.service.OrderService;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional

public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;


    @Override
    public Result reCharge(Order order) {
        int flag = orderMapper.reCharge(order);
        if(flag>0){
            return Result.success(order);
        }else {
            return Result.error(ErrorCode.SESSION_TIME_OUT.getCode(),ErrorCode.SESSION_TIME_OUT.getMsg());
        }
    }

    @Override
    public Result updateOrderStatus(String onum) {
        return Result.success(orderMapper.updateOrderStatus(onum));
    }

    @Override
    public Result createOrder(Order order) {
        return Result.success(orderMapper.createOrder(order));
    }

    @Override
    public Result selectOrderByONum(String onum) {
        return Result.success(orderMapper.selectOrderByONum(onum));
    }


    @Override
    public Result getPayOrders(IPage<Order> page, String username) {
        return Result.success(orderMapper.getPayOrders(page,username).getRecords());
    }

    @Override
    public Result updateOrderStatusByAcceptRefund(String onum) {
        return Result.success(orderMapper.updateOrderStatusByAcceptRefund(onum));
    }
}
