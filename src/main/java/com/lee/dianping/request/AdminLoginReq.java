package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @Description 管理员登录请求参数
 * @Author 61671
 * @Date 2022/8/26 15:10
 * @Version 1.0.0
 */
@ApiModel(value = "管理员登录请求参数", description = "管理员登录请求参数")
public class AdminLoginReq {

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", name = "email", required = true)
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式非法")
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
