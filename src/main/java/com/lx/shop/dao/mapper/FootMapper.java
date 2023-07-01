package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Foot;
import com.lx.shop.vo.params.GoodsParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FootMapper extends BaseMapper<Foot> {

    @Insert("insert into foot(fid,gid,create_time,gname,gprice,gimg,gdesc,username) values(0,#{gid},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{gname},#{gprice},#{gimg},#{gdesc},#{username})")
    int addToFoot(Foot foot);

    @Update("update foot set create_time=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where gid =#{gid} and username =#{username}")
    int updateFoot(Foot foot);

    @Select(" select fid,gid,username from foot where gid = #{gid} and username = #{username}")
    Foot findFootByGidAndUsername(Integer gid ,String username);

    @Select("select fid,gid,create_time,gname,gprice,gimg,gdesc from foot where username =#{username} order by create_time desc")
    IPage<Foot> getFootByPage(IPage<Foot> page,String username);
}
