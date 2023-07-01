package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.PayMapper;
import com.lx.shop.dao.pojo.Pay;
import com.lx.shop.service.PayService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class PayServiceImpl implements PayService {
    @Resource
    PayMapper payMapper;

    @Override
    public Result reChargePay(Pay pay) {

        return Result.success(payMapper.reChargePay(pay));
    }

    @Override
    public Result savePay(Pay pay) {
        return Result.success(payMapper.savePay(pay));
    }
}
