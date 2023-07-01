package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Announceme;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AnnouncemeMapper extends BaseMapper<Announceme> {


    @Select("select  anid,anum,type,text,create_time,title,status from announceme")
    IPage<Announceme> getAnnounceByPage(IPage<Announceme> page);

    @Select("select  anid,anum,type,text,create_time,title,status from announceme where status=1")

    IPage<Announceme> getAnnounce(IPage<Announceme> page);

    @Insert("insert into announceme(anid,anum,type,text,create_time,title,status) values(0,#{anum},#{type},#{text},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{title},1)")
    int saveAnnounceme(Announceme announceme);

    @Update("update announceme set status = 1 where anid =#{anid}")
    int groundAnnounceme(Integer anid);


    @Update("update announceme set status = 0 where anid =#{anid}")
    int offShelfAnnounceme(Integer anid);
}
