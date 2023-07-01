package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.AdministratorMapper;
import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.service.AdministratorService;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    AdministratorMapper administratorMapper;

    @Override
    public Result Login(Administrator administrator) {
        return Result.success(administratorMapper.Login(administrator));
    }

    @Override
    public Result updateLoginStatus(String anum) {
        return Result.success(administratorMapper.updateLoginStatus(anum));
    }

    @Override
    public Result loginOut(String anum) {
        return Result.success(administratorMapper.loginOut(anum));
    }
}
