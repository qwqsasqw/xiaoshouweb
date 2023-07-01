package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Logistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LogisticsMapper extends BaseMapper<Logistics> {

    @Insert("insert into logistics(logistics_id,status,delivery_time,estimated_arrival_time,uname,address,phone,logistics_num) values(0,0,DATE_FORMAT(now(),'%Y-%m-%d '),DATE_FORMAT(now(),'%Y-%m-%d' ),#{uname},#{address},#{phone},#{logisticsNum})")
    public int saveLogistics(Logistics logistics);

    @Select("select logistics_id,status,delivery_time,estimated_arrival_time,uname,address,phone,logistics_num from logistics where status =0")
    IPage<Logistics> getLogistics(IPage<Logistics> page);

    @Update("update logistics set status =1,delivery_time = DATE_FORMAT(now(),'%Y-%m-%d ') where  logistics_id =#{logisticsId}")
    int updateLogistic(Integer logisticsId);
}
