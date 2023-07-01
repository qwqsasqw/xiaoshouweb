package com.lx.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.mapper.RotationChartMapper;
import com.lx.shop.dao.pojo.RotationChart;
import com.lx.shop.service.RotationChartService;
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
public class RotationChartServiceImpl implements RotationChartService {

    @Resource
    RotationChartMapper rotationChartMapper;

    @Override
    public Result save(RotationChart rotationChart) {
        return Result.success(rotationChartMapper.save(rotationChart));
    }

    @Override
    public Result ground(Integer rid) {
        return Result.success(rotationChartMapper.ground(rid));
    }

    @Override
    public Result offShelf(Integer rid) {
        return Result.success(rotationChartMapper.offShelf(rid));
    }

    @Override
    public Result getRotationChartByPage(IPage<RotationChart> page) {
        return Result.success(rotationChartMapper.getRotationChartByPage(page).getRecords());
    }

    @Override
    public Result deleteByRid(Integer rid) {
        return Result.success(rotationChartMapper.deleteByRid(rid));
    }

    @Override
    public Result upLoadRotationChartImg(MultipartFile multipartFile) {
        System.out.println(multipartFile);
        String localImage = "E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/rotationChart";//E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/userProfile
        String imagePath = localImage + "/" + multipartFile.getOriginalFilename();
        String imageUrl = "http://localhost:8080/rotationChart" + "/" + multipartFile.getOriginalFilename();//userProfile
        File file = new File(imagePath);
        String rotationChart = "";//profile
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            rotationChart = imageUrl;
        } catch (Exception e) {
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        }
        return Result.success(rotationChart);
    }

    @Override
    public Result getRotation() {
        return Result.success(rotationChartMapper.getRotation());
    }
}
