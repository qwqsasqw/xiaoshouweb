package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.MapKey;

@Data
@TableName("users")
public class Users {


    private Integer uid;

    private String username;

    private String password;

    @TableField("register_time")
    private String registerTime;

    @TableField("last_login_time")
    private String lastLoginTime;

    private Integer status;

    private String email;
}
