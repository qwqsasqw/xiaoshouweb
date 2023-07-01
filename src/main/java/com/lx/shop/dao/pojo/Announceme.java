package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("announceme")
public class Announceme {

    private Integer anid;

    private String anum;

    private String type;

    private String text;

    @TableField("create_time")
    private String createTime;

    private String title;

    private Integer status;
}
