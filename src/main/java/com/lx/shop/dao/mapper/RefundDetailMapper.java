package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.RefundDetail;
import com.lx.shop.vo.params.GoodsParam;
import com.lx.shop.vo.params.PageParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RefundDetailMapper extends BaseMapper<RefundDetail> {


    @Insert("insert into refund_detail(red_id,username,onum,reason,status,anum,detail_time,create_time,refund_money) values(0,#{username},#{onum},#{reason},0,null,null,DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{refundMoney})")
    int savaRefundDetail(RefundDetail refundDetail);

    @Update("update refund_detail set anum =#{anum},status =1,detail_time = DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where red_id =#{redId} and status =0 ")
    int updateRefundDetail(String anum,Integer redId);

    @Update("update refund_detail set anum =#{anum},status =2,detail_time = DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where red_id =#{redId} and status =0 ")
    int refuseRefundDetail(String anum,Integer redId);

    @Select("select red_id,username,onum,reason,status,anum,detail_time,create_time,refund_money from refund_detail  where status =0 ")
    IPage<RefundDetail> getRefundDetailByPage(IPage<RefundDetail> page);
}
