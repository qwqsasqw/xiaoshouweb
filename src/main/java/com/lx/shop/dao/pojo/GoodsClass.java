package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods_class")
public class GoodsClass {

    private Integer gcid;

    private String type;
}
