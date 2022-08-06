package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Description 用户登录请求参数对象
 * @Author 61671
 * @Date 2022/8/6 15:55
 * @Version 1.0.0
 */
@ApiModel(value = "用户登录请求参数对象", description = "用户登录请求参数对象")
public class LoginReq {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "telphone", required = true)
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号长度为11")
    private String telphone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
