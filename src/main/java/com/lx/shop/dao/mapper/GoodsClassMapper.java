package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.GoodsClass;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsClassMapper extends BaseMapper<GoodsClass> {

    @Select("select gcid,type from goods_class")
    List<GoodsClass> getGoodsClass();
}
