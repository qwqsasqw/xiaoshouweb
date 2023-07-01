package com.lx.shop.controller;

import com.lx.shop.dao.pojo.Users;
import com.lx.shop.service.LoginService;
import com.lx.shop.utils.MD5Utils;
import com.lx.shop.vo.Result;
import com.lx.shop.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
@Transactional
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("userLogin")
    public Result login(@RequestBody LoginParam loginParam) {
        String password = MD5Utils.md5(loginParam.getPassword());
        loginParam.setPassword(password);
        return loginService.login(loginParam);
    }

    @PostMapping("loginOut")
    public Result loginOut(@RequestBody Users user) {
        return loginService.loginOut(user.getUsername());
    }
}
