package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.CommentMapper;
import com.lx.shop.dao.pojo.Comment;
import com.lx.shop.service.CommentService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public Result saveComment(Comment comment) {
        return Result.success(commentMapper.saveComment(comment));
    }

    @Override
    public Result getComment(IPage<Comment> page) {
        return Result.success(commentMapper.getComment(page).getRecords());
    }


}
