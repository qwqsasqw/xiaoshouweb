package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods_brand")
public class GoodsBrand {
    private Integer gbid;

    @TableField("gb_name")
    private String gbName;

}
