package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.FootMapper;
import com.lx.shop.dao.pojo.Foot;
import com.lx.shop.service.FootService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class FootServiceImpl implements FootService {
    @Resource
    FootMapper footMapper;

    @Override
    public Result addToFoot(Foot foot) {
        return Result.success(footMapper.addToFoot(foot));
    }

    @Override
    public Result getFootByPage(IPage<Foot> page, String username) {
        return Result.success(footMapper.getFootByPage(page,username).getRecords());
    }

    @Override
    public Result updateFoot(Foot foot) {
        return Result.success(footMapper.updateFoot(foot));
    }

    @Override
    public Result findFootByGidAndUsername(Integer gid, String username) {
        return Result.success(footMapper.findFootByGidAndUsername(gid,username));
    }
}
