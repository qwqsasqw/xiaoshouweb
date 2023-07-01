package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Goods;
import com.lx.shop.vo.params.GoodsInfoParam;
import com.lx.shop.vo.params.GoodsParam;
import com.lx.shop.vo.params.PageParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select g.gid,g.gname,gi.gstock,gi.gprice,gi.gcurrent,gi.gimg,gi.gdesc,gi.gsales,gi.gweight from goods g left join goods_info gi on g.gid = gi.gid and gi.gstock>0")
    IPage<GoodsParam> getGoodsInfoByPage(IPage<GoodsParam> page);

    @Select("select g.gid,g.gname,gi.gstock,gi.gprice,gi.gcurrent,gi.gimg,gi.gdesc,gi.gsales,gi.gweight from goods g left join goods_info gi on g.gid = gi.gid where gname like #{gname} gi.gstock>0 ")
    IPage<GoodsParam> getGoodsInfoByGName(IPage<GoodsParam> page,String gname);

    @Select("select g.gid,g.gname,gi.gstock,gi.gprice,gi.gcurrent,gi.gimg,gi.gdesc,gi.gsales,gi.gweight from goods g left join goods_info gi on g.gid = gi.gid where g.gid = #{gid} ")
    GoodsParam getGoodsInfoByGid(String gid);
    @Select("select g.gid,gi.gimg,g.gname,gc.type,gb.gb_name,gi.gdesc,gi.gprice,gi.gcurrent,gi.gsales,gi.gweight,gi.gstock from goods g,goods_info gi,goods_class gc,goods_brand gb where g.gclass_id =gc.gcid and g.gbrand_id = gb.gbid and g.gid = gi.gid")
    IPage<GoodsInfoParam> getGoodsInfo(IPage<GoodsInfoParam> page);

    IPage<GoodsParam> getGoodsInfoByCondition(IPage<GoodsParam> page,Integer gclassId,Integer gbrandId,String sortFlag);

    @Select("select gid,gname from goods where gname =#{gname}")
    List<Goods> findGoodsByGname(String gname);

    @Insert("insert into goods(gid,gname,gclass_id,gbrand_id) values(0,#{gname},#{gclassId},#{gbrandId})")
    int saveGoods(Goods goods);
}
