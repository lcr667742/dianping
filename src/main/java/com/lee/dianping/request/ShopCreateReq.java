package com.lee.dianping.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description 门店新建请求参数
 * @Author 61671
 * @Date 2022/9/9 16:09
 * @Version 1.0.0
 */
@ApiModel(value = "门店新建请求参数", description = "门店新建请求参数")
public class ShopCreateReq {

    /**
     * 店名
     */
    @ApiModelProperty(value = "门店名称", name = "name", required = true)
    @NotBlank(message = "门店名称不能为空")
    private String name;

    /**
     * 人均消费
     */
    @ApiModelProperty(value = "人均消费", name = "pricePerMan", required = true)
    @NotNull(message = "人均消费不能为空")
    private Integer pricePerMan;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度", name = "latitude", required = true)
    @NotNull(message = "纬度不能为空")
    private BigDecimal latitude;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度", name = "longitude", required = true)
    @NotNull(message = "经度不能为空")
    private BigDecimal longitude;

    /**
     * 品类id
     */
    @ApiModelProperty(value = "品类id", name = "categoryId", required = true)
    @NotNull(message = "品类id不能为空")
    private Integer categoryId;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签", name = "tags")
    private String tags;

    /**
     * 营业开始时间
     */
    @ApiModelProperty(value = "营业开始时间", name = "startTime", required = true)
    @NotBlank(message = "营业开始时间不能为空")
    private String startTime;

    /**
     * 营业结束时间
     */
    @ApiModelProperty(value = "营业结束时间", name = "endTime", required = true)
    @NotBlank(message = "营业结束时间不能为空")
    private String endTime;

    /**
     * 门店地址
     */
    @ApiModelProperty(value = "门店地址", name = "address", required = true)
    @NotBlank(message = "门店地址不能为空")
    private String address;

    /**
     * 商家id
     */
    @ApiModelProperty(value = "商家id", name = "sellerId", required = true)
    @NotNull(message = "商家id不能为空")
    private int sellerId;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标", name = "iconUrl", required = true)
    @NotBlank(message = "图标不能为空")
    private String iconUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPricePerMan() {
        return pricePerMan;
    }

    public void setPricePerMan(Integer pricePerMan) {
        this.pricePerMan = pricePerMan;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
