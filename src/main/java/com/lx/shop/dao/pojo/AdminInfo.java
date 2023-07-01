package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin_info")
public class AdminInfo {
    @TableField("a_info_id")
    private Integer aInfoId;

    private String aname;

    @TableField("aid_card")
    private String aidCard;

    private String birthday;

    private String photo;

    private Integer gender;

    private String address;

    private String phone;
}
