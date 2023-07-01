package com.lx.shop.controller;

import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.service.AdministratorService;
import com.lx.shop.service.LoginService;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Transactional
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Resource
    AdministratorService administratorService;
    @Resource
    LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Administrator administrator){

        return loginService.adminLogin(administrator);
    }

    @GetMapping("/loginOut")
    public Result loginOut(String anum){

        return administratorService.loginOut(anum);
    }
}
