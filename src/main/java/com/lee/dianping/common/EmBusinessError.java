package com.lee.dianping.common;

/**
 * @Description 错误对象枚举
 * @Author 61671
 * @Date 2022/7/27 23:47
 * @Version 1.0.0
 */
public enum EmBusinessError {

    NO_OBJECT_FOUND(10001, "请求对象不存在"),
    NO_HANDLER_FOUND(10002, "请求路径不存在"),
    BIND_EXCEPTION_ERROR(10003, "请求参数错误"),

    UNKNOWN_ERROR(19999, "未知错误");


    /**
     * 错误码
     */
    private int errCode;

    /**
     * 错误提示
     */
    private String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
