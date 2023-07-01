package com.lx.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.service.UsersService;
import com.lx.shop.utils.MD5Utils;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.PageParams;
import com.lx.shop.vo.params.UserParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Transactional
public class UserController {

    @Resource
    UsersService usersService;

    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody Users users){
        String password = MD5Utils.md5(users.getPassword());
        users.setPassword(password);
        usersService.insert(users);
        Users users1 =(Users) usersService.getUsersByUserName(users.getUsername()).getData();

        usersService.creatDefaultUserInfo(users1.getUid());
        return Result.success("success");
    }

    @GetMapping("/usernameIsExist")
    public Result usernameIsExist(String username){

        return usersService.findUsersByUserName(username);
    }


    @GetMapping("/getUserInfoByUsername")
    public Result getUserInfoByUsername(String username){

        return usersService.getUserInfoByUserName(username);
    }

    @GetMapping("/emailIsExit")
    public Result emailIsExit(String email){

        return usersService.emailIsExist(email);
    }

    @GetMapping("/emailIsExitByUserName")
    public Result emailIsExitByUserName(String email,String username){

        return usersService.emailIsExistByUserName(email,username);
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody  Users users){
        String password  = MD5Utils.md5(users.getPassword());
        users.setPassword(password);
        usersService.changePassword(users);
        usersService.loginOut(users.getUsername());
        return Result.success("修改成功");
    }

    @GetMapping("/getUserInfoByPage")
    public Result getUserInfoByPage(PageParams pageParams){
        IPage<UserParam> page = new Page<>();
        page.setCurrent(pageParams.getPage());
        page.setSize(pageParams.getPageSize());

        return usersService.getUserInfoByPage(page);
    }


}
