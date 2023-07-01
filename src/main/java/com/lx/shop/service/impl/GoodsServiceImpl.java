package com.lx.shop.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.GoodsInfoMapper;
import com.lx.shop.dao.mapper.GoodsMapper;
import com.lx.shop.dao.pojo.Goods;
import com.lx.shop.service.GoodsService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.GoodsInfoParam;
import com.lx.shop.vo.params.GoodsParam;
import com.lx.shop.vo.params.PageParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public Result getAllGoodsInfo(IPage<GoodsParam> page) {

        return Result.success(goodsMapper.getGoodsInfoByPage(page).getRecords());
    }

    @Override
    public Result getGoodsInfoByGName(IPage<GoodsParam> page, String gname) {
        return Result.success(goodsMapper.getGoodsInfoByGName(page,gname).getRecords());
    }

    @Override
    public Result getGoodsInfoByGid(String gid) {
        return Result.success(goodsMapper.getGoodsInfoByGid(gid));
    }

    @Override
    public Result getGoodsInfo(IPage<GoodsInfoParam> page) {
        return Result.success(goodsMapper.getGoodsInfo(page).getRecords());
    }

    @Override
    public Result findGoodsByGname(String gname) {
        return Result.success(goodsMapper.findGoodsByGname(gname));
    }

    @Override
    public Result saveGoods(Goods goods) {
        return Result.success(goodsMapper.saveGoods(goods));
    }

    @Override
    public Result getGoodsInfoByCondition(IPage<GoodsParam> page,Integer gclassId,Integer gbrandId,String sortFlag) {
        return Result.success(goodsMapper.getGoodsInfoByCondition(page,gclassId,gbrandId,sortFlag).getRecords());
    }
}
