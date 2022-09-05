package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Description 分类新建请求参数
 * @Author 61671
 * @Date 2022/9/5 10:51
 * @Version 1.0.0
 */
@ApiModel(value = "分类新建请求参数", description = "分类新建请求参数")
public class CategoryCreateReq {


    @ApiModelProperty(value = "分类名称", name = "name", required = true)
    @NotBlank(message = "分类名称不能为空")
    private String name;

    @ApiModelProperty(value = "图片路径", name = "iconUrl", required = true)
    @NotBlank(message = "图片路径不能为空")
    private String iconUrl;

    @ApiModelProperty(value = "排序标识", name = "sort")
    private int sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
