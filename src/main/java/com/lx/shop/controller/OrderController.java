package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Order;
import com.lx.shop.service.OrderService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParamsAndUserName;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Transactional
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/reCharge")
    public Result reCharge(@RequestBody Order order){
        order.setOnum(order.getUsername()+System.currentTimeMillis());
        return orderService.reCharge(order);
    }

    @GetMapping("/getPayOrder")
    public Result getPayOrder(PageParamsAndUserName pageParamsAndUserName){
        IPage<Order> page = new Page<>();
        page.setCurrent(pageParamsAndUserName.getPage());
        page.setSize(pageParamsAndUserName.getPageSize());
        return orderService.getPayOrders(page,pageParamsAndUserName.getUsername());
    }
}
