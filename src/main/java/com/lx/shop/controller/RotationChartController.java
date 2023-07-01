package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.RotationChart;
import com.lx.shop.service.RotationChartService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@Transactional
@RequestMapping("rotationChart")
public class RotationChartController {

    @Resource
    RotationChartService rotationChartService;

    @PostMapping("/uploadRotationChart")
    public Result uploadRotationChart(@RequestParam("file")MultipartFile multipartFile){

        return rotationChartService.upLoadRotationChartImg(multipartFile);
    }

    @PostMapping("/save")
    public Result save(@RequestBody  RotationChart rotationChart){
        return rotationChartService.save(rotationChart);
    }

    @GetMapping("/ground")
    public Result ground(Integer rid){
        return rotationChartService.ground(rid);
    }


    @GetMapping("/offShelf")
    public Result offShelf(Integer rid){
        return rotationChartService.offShelf(rid);
    }

    @GetMapping("/getRotationChart")
    public Result getRotationChart(PageParams pageParams){
        IPage<RotationChart> page= new Page<>();
        page.setCurrent(pageParams.getPage());
        page.setSize(pageParams.getPageSize());

        return rotationChartService.getRotationChartByPage(page);
    }

    @GetMapping("/delete")
    public Result deleteRotationChart(Integer rid){
        return rotationChartService.deleteByRid(rid);
    }

    @GetMapping("/get")
    public Result get(){
        return rotationChartService.getRotation();
    }
}
