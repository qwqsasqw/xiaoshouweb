package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Comment;
import com.lx.shop.vo.Result;

public interface CommentService {

    Result saveComment(Comment comment);

    Result getComment(IPage<Comment> page);
}
