package com.lx.shop.controller;

import com.lx.shop.service.OrderDetailService;
import com.lx.shop.vo.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderDetail")
@Transactional
public class OrderDetailController {

    @Resource
    OrderDetailService orderDetailService;
    @GetMapping("/getOrderDetailByOnum")
    public Result getOrderDetailByOnum(String onum){

        return orderDetailService.getOrderDetailByOnum(onum);
    }
}
