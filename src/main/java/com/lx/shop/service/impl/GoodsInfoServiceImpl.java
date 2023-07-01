package com.lx.shop.service.impl;

import com.lx.shop.dao.mapper.GoodsInfoMapper;
import com.lx.shop.dao.pojo.GoodsInfo;
import com.lx.shop.service.GoodsInfoService;
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
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Resource
    GoodsInfoMapper goodsInfoMapper;

    @Override
    public Result updateStock(Integer gid, Integer gnum) {
        return Result.success(goodsInfoMapper.updateStock(gid,gnum));
    }

    @Override
    public Result ground(Integer gid) {
        return Result.success(goodsInfoMapper.ground(gid));
    }

    @Override
    public Result offShelf(Integer gid) {
        return Result.success(goodsInfoMapper.offShelf(gid));
    }


    @Override
    public Result uploadGoodsImg(MultipartFile multipartFile) {
        String localImage = "E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/goodsImg";//E:/apache-tomcat-9.0.70-windows-x64/apache-tomcat-9.0.70/webapps/userProfile
        String imagePath = localImage + "/" + multipartFile.getOriginalFilename();
        String imageUrl = "http://localhost:8080/goodsImg" + "/" + multipartFile.getOriginalFilename();//userProfile
        File file = new File(imagePath);
        String goodsImg = "";//profile
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            goodsImg = imageUrl;
        } catch (Exception e) {
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        }
//        System.out.println(profile);
        return Result.success(goodsImg);
    }

    @Override
    public Result saveGoodsInfo(GoodsInfo goodsInfo) {
        return Result.success(goodsInfoMapper.saveGoodsInfo(goodsInfo));
    }
}
