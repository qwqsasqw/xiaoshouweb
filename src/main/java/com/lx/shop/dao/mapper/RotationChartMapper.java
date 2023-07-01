package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.RotationChart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RotationChartMapper extends BaseMapper<RotationChart> {

    @Insert("insert into rotation_chart(rid,anum,add_time,img,status) values(0,#{anum},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{img},1) ")
    int save(RotationChart rotationChart);

    @Update("update rotation_chart set status = 1 where rid =#{rid}")
    int ground(Integer rid);

    @Update("update rotation_chart set status = 0 where rid =#{rid}")
    int offShelf(Integer rid);

    @Select("select rid,anum,add_time,img,status from rotation_chart")
     IPage<RotationChart> getRotationChartByPage(IPage<RotationChart> page);

    @Delete("delete from rotation_chart where rid =#{rid}")
    int deleteByRid(Integer rid);
    @Select("select img from rotation_chart where status = 1")
    List<RotationChart> getRotation();
}
