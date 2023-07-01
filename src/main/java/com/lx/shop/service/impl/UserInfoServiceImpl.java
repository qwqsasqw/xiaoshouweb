package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.UserInfoMapper;
import com.lx.shop.dao.pojo.UserInfo;
import com.lx.shop.service.UserInfoService;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public Result updateUserInfo(UserInfo userInfo) {
        return Result.success(userInfoMapper.updateUserInfo(userInfo));
    }

    @Override
    public Result uploadProFile(MultipartFile multipartFile) {
        String localImage = "E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/userProfile";//E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/userProfile
        String imagePath = localImage + "/" + multipartFile.getOriginalFilename();
        String imageUrl = "http://localhost:8080/userProfile" + "/" + multipartFile.getOriginalFilename();//userProfile
        File file = new File(imagePath);
        String profile = "";//profile
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            profile = imageUrl;
        } catch (Exception e) {
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        }

        return Result.success(profile);
    }

    @Override
    public Result updateUserInfoByAcceptRefund(Integer uid, Double balance) {
        return Result.success(userInfoMapper.updateUserInfoByAcceptRefund(uid,balance));
    }
}
