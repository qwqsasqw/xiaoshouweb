package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.StarMapper;
import com.lx.shop.dao.pojo.Star;
import com.lx.shop.service.StarService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class StarServiceImpl implements StarService {

    @Resource
    StarMapper starMapper;

    @Override
    public Result saveStar(Star star) {
        return Result.success(starMapper.saveStar(star));
    }

    @Override
    public Result deleteStar(Star star) {

        return Result.success(starMapper.deleteStar(star));
    }

    @Override
    public Result findStarByUserNameAndGid(String username, Integer gid) {
        return Result.success(starMapper.findStarByUserNameAndGid(username,gid));
    }

    @Override
    public Result getStarByPage(IPage<Star> page,String username) {
        return Result.success(starMapper.getStarByPage(page,username).getRecords());
    }


}
