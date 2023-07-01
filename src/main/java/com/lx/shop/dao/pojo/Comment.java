package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment")
public class Comment {

    @TableField("comment_id")
    private Integer commentId;

    private String username;

    private String text;

    @TableField("create_time")
    private String createTime;
}
