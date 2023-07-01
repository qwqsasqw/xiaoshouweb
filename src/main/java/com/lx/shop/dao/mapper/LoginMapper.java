package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.vo.params.LoginParam;
import org.apache.ibatis.annotations.Update;

public interface LoginMapper extends BaseMapper<Users> {


    public Users selectOne(LoginParam LoginParam);


}
