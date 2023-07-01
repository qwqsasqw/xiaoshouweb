package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.AnnouncemeMapper;
import com.lx.shop.dao.pojo.Announceme;
import com.lx.shop.service.AnnouncemeService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AnnouncemeServiceImpl implements AnnouncemeService {
    @Resource
    AnnouncemeMapper announcemeMapper;

    @Override
    public Result getAnnounceByPage(IPage<Announceme> page) {
        return Result.success(announcemeMapper.getAnnounceByPage(page).getRecords());
    }

    @Override
    public Result saveAnnounceme(Announceme announceme) {
        return Result.success(announcemeMapper.saveAnnounceme(announceme));
    }

    @Override
    public Result groundAnnounceme(Integer anid) {
        return Result.success(announcemeMapper.groundAnnounceme(anid));
    }

    @Override
    public Result offShelfAnnounceme(Integer anid) {
        return Result.success(announcemeMapper.offShelfAnnounceme(anid));
    }

    @Override
    public Result getAnnounce(IPage<Announceme> page) {
        return Result.success(announcemeMapper.getAnnounce(page).getRecords());
    }
}
