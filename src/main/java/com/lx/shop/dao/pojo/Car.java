package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car")
public class Car {

    private Integer cid;

    private String gname;

    private Integer gnum;

    private Double total;

    private Double gprice;

    private String gimg;

    private Integer gid;

    private String gdesc;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;

    private String username;
}
