package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.CarMapper;
import com.lx.shop.dao.pojo.Car;
import com.lx.shop.service.CarService;
import com.lx.shop.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional

public class CarServiceImpl implements CarService {

    @Resource
    CarMapper carMapper;

    @Override
    public Result saveCar(Car car) {
        return Result.success(carMapper.saveCar(car));
    }

    @Override
    public Result updateCar(Car car) {
        return Result.success(carMapper.updateCar(car));
    }

    @Override
    public Result carInfoIsExist(Integer gid, String username) {
        return Result.success(carMapper.carInfoIsExist(gid,username));
    }

    @Override
    public Result getCarInfoByUserName(String username) {
        return Result.success(carMapper.getCarInfoByUserName(username));
    }

    @Override
    public Result deleteCarInfoByCid(Integer cid) {
        return Result.success(carMapper.deleteCarInfoByCid(cid));
    }

    @Override
    public Result clearCarByUserName(String username) {
        return Result.success(carMapper.clearCarByUserName(username));
    }
}
