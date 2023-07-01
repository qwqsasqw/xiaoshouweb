package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("administrator")
public class Administrator {

    private Integer aid;

    private String anum;

    private String password;

    @TableField("last_login_time")
    private String lastLoginTime;

    private Integer status;
}
