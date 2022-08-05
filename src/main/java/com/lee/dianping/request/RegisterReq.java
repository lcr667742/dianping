package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description 用户注册请求参数
 * @Author 61671
 * @Date 2022/8/5 15:15
 * @Version 1.0.0
 */
@ApiModel(value = "用户注册请求对象", description = "用户注册请求对象")
public class RegisterReq {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "telphone", required = true)
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号长度为11")
    private String telphone;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", name = "nickName", required = true)
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 性别 1-男 2-女
     */
    @ApiModelProperty(value = "性别", name = "gender", required = true)
    @NotNull(message = "性别不能为空")
    private Integer gender;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
