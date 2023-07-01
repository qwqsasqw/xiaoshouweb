package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods_info")
public class GoodsInfo {

    @TableField("ginfo_id")
    private Integer gInfoId;

    private Integer gid;

    private Integer gstock;

    private Double gprice;

    private Double gcurrent;

    private String gimg;

    private Integer gsales;

    private String gdesc;

    private Double gweight;

}
