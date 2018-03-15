package com.ezreal.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * 一般而言，针对不同业务，不同 exception 编写不同的处理方法
 * 同时，将exception信息写入日志保存
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> result = new HashMap<>();
        result.put("success",false);
        result.put("errMsg",e.getMessage());
        return result;
    }

}
