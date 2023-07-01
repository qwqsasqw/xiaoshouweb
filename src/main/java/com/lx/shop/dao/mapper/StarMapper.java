package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Star;
import com.lx.shop.vo.params.GoodsParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StarMapper extends BaseMapper<Star> {

    @Insert("insert into star(sid,username,gid,gname,gprice,gdesc,gimg,create_time) values(0,#{username},#{gid},#{gname},#{gprice},#{gdesc},#{gimg},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
    int saveStar(Star star);


    @Delete("delete from star where username =#{username} and gid =#{gid}")
    int deleteStar(Star star);

    @Select("select sid from star where username =#{username} and gid=#{gid}")
    Star findStarByUserNameAndGid(String username, Integer gid);


    @Select("select sid,username,gid,gname,gprice,gdesc,gimg from star where username =#{username} order by create_time")
    IPage<Star> getStarByPage(IPage<Star> page, String username);
}
