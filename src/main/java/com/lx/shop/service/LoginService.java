package com.lx.shop.service;

import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);
    Result loginOut(String username);

   Result adminLogin(Administrator loginParam);
}
