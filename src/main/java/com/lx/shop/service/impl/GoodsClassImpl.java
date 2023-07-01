package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.GoodsClassMapper;
import com.lx.shop.service.GoodsClassService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsClassImpl implements GoodsClassService {
    @Resource
    GoodsClassMapper goodsClassMapper;

    @Override
    public Result getGoodsClass() {
        return Result.success(goodsClassMapper.getGoodsClass());
    }
}
