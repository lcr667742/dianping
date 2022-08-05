package com.lee.dianping.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description 工具类
 * @Author 61671
 * @Date 2022/8/5 15:52
 * @Version 1.0.0
 */
public class CommonUtil {

    private CommonUtil() {
    }

    /**
     * 处理请求参数错误消息
     *
     * @param bindingResult
     * @return String
     */
    public static String processBindingResult(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage()).append(",");
        }

        return sb.substring(0, sb.length() - 1);

    }

    /**
     * MD5加密字符串
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确认计算方法MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }
}
