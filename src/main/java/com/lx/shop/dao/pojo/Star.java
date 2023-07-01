package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("star")
public class Star {

    private  Integer sid;

    private String username;

    private Integer gid;

    private String gname;

    private Double gprice;

    private String gdesc;

    private  String gimg;


    @TableField("create_time")
    private String createTime;
}
