package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Order;
import com.lx.shop.vo.params.GoodsParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper extends BaseMapper<Order> {

    @Insert("insert into orders(oid,onum,username,order_time,order_status,total_money,order_type) values(0,#{onum},#{username},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),0,#{totalMoney},0)")
    public int reCharge(Order order);

    @Insert("insert into orders(oid,onum,username,order_time,order_status,total_money,order_type) values(0,#{onum},#{username},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),0,#{totalMoney},1)")
    public int createOrder(Order order);

    @Update("update orders set order_status =1 where onum = #{onum} and order_status =0")
    public int updateOrderStatus(String onum);

    @Update("update orders set order_status =3 where onum = #{onum} and order_status =1")
    public int updateOrderStatusByAcceptRefund(String onum);


    @Select("select oid,onum,username,order_time,order_status,total_money,order_type from orders where order_type =0 and onum =#{onum}")
    public Order selectOrderByONum(String onum);



    @Select("select oid,onum,username,order_time,total_money,order_type,order_status from orders where username=#{username} and order_status=1 and order_type = 1")
    IPage<Order> getPayOrders(IPage<Order> page, String username);

}
