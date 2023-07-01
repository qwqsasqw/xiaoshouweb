package com.lx.shop.handler;


import com.lx.shop.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//对加了@Controller注解的类进行拦截处理
@ControllerAdvice
public class AllExceptionHandler {

    //对Exception类型的类进行异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e){
        e.printStackTrace();
        return Result.error(-999,"系统繁忙");
    }
}
