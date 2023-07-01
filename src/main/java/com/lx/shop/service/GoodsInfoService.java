package com.lx.shop.service;

import com.lx.shop.dao.pojo.GoodsInfo;
import com.lx.shop.vo.Result;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsInfoService {

    Result updateStock(Integer gid, Integer gnum);

    Result ground(Integer gid);

    Result offShelf(Integer gid);

    Result uploadGoodsImg(MultipartFile multipartFile);

    Result saveGoodsInfo(GoodsInfo goodsInfo);
}
