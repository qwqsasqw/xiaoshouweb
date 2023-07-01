package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.LogisticsMapper;
import com.lx.shop.dao.pojo.Logistics;
import com.lx.shop.service.LogisticsService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LogisticsServiceImpl implements LogisticsService {

    @Resource
    LogisticsMapper logisticsMapper;

    @Override
    public Result saveLogistics(Logistics logistics) {
        return Result.success(logisticsMapper.saveLogistics(logistics));
    }

    @Override
    public Result getLogistics(IPage<Logistics> page) {
        return Result.success(logisticsMapper.getLogistics(page).getRecords());
    }

    @Override
    public Result updateLogistic(Integer logisticsId) {
        return Result.success(logisticsMapper.updateLogistic(logisticsId));
    }
}
