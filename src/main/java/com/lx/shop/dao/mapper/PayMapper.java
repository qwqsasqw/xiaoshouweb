package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.Pay;
import org.apache.ibatis.annotations.Insert;

public interface PayMapper extends BaseMapper<Pay> {

    @Insert("insert into pay(pid,onum,username,pway,ptime,total) values(0,#{onum},#{username},'支付宝',DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{total})")
    public int reChargePay(Pay pay);

    @Insert("insert into pay(pid,onum,username,pway,ptime,total) values(0,#{onum},#{username},'钱包',DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),#{total})")
    public int savePay(Pay pay);
}
