package com.lx.shop.controller;

import com.lx.shop.service.GoodsBrandService;
import com.lx.shop.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("goodsBrand")
public class GoodsBrandController {

    @Resource
    GoodsBrandService goodsBrandService;

    @GetMapping("get")
    public Result getGoodsBrand(){
        return goodsBrandService.getGoodsBrand();
    }
}
