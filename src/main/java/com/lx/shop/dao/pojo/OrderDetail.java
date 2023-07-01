package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_detail")
public class OrderDetail {

    private Integer odid;

    private String onum;

    private String gname;

    private Integer gid;

    private Integer gnum;

    private Double total;


    @TableField("logistics_num")
    private String logisticsNum;

}
