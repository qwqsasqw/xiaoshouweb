package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.GoodsInfo;
import com.lx.shop.vo.params.AddGoodsParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface  GoodsInfoMapper extends BaseMapper<GoodsInfo> {

    @Update("update goods_info set gstock=gstock -#{gnum} , gsales = gsales+#{gnum} where gstock>#{gnum} and gid =#{gid}")
    int updateStock(Integer gid,Integer gnum);

    @Update("update goods_info set gstock =100 where gid=#{gid}")
    int ground(Integer gid);

    @Update("update goods_info set gstock =0 where gid=#{gid}")
    int offShelf(Integer gid);

    @Insert("insert into goods_info(ginfo_id,gid,gstock,gprice,gcurrent,gimg,gsales,gdesc,gweight) values(0,#{gid},#{gstock},#{gprice},#{gcurrent},#{gimg},0,#{gdesc},#{gweight})")
    int saveGoodsInfo(GoodsInfo goodsInfo);
}
