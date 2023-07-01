package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
@TableName("order")
public class Order {

    private Integer oid;

    private String onum;

    private String username;

    @TableField("order_time")
    private String orderTime;

    @TableField("order_status")
    private Integer orderStatus;

    @TableField("total_money")
    private Double totalMoney;

    @TableField("order_type")
    private Integer orderType;
}
