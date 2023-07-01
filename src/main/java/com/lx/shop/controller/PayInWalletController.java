package com.lx.shop.controller;

import com.lx.shop.dao.pojo.Logistics;
import com.lx.shop.dao.pojo.Order;
import com.lx.shop.dao.pojo.OrderDetail;
import com.lx.shop.dao.pojo.Pay;
import com.lx.shop.service.*;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.OrderReferenceParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payInWallet")
@Transactional
public class PayInWalletController {

    @Resource
    UsersService usersService;
    @Resource
    LogisticsService logisticsService;
    @Resource
    OrderService orderService;
    @Resource
    OrderDetailService orderDetailService;
    @Resource
    PayService payService;
    @Resource
    GoodsInfoService goodsInfoService;
    @Resource
    CarService carService;

    @PostMapping("/payOrder")
    public Result payOrder(@RequestBody OrderReferenceParam orderReferenceParam){
        Order order =new Order();
        Pay pay =new Pay();
        Logistics logistics= new Logistics();
        OrderDetail orderDetail =new OrderDetail();
        order.setOnum(orderReferenceParam.getUsername()+System.currentTimeMillis());
        order.setTotalMoney(orderReferenceParam.getTotal());
        order.setUsername(orderReferenceParam.getUsername());
        pay.setOnum(order.getOnum());
        pay.setTotal(orderReferenceParam.getTotal());
        pay.setUsername(orderReferenceParam.getUsername());
        logistics.setAddress(orderReferenceParam.getAddress());
        logistics.setPhone(orderReferenceParam.getPhone());
        logistics.setUname(orderReferenceParam.getUname());
        logistics.setLogisticsNum("l"+orderReferenceParam.getUsername()+System.currentTimeMillis());
        orderDetail.setGid(orderReferenceParam.getGid());
        orderDetail.setGname(orderReferenceParam.getGname());
        orderDetail.setGnum(orderReferenceParam.getGnum());
        orderDetail.setOnum(order.getOnum());
        orderDetail.setLogisticsNum(logistics.getLogisticsNum());
        orderDetail.setTotal((double) (orderReferenceParam.getGnum()*orderReferenceParam.getGprice()));
        orderService.createOrder(order);
        goodsInfoService.updateStock(orderReferenceParam.getGid(),orderReferenceParam.getGnum());
        payService.savePay(pay);
        System.out.println(logistics);
        logisticsService.saveLogistics(logistics);
        orderDetailService.saveOrderDetail(orderDetail);
        usersService.changeUserBalance(orderReferenceParam.getUid(),orderReferenceParam.getTotal());
        orderService.updateOrderStatus(order.getOnum());

        return Result.success("success");
    }



    @PostMapping("/payCar")
    public Result payCar(@RequestBody List<OrderReferenceParam> orderReferenceParamList){
       for (OrderReferenceParam o:orderReferenceParamList){
           System.out.println(o);
       }
        Order order =new Order();
        Pay pay =new Pay();
        Logistics logistics= new Logistics();
        OrderDetail orderDetail =new OrderDetail();
        order.setOnum(orderReferenceParamList.get(0).getUsername()+System.currentTimeMillis());
        double totalMoney = 0;
        for(OrderReferenceParam orderReferenceParam : orderReferenceParamList){
            totalMoney+=orderReferenceParam.getTotal();
        }
        order.setTotalMoney(totalMoney);
        order.setUsername(orderReferenceParamList.get(0).getUsername());

        pay.setOnum(order.getOnum());
        pay.setTotal(totalMoney);
        pay.setUsername(orderReferenceParamList.get(0).getUsername());
        logistics.setAddress(orderReferenceParamList.get(0).getAddress());
        logistics.setPhone(orderReferenceParamList.get(0).getPhone());
        logistics.setUname(orderReferenceParamList.get(0).getUname());
        logistics.setLogisticsNum("l"+orderReferenceParamList.get(0).getUsername()+System.currentTimeMillis());
        orderService.createOrder(order);
        payService.savePay(pay);
        logisticsService.saveLogistics(logistics);
        for(OrderReferenceParam orderReferenceParam : orderReferenceParamList){


            orderDetail.setGid(orderReferenceParam.getGid());
            orderDetail.setGname(orderReferenceParam.getGname());
            orderDetail.setGnum(orderReferenceParam.getGnum());
            orderDetail.setOnum(order.getOnum());
            orderDetail.setLogisticsNum(logistics.getLogisticsNum());
            orderDetail.setTotal((double) (orderReferenceParam.getGnum()*orderReferenceParam.getGprice()));
            goodsInfoService.updateStock(orderReferenceParam.getGid(),orderReferenceParam.getGnum());
            orderDetailService.saveOrderDetail(orderDetail);

        }


        usersService.changeUserBalance(orderReferenceParamList.get(0).getUid(),totalMoney);
        carService.clearCarByUserName(orderReferenceParamList.get(0).getUsername());
        orderService.updateOrderStatus(order.getOnum());


        return Result.success("success");
    }
}
