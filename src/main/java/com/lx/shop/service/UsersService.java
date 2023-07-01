package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.LoginParam;
import com.lx.shop.vo.params.UserParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersService {


    Result findUsersByUserName(String username);

    Result getUsersByUserName(String username);

    Users findUser(LoginParam LoginParam);

    Result updateLoginStatus(String username);

    Result insert(Users user);

    Result loginOut(String username);

    Result getUserInfoByUserName(String username);

    Result reChargeUserBalance(int uid,double balance);


    Result emailIsExist(String email);


    Result emailIsExistByUserName(String email,String username);

    Result changePassword(Users users);

    Result creatDefaultUserInfo(int uid);

    Result changeUserBalance(int uid,double totalMoney);

    Result getUserInfoByPage(IPage<UserParam> page);
}
