package com.lee.dianping.common;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description Controller异常处理
 * @Author 61671
 * @Date 2022/7/29 11:29
 * @Version 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonRes doError(HttpServletRequest request, HttpServletResponse response, Exception exception){

        if(exception instanceof BusinessException){
            return CommonRes.create(((BusinessException) exception).getCommonError(), "fail");
        } else if(exception instanceof NoHandlerFoundException) {
            return CommonRes.create(new CommonError(EmBusinessError.NO_HANDLER_FOUND), "fail");
        } else if(exception instanceof ServletRequestBindingException) {
            return CommonRes.create(new CommonError(EmBusinessError.BIND_EXCEPTION_ERROR), "fail");
        } else {
            return CommonRes.create(new CommonError(EmBusinessError.UNKNOWN_ERROR), "fail");
        }
    }
}
