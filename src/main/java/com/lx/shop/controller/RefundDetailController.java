package com.lx.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.mapper.RefundDetailMapper;
import com.lx.shop.dao.pojo.RefundDetail;
import com.lx.shop.dao.pojo.UserInfo;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.service.OrderService;
import com.lx.shop.service.RefundDetailService;
import com.lx.shop.service.UserInfoService;
import com.lx.shop.service.UsersService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/refund")
@Transactional
public class RefundDetailController {

    @Resource
    RefundDetailService refundDetailService;
    @Resource
    UsersService usersService;
    @Resource
    OrderService orderService;

    @Resource
    UserInfoService userInfoService;

    @PostMapping("/save")
    public Result saveRefund(@RequestBody RefundDetail refundDetail){

        return refundDetailService.savaRefundDetail(refundDetail);
    }

    @GetMapping("/get")
    public Result getRefund(PageParams pageParams){

        IPage<RefundDetail> page = new Page<>();
        page.setSize(pageParams.getPageSize());
        page.setCurrent(pageParams.getPage());
        return refundDetailService.getRefundDetailByPage(page);
    }

    @PostMapping("/updateRefundDetail")
    public Result updateRefundDetail(@RequestBody RefundDetail refundDetail){
        UserInfo userInfo = (UserInfo) usersService.getUserInfoByUserName(refundDetail.getUsername()).getData();
        refundDetailService.updateRefundDetail(refundDetail.getAnum(),refundDetail.getRedId());
        orderService.updateOrderStatusByAcceptRefund(refundDetail.getOnum());
        System.out.println(userInfo);
        userInfoService.updateUserInfoByAcceptRefund(userInfo.getUid(),refundDetail.getRefundMoney());
        return Result.success("退款成功");
    }

    @GetMapping("/refuseRefund")
    public Result refuseRefund(String anum,int redId){

        return refundDetailService.refuseRefundDetail(anum,redId);
    }
}
