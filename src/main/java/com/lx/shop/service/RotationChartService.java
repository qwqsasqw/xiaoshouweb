package com.lx.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.RotationChart;
import com.lx.shop.vo.Result;
import org.springframework.web.multipart.MultipartFile;


public interface RotationChartService {

    Result save(RotationChart rotationChart);

    Result ground(Integer rid);

    Result offShelf(Integer rid);

    Result getRotationChartByPage(IPage<RotationChart> page);

    Result deleteByRid(Integer rid);

    Result upLoadRotationChartImg(MultipartFile multipartFile);

    Result getRotation();
}
