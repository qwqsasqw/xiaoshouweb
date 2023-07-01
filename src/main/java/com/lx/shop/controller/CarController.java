package com.lx.shop.controller;

import com.lx.shop.dao.mapper.CarMapper;
import com.lx.shop.dao.pojo.Car;
import com.lx.shop.service.CarService;
import com.lx.shop.vo.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Transactional
@RequestMapping("/car")
public class CarController {

    @Resource
    CarService carService;


    @PostMapping("/save")
    public Result saveCar(@RequestBody Car car){
        System.out.println(car.getGid()+""+car.getUsername());
        Car flag = (Car) carService.carInfoIsExist(car.getGid(),car.getUsername()).getData();
        if(flag!=null){
            carService.updateCar(car);
        }else{
            carService.saveCar(car);
        }


        return Result.success("success");
    }

    @GetMapping("/getCarInfoByUserName")
    public Result getCarInfoByUserName(String username){
        return carService.getCarInfoByUserName(username);
    }

    @GetMapping("/deleteCarInfoByCid")
    public Result deleteCarInfoByCid(Integer cid){
        return carService.deleteCarInfoByCid(cid);
    }


}
