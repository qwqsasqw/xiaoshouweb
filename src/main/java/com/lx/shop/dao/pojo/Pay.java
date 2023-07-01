package com.lx.shop.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pay")
public class Pay {

    private Integer pid;

    private String onum;

    private String username;

    private String pway;

    private String ptime;

    private Double total;


}
