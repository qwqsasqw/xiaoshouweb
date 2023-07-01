package com.lx.shop.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class UserInfo {

    @TableField("uinfo_id")
    private  Integer uInfoId;

    private Integer uid;

    private String uname;

    private Integer gender;

    private String birthday;

    private String phone;

    private String address;

    private String profile;

    private Double balance;

}
