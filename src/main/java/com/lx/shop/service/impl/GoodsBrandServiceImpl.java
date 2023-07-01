package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.GoodsBrandMapper;
import com.lx.shop.service.GoodsBrandService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {

    @Resource
    GoodsBrandMapper goodsBrandMapper;

    @Override
    public Result getGoodsBrand() {
        return Result.success(goodsBrandMapper.getGoodsBrand());
    }
}
