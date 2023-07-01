package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("foot")
public class Foot {

    private Integer fid;

    private Integer gid;


    @TableField("create_time")
    private String createTime;

    private String gname;

    private Double gprice;

    private String gimg;

    private String gdesc;

    private String username;
}
