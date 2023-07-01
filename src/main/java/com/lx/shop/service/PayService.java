package com.lx.shop.service;

import com.lx.shop.dao.mapper.PayMapper;
import com.lx.shop.dao.pojo.Pay;
import com.lx.shop.vo.Result;

import javax.annotation.Resource;

public interface PayService {


    Result reChargePay(Pay pay);


     Result savePay(Pay pay);
}
