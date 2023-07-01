package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.RefundDetail;
import com.lx.shop.vo.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface RefundDetailService {



    Result savaRefundDetail(RefundDetail refundDetail);

    Result updateRefundDetail(String anum,Integer redId);

    Result refuseRefundDetail(String anum,Integer redId);

    Result getRefundDetailByPage(IPage<RefundDetail> page);
}
