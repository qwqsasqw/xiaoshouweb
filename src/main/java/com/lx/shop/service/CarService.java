package com.lx.shop.service;

import com.lx.shop.dao.pojo.Car;
import com.lx.shop.vo.Result;


public interface CarService {


    Result saveCar(Car car);


    Result updateCar(Car car);

    Result carInfoIsExist(Integer gid,String username);


    Result getCarInfoByUserName(String username);

    Result deleteCarInfoByCid(Integer cid);

    Result clearCarByUserName(String username);
}
