package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.RefundDetailMapper;
import com.lx.shop.dao.pojo.RefundDetail;
import com.lx.shop.service.RefundDetailService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RefundDetailServiceImpl implements RefundDetailService {

    @Resource
    RefundDetailMapper refundDetailMapper;

    @Override
    public Result savaRefundDetail(RefundDetail refundDetail) {
        return Result.success(refundDetailMapper.savaRefundDetail(refundDetail));
    }

    @Override
    public Result updateRefundDetail(String anum, Integer redId) {
        return Result.success(refundDetailMapper.updateRefundDetail(anum,redId));
    }

    @Override
    public Result refuseRefundDetail(String anum, Integer redId) {
        return Result.success(refundDetailMapper.refuseRefundDetail(anum,redId));
    }

    @Override
    public Result getRefundDetailByPage(IPage<RefundDetail> page) {
        return Result.success(refundDetailMapper.getRefundDetailByPage(page).getRecords());
    }
}
