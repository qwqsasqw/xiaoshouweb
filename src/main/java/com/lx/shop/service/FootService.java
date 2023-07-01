package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Foot;
import com.lx.shop.vo.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface FootService {

    Result addToFoot(Foot foot);

    Result getFootByPage(IPage<Foot> page, String username);

    Result updateFoot(Foot foot);

    Result findFootByGidAndUsername(Integer gid ,String username);
}
