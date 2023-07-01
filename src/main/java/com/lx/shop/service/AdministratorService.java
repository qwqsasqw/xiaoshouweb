package com.lx.shop.service;

import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.vo.Result;


public interface AdministratorService {

    Result Login(Administrator administrator);

    Result updateLoginStatus(String anum);

    Result loginOut(String anum);
}
