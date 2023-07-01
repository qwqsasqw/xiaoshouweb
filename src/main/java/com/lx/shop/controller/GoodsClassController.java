package com.lx.shop.controller;

import com.lx.shop.service.GoodsClassService;
import com.lx.shop.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("goodsClass")
public class GoodsClassController {

    @Resource
    GoodsClassService goodsClassService;

    @GetMapping("get")
    public Result getGoodsClass(){
        return goodsClassService.getGoodsClass();
    }
}
