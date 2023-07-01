package com.lx.shop.controller;

import com.lx.shop.dao.pojo.UserInfo;
import com.lx.shop.service.UserInfoService;
import com.lx.shop.vo.Result;
import javafx.geometry.Pos;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Transactional
@RequestMapping("/userInfo")
@RestController
@CrossOrigin
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody UserInfo userInfo){

        return userInfoService.updateUserInfo(userInfo);
    }

    @PostMapping("/updateProFile")
    public Result updateProFile(@RequestParam("file") MultipartFile multipartFile) {
        return userInfoService.uploadProFile(multipartFile);
    }



}
