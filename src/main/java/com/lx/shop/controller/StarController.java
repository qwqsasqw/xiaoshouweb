package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Star;
import com.lx.shop.service.StarService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParamsAndUserName;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Transactional
@RequestMapping("/star")
public class StarController {

    @Resource
    StarService starService;

    @PostMapping("/save")
    public Result saveStar(@RequestBody Star star){

        return starService.saveStar(star);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Star star){

        return starService.deleteStar(star);
    }

    @GetMapping("/find")
    public Result find(String username,Integer gid){
        System.out.println("aaa"+" "+username+" "+gid);
        return Result.success(starService.findStarByUserNameAndGid(username,gid));
    }

    @GetMapping("/getStarByPage")
    public Result getStarByPage(PageParamsAndUserName pageParamsAndUserName){
        IPage<Star> page = new Page<>();
        page.setSize(pageParamsAndUserName.getPageSize());
        page.setCurrent(pageParamsAndUserName.getPage());
        return starService.getStarByPage(page,pageParamsAndUserName.getUsername());
    }


}
