package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Announceme;
import com.lx.shop.service.AnnouncemeService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("announceme")
@Transactional
public class AnnouncemeController {

    @Resource
    AnnouncemeService announcemeService;

    @GetMapping("getAnnouncemeByPage")
    public Result getAnnouncemeByPage(PageParams pageParams){
        IPage<Announceme> page= new Page<>();
        page.setCurrent(pageParams.getPage());
        page.setSize(pageParams.getPageSize());

        return announcemeService.getAnnounceByPage(page);

    }

    @PostMapping("save")
    public Result saveAnnounceme(@RequestBody Announceme announceme){
        System.out.println(announceme);
        return announcemeService.saveAnnounceme(announceme);
    }
    @GetMapping("ground")
    public Result groundAnnounceme(Integer anid){
        return  announcemeService.groundAnnounceme(anid);
    }

    @GetMapping("offShelf")
    public Result offShelfAnnounceme(Integer anid){
        return  announcemeService.offShelfAnnounceme(anid);
    }

    @GetMapping("get")
    public Result get(PageParams pageParams){
        IPage<Announceme> page= new Page<>();
        page.setCurrent(pageParams.getPage());
        page.setSize(pageParams.getPageSize());

        return announcemeService.getAnnounce(page);
    }
}
