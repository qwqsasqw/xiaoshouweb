package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.Administrator;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdministratorMapper extends BaseMapper<Administrator> {

    @Select("select anum,status,password from administrator where anum =#{anum} and password =#{password} ")
    Administrator Login(Administrator administrator);

    @Update("update administrator set status =1 ,last_login_time =DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where anum =#{anum} ")
    int updateLoginStatus(String anum);

    @Update("update administrator set status =0  where anum =#{anum} ")
    int loginOut(String anum);


}
