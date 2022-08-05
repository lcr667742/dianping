package com.lee.dianping.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 公共请求返回对象
 * @Author 61671
 * @Date 2022/7/27 23:26
 * @Version 1.0.0
 */
@ApiModel(value = "返回对象", description = "返回对象")
public class CommonRes {

    /**
     * 请求返回处理结果
     * 成功：success 失败：fail
     */
    @ApiModelProperty(value = "请求返回处理结果", name = "status", example = "success")
    private String status;

    /**
     * 返回对象
     * 1、若status=success时，表明对应的返回的json类数据
     * 2、若status=fail时，则data内将使用通用的错误码对应的格式
     */
    @ApiModelProperty(value = "返回结果对象", name = "data")
    private Object data;

    /**
     * @param result:
     * @return CommonRes
     * @author 61671
     * @description 通用返回对象方法，状态默认为成功
     * @date 2022/7/27 23:41
     */
    public static CommonRes create(Object result) {
        return CommonRes.create(result, "success");
    }

    public static CommonRes create(Object result, String status) {
        CommonRes commonRes = new CommonRes();
        commonRes.setData(result);
        commonRes.setStatus(status);

        return commonRes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
