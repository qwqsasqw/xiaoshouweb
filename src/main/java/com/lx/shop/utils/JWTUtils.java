package com.lx.shop.utils;

import com.alibaba.fastjson2.JSON;

import com.lx.shop.dao.pojo.Administrator;
import com.lx.shop.dao.pojo.Users;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String jwtToken = "camelTakeaway!@163.cn";

    public static String createToken(Users users) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userInfo", JSON.toJSONString(users));
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，密钥为jwtToken
                .setClaims(claims) // body数据，唯一
                .setIssuedAt(new Date()) // 设计签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000)); //默认一天有效时间
        return jwtBuilder.compact();
    }

    public static String createToken(Administrator administrator) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userInfo", JSON.toJSONString(administrator));
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，密钥为jwtToken
                .setClaims(claims) // body数据，唯一
                .setIssuedAt(new Date()) // 设计签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000)); //默认一天有效时间
        return jwtBuilder.compact();
    }

    public static Map<String, Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        } catch (JwtException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Users getUserInfo(String token) {
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        assert stringObjectMap != null;
        String userInfoStr = (String)stringObjectMap.get("userInfo");
        return JSON.parseObject(userInfoStr, Users.class);
    }
}
