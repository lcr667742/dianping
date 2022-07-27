package com.lee.dianping.common;

/**
 * @Description 错误返回对象
 * @Author 61671
 * @Date 2022/7/27 23:45
 * @Version 1.0.0
 */
public class CommonError {

    /**
     * 错误码
     */
    private int errCode;

    /**
     * 错误提示
     */
    private String errMsg;

    public CommonError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonError(EmBusinessError emBusinessError) {
        this.errCode = emBusinessError.getErrCode();
        this.errMsg = emBusinessError.getErrMsg();
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
