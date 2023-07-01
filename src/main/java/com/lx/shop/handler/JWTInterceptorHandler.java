package com.lx.shop.handler;

import com.alibaba.fastjson2.JSON;
import com.lx.shop.utils.JWTUtils;
import com.lx.shop.vo.ErrorCode;
import com.lx.shop.vo.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class JWTInterceptorHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response, final Object handler) throws java.io.IOException {
        String token = request.getHeader("Authorization");
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap != null)
            return true;
        response.setContentType("application/json");
        response.getWriter().println(JSON.toJSON(Result.error(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg())));
        return false;
    }
}
