package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.shop.dao.pojo.UserInfo;
import org.apache.ibatis.annotations.Update;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Update("update user_info set uname = #{uname},gender = #{gender} ,birthday =#{birthday},phone = #{phone},address =#{address},profile=#{profile} where uid = #{uid}")
    int updateUserInfo(UserInfo userInfo);

    @Update("update user_info set balance = balance +#{balance} where uid = #{uid}")
    int updateUserInfoByAcceptRefund(Integer uid,Double balance);
}
