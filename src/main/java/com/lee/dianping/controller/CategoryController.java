package com.lee.dianping.controller;

import com.lee.dianping.common.CommonRes;
import com.lee.dianping.entity.Category;
import com.lee.dianping.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 分类展示入口
 * @Author 61671
 * @Date 2022/9/5 15:04
 * @Version 1.0.0
 */
@RestController("/category")
@RequestMapping("/category")
@Api(tags = "分类展示入口")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    /**
     * 获取分类列表
     *
     * @return CommonRes
     */
    @ApiOperation(value = "获取分类列表", response = CommonRes.class, httpMethod = "GET")
    @RequestMapping("/list")
    public CommonRes list(){

        List<Category> list = this.categoryService.getListByFlag(0);

        return CommonRes.create(list);
    }
}
