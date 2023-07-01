package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.UsersMapper;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.service.UsersService;
import com.lx.shop.utils.MD5Utils;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.LoginParam;
import com.lx.shop.vo.params.UserParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public Result findUsersByUserName(String username) {
        Users users = usersMapper.selectUsersByUserName(username);
        if(users!=null){
            return Result.error(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }else {
            return Result.success(usersMapper.selectUsersByUserName(username));
        }

    }

    @Override
    public Result getUsersByUserName(String username) {

        return Result.success(usersMapper.selectUsersByUserName(username));

    }

    @Override
    public Users findUser(LoginParam loginParam) {
        return usersMapper.findUser(loginParam);
    }

    @Override
    public Result updateLoginStatus(String username) {
        return Result.success(usersMapper.updateLoginStatus(username));
    }


    @Override
    public Result insert(Users user) {

        return Result.success(usersMapper.insert(user));
    }

    @Override
    public Result loginOut(String username) {
        return Result.success(usersMapper.loginOut(username));
    }

    @Override
    public Result getUserInfoByUserName(String username) {
        Users user=usersMapper.getUserByUserName(username);
        if(user!=null){
            return Result.success(usersMapper.getUserInfoByUserName(user.getUid()));
        }else {
            return Result.error(ErrorCode.ACCOUNT_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_NOT_EXIST.getMsg());
        }
    }

    @Override
    public Result reChargeUserBalance(int uid, double balance) {
        return Result.success(usersMapper.reChargeUserBalance(uid,balance));
    }

    @Override
    public Result emailIsExist(String email) {
        Users users = usersMapper.emailIsExist(email);
        if(users!=null){
            return Result.success(users);
        }else{
            return Result.error(ErrorCode.EMAIL_NOT_EXIST.getCode(),ErrorCode.EMAIL_NOT_EXIST.getMsg());
        }
    }

    @Override
    public Result emailIsExistByUserName(String email, String username) {
        Users users = usersMapper.emailIsExistByUserName(email,username);
        if(users!=null){
            return Result.success(users);
        }else {
            return Result.error(ErrorCode.EMAIL_NOT_EXIST.getCode(), ErrorCode.EMAIL_NOT_EXIST.getMsg());
        }
    }

    @Override
    public Result changePassword(Users users) {
        return Result.success(usersMapper.changePassword(users));
    }

    @Override
    public Result creatDefaultUserInfo(int uid) {
        return Result.success(usersMapper.creatDefaultUserInfo(uid));
    }

    @Override
    public Result changeUserBalance(int uid, double totalMoney) {
        return Result.success(usersMapper.changeUserBalance(uid,totalMoney));
    }

    @Override
    public Result getUserInfoByPage(IPage<UserParam> page) {
        return Result.success(usersMapper.getUserInfoByPage(page).getRecords());
    }
}
