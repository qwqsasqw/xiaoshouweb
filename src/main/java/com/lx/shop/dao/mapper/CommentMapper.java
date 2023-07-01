package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Comment;
import com.lx.shop.vo.params.GoodsInfoParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper extends BaseMapper<Comment> {

    @Insert("insert into comment(comment_id,username,text,create_time) values(0,#{username},#{text}, DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
    int saveComment(Comment comment);

    @Select("select comment_id,username,text  from comment ")
    IPage<Comment> getComment(IPage<Comment> page);
}
