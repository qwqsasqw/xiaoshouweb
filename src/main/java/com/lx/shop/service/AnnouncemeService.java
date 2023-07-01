package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Announceme;
import com.lx.shop.vo.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AnnouncemeService {


    Result getAnnounceByPage(IPage<Announceme> page);

    Result saveAnnounceme(Announceme announceme);

    Result groundAnnounceme(Integer anid);


    Result offShelfAnnounceme(Integer anid);
    Result getAnnounce(IPage<Announceme> page);
}
