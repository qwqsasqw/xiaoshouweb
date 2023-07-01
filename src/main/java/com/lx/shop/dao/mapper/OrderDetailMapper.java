package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    @Insert("insert into order_detail(odid,onum,gname,gid,gnum,total,logistics_num) values(0,#{onum},#{gname},#{gid},#{gnum},#{total},#{logisticsNum})")
    int saveOrderDetail(OrderDetail orderDetail);

    @Select("select odid,onum,gname,gid,gnum,total,logistics_num from order_detail where onum =#{onum}")
    List<OrderDetail> getOrderDetailByOnum(String onum);
}
