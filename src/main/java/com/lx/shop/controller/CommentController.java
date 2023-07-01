package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Comment;
import com.lx.shop.service.CommentService;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Transactional
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    @PostMapping("/saveComment")
    public Result saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }


    @GetMapping("/getComment")
    public Result getComment(PageParams pageParams){
        IPage<Comment> page = new Page<>();
        page.setCurrent(pageParams.getPage());
        page.setSize(pageParams.getPageSize());

        return commentService.getComment(page);
    }
}
