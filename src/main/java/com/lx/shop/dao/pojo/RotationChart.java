package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rotation_chart")
public class RotationChart {

    private Integer rid;

    private String anum;


    @TableField("add_time")
    private String addTime;

    private String img;

    private Integer status;
}
