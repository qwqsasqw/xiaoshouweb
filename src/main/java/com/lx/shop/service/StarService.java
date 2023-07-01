package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Star;
import com.lx.shop.vo.Result;

public interface StarService {

    Result saveStar(Star star);

    Result deleteStar(Star star);

    Result findStarByUserNameAndGid(String username,Integer gid);

    Result getStarByPage(IPage<Star> page,String username);

}
