package com.lx.shop.controller;

import com.lx.shop.dao.pojo.Goods;
import com.lx.shop.dao.pojo.GoodsInfo;
import com.lx.shop.service.GoodsInfoService;
import com.lx.shop.service.GoodsService;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.AddGoodsParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsInfo")
@Transactional
public class GoodsInfoController {

    @Resource
    GoodsInfoService goodsInfoService;
    @Resource
    GoodsService goodsService;

    @PostMapping("/uploadGoodsImg")

    public Result uploadGoodsImg(@RequestParam("file") MultipartFile multipartFile) {
        return goodsInfoService.uploadGoodsImg(multipartFile);
    }

    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody AddGoodsParams addGoodsParams){
        String gname = addGoodsParams.getGname();
        List<Goods> goodsList = (List<Goods>) goodsService.findGoodsByGname(gname).getData();
        if(goodsList.size() >0){
            return Result.error(ErrorCode.GOODS_IS_EXIST.getCode(),ErrorCode.GOODS_IS_EXIST.getMsg());
        }else {
            Goods goods1 =new Goods();
            goods1.setGname(addGoodsParams.getGname());
            goods1.setGbrandId(addGoodsParams.getGbrandId());
            goods1.setGclassId(addGoodsParams.getGclassId());
            System.out.println(addGoodsParams);
            goodsService.saveGoods(goods1);
            Goods goods2 =  ((List<Goods>) goodsService.findGoodsByGname(gname).getData()).get(0);
            Integer gid = goods2.getGid();
            GoodsInfo goodsInfo= new GoodsInfo();
            goodsInfo.setGid(gid);
            goodsInfo.setGcurrent(addGoodsParams.getGcurrent());
            goodsInfo.setGprice(addGoodsParams.getGprice());
            goodsInfo.setGdesc(addGoodsParams.getGdesc());
            goodsInfo.setGimg(addGoodsParams.getGimg());
            goodsInfo.setGstock(addGoodsParams.getGstock());
            goodsInfo.setGweight(addGoodsParams.getGweight());
            goodsInfoService.saveGoodsInfo(goodsInfo);
            return Result.success("success");
        }

    }
}
