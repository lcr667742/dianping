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
    PARAMETER_VALIDATION_ERROR(1004, "请求参数校验不通过"),

    //用户服务相关的错误类型20000开头
    REGISTER_DUP_FAIL(20001,"用户已存在"),
    LOGIN_FAIL(20002,"手机号或密码错误"),

    //admin相关错误
    ADMIN_SHOULD_LOGIN(30001,"管理员需要登录"),
    ADMIN_LOGIN_FAIL(30002,"邮箱号或密码错误"),

    //商家相关错误
    SELLER_NOT_EXIST(40001,"商家不存在"),
    SELLER_DISABLED(40002,"商家已禁用"),

    //品类相关错误
    CATEGORY_DUP_FAIL(50001,"品类已存在"),
    CATEGORY_NOT_EXIST(50002,"商家不存在"),

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
