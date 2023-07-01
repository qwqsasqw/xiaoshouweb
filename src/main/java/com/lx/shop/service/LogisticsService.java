package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Logistics;
import com.lx.shop.vo.Result;
import org.apache.ibatis.annotations.Update;

public interface LogisticsService {

    Result saveLogistics(Logistics logistics);

    Result getLogistics(IPage<Logistics> page);

    Result updateLogistic(Integer logisticsId);
}
