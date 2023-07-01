package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.LoginMapper;
import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.service.AdministratorService;
import com.lx.shop.service.LoginService;
import com.lx.shop.service.UsersService;
import com.lx.shop.utils.JWTUtils;
import com.lx.shop.utils.MD5Utils;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.LoginParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    UsersService usersService;

    @Resource
    AdministratorService administratorService;

    @Resource
    LoginMapper loginMapper;

    @Override
    public Result login(LoginParam loginParam) {

        String username = loginParam.getUsername();
        String password = MD5Utils.inputPassToFormPass(loginParam.getPassword());
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        Users users = usersService.findUser(loginParam);
        if (users == null)
            return Result.error(ErrorCode.USER_PWD_ERROR.getCode(),  ErrorCode.USER_PWD_ERROR.getMsg());
        if (users.getStatus() == 1)
            return Result.error(ErrorCode.LOGIN_ED.getCode(), ErrorCode.LOGIN_ED.getMsg());
        String token = JWTUtils.createToken(users);
        users.setStatus(1);
        usersService.updateLoginStatus(users.getUsername());
        return Result.success(token);
    }


    @Override
    public Result adminLogin(Administrator loginParam) {

        String anum = loginParam.getAnum();
        String password = MD5Utils.inputPassToFormPass(loginParam.getPassword());
        if (StringUtils.isBlank(anum) || StringUtils.isBlank(password)) {
            return Result.error(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        Administrator administrator = (Administrator) administratorService.Login(loginParam).getData();
        if (administrator == null)
            return Result.error(ErrorCode.USER_PWD_ERROR.getCode(),  ErrorCode.USER_PWD_ERROR.getMsg());
        if (administrator.getStatus() == 1)
            return Result.error(ErrorCode.LOGIN_ED.getCode(), ErrorCode.LOGIN_ED.getMsg());
        String token = JWTUtils.createToken(administrator);
        administrator.setStatus(1);
        administratorService.updateLoginStatus(administrator.getAnum());
        return Result.success(token);
    }


    @Override
    public Result loginOut(String username) {
        return Result.success(usersService.loginOut(username));
    }
}
