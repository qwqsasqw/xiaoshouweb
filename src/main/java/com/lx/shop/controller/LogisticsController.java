package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Logistics;
import com.lx.shop.service.LogisticsService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/logistics")
@RestController
@Transactional
public class LogisticsController {

    @Resource
    LogisticsService logisticsService;

    @GetMapping("/getLogistics")
    public Result getLogistics(PageParams pageParams){
        IPage<Logistics> page =new Page<>();
        page.setSize(pageParams.getPageSize());
        page.setCurrent(pageParams.getPage());

        return logisticsService.getLogistics(page);
    }

    @GetMapping("/update")
    public Result updateLogistics(Integer logisticsId){
        return logisticsService.updateLogistic(logisticsId);
    }
}
