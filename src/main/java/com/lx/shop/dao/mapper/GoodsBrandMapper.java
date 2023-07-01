package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.GoodsBrand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsBrandMapper extends BaseMapper<GoodsBrand> {

    @Select("select gbid,gb_name from goods_brand")
    List<GoodsBrand> getGoodsBrand();
}
