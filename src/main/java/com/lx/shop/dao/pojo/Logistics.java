package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("logistics")
public class Logistics {
    @TableField("logistics_id")
    private Integer logisticsId;

    private Integer status;

    @TableField("delivery_time")
    private String deliveryTime;

    @TableField("estimated_arrival_time")
    private String estimatedArrivalTime;

    private String uname;

    private String address;

    private String phone;

    @TableField("logistics_num")
    private String logisticsNum;

}
