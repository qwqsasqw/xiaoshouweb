package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {
    private  Integer gid;

    private String gname;

    @TableField("gclass_id")
    private Integer gclassId;

    @TableField("gbrand_id")
    private Integer gbrandId;
}
