package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Goods;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.GoodsInfoParam;
import com.lx.shop.vo.params.GoodsParam;
import org.apache.ibatis.annotations.Insert;

public interface GoodsService {


     Result getAllGoodsInfo(IPage<GoodsParam> page);

     Result getGoodsInfoByGName(IPage<GoodsParam> page,String gname);

     Result getGoodsInfoByGid(String gid);

     Result getGoodsInfo(IPage<GoodsInfoParam> page);

     Result findGoodsByGname(String gname);

     Result saveGoods(Goods goods);

     Result getGoodsInfoByCondition(IPage<GoodsParam> page,Integer gclassId,Integer gbrandId,String sortFlag);
}
