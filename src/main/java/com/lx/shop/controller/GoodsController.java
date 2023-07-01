package com.lx.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Goods;
import com.lx.shop.service.GoodsInfoService;
import com.lx.shop.service.GoodsService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @Resource
    GoodsInfoService goodsInfoService;

    @GetMapping("/getAllGoodsInfo")
    public Result getAllGoodsInfo(PageParams pageParams){
        IPage<GoodsParam> page = new Page<>();
        page.setSize(pageParams.getPageSize());
        page.setCurrent(pageParams.getPage());
        System.out.println(pageParams);
        return goodsService.getAllGoodsInfo(page);
    }

    @GetMapping("/getGoodsInfoByGid")
    public Result getGoodsInfoByGid(String gid){
        return goodsService.getGoodsInfoByGid(gid);
    }


    @GetMapping("/getGoodsInfoByGName")
    public Result getGoodsInfoByGName(PageParamsAndGName pageParamsAndGName){
        IPage<GoodsParam> page = new Page<>();
        page.setSize(pageParamsAndGName.getPageSize());
        page.setCurrent(pageParamsAndGName.getPage());
        String gname ="%" +pageParamsAndGName.getGname()+"%";
        return goodsService.getGoodsInfoByGName(page,gname);
    }

    @GetMapping("/getGoodsInfo")
    public Result getGoodsInfo(PageParams pageParams){
        IPage<GoodsInfoParam> page = new Page<>();
        page.setSize(pageParams.getPageSize());
        page.setCurrent(pageParams.getPage());

        return goodsService.getGoodsInfo(page);
    }

    @GetMapping("/ground")
    public Result ground(Integer gid){



        return goodsInfoService.ground(gid);
    }

    @GetMapping("/offShelf")
    public Result offShelf(Integer gid){


        return goodsInfoService.offShelf(gid);
    }

    @GetMapping("/getGoodsInfoByCondition")
     public Result getGoodsInfoByCondition(@Param("page") Integer page,@Param("pageSize")Integer pageSize,@Param("gclassId") Integer gclassId, @Param("gbrandId") Integer gbrandId,@Param("sortFlag") String sortFlag){
        System.out.println("页数："+page+"容量："+pageSize+"类型:"+gclassId+"品牌："+gbrandId+"标志"+sortFlag);
        IPage<GoodsParam> paramIPage =new Page<>();
        paramIPage.setSize(pageSize);
        paramIPage.setCurrent(page);
        Goods goods = new Goods();
        goods.setGbrandId(gbrandId);
        goods.setGclassId(gclassId);
        return goodsService.getGoodsInfoByCondition(paramIPage,gclassId,gbrandId,sortFlag);

    }

}
