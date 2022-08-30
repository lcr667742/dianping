package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Description 商家新建请求参数
 * @Author 61671
 * @Date 2022/8/30 14:38
 * @Version 1.0.0
 */
@ApiModel(value = "商家新建请求参数", description = "商家新建请求参数")
public class SellerCreateReq {

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称", name = "name", required = true)
    @NotBlank(message = "商家名称不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
