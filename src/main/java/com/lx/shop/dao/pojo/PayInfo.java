package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pay_info")
public class PayInfo {

    @TableField("pinfo_id")
    private Integer pInfoId;

    private String gname;

    private Double gprice;

    private Integer gnum;


    private Double total;

    private Integer pid;
}
