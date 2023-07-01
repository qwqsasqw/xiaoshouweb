package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("discuss")
public class Discuss {

    private Integer did;

    private String username;

    private Integer gid;

    private String gname;

    private Double gprcie;

    private String gdesc;

    private String gimg;

    @TableField("create_time")
    private String createTime;

    private String text;

    private Integer stars;
}
