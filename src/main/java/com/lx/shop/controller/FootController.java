package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Foot;
import com.lx.shop.service.FootService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import com.lx.shop.vo.params.PageParamsAndUserName;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Transactional
@RequestMapping("/foot")
@RestController
public class FootController {

    @Resource
    FootService footService;

    @PostMapping("/addToFoot")
    public Result addToFoot(@RequestBody  Foot foot){
        Foot foot1 = (Foot) footService.findFootByGidAndUsername(foot.getGid(),foot.getUsername()).getData();
        if(foot1!= null){
            return footService.updateFoot(foot1);
        }else{
            return footService.addToFoot(foot);
        }

    }

    @GetMapping("/getFootByPage")
    public Result getFootByPage(PageParamsAndUserName pageParamsAndUserName){
        IPage<Foot> page = new Page<>();
        page.setCurrent(pageParamsAndUserName.getPage());
        page.setSize(pageParamsAndUserName.getPageSize());
        return footService.getFootByPage(page,pageParamsAndUserName.getUsername());
    }

    @PostMapping("/updateFoot")
    public Result updateFoot(Foot foot){

        return footService.updateFoot(foot);
    }
}
