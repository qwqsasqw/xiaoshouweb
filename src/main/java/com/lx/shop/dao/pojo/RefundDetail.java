package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("refund_detail")
public class RefundDetail {

    @TableField("red_id")
    private Integer redId;

    private String username;

    private String onum;

    private  String reason;

    private Integer status;

    private String anum;

    @TableField("detail_time")
    private String detailTime;

    @TableField("create_time")
    private String createTime;

    @TableField("refund_money")
    private Double refundMoney;
}
