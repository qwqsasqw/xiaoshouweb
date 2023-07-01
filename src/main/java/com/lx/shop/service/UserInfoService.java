package com.lx.shop.service;

import com.lx.shop.dao.pojo.UserInfo;
import com.lx.shop.vo.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UserInfoService {

    Result updateUserInfo(UserInfo userInfo);

    Result uploadProFile(MultipartFile multipartFile);

    Result updateUserInfoByAcceptRefund(Integer uid,Double balance);
}
