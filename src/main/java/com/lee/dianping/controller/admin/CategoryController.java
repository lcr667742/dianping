package com.lee.dianping.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.dianping.common.AdminPermission;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Category;
import com.lee.dianping.entity.Seller;
import com.lee.dianping.request.CategoryCreateReq;
import com.lee.dianping.request.PageQuery;
import com.lee.dianping.request.SellerCreateReq;
import com.lee.dianping.service.ICategoryService;
import com.lee.dianping.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Description 分类管理入口
 * @Author 61671
 * @Date 2022/8/30 10:45
 * @Version 1.0.0
 */
@RestController("/admin/category")
@RequestMapping("/admin/category")
@Api(tags = "分类管理入口")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @Resource
    private HttpServletResponse httpServletResponse;

    /**
     * 分类管理首页
     *
     * @param pageQuery 分页参数
     * @return 分类管理首页
     */
    @AdminPermission
    @RequestMapping("/index")
    @ApiOperation(value = "分类管理首页", httpMethod = "GET")
    public ModelAndView index(PageQuery pageQuery){

        PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());

        List<Category> categories = this.categoryService.getAll();

        PageInfo<Category> pageInfo = new PageInfo<>(categories);

        ModelAndView modelAndView = new ModelAndView("/admin/category/index");

        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        modelAndView.addObject("data", pageInfo);

        return modelAndView;
    }

    /**
     * 分类新增页面
     *
     * @return 分类新增页面
     */
    @AdminPermission
    @RequestMapping("/createPage")
    @ApiOperation(value = "分类新增页面", httpMethod = "GET")
    public ModelAndView createPage(){

        ModelAndView modelAndView = new ModelAndView("/admin/category/create");

        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","create");

        return modelAndView;
    }

    /**
     * 分类新建
     *
     * @param req 分类
     * @param bindingResult 参数校验结果
     */
    @ApiOperation(value = "商家新建", httpMethod = "POST")
    @RequestMapping("/create")
    public void create(@Valid CategoryCreateReq req, BindingResult bindingResult) throws BusinessException, IOException {

        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processBindingResult(bindingResult));
        }

        Category category = new Category();
        category.setName(req.getName());
        category.setIconUrl(req.getIconUrl());
        category.setSort(req.getSort());

        int rev = this.categoryService.create(category);

        //成功后跳转
        if (rev == 1){
            this.httpServletResponse.sendRedirect("/admin/category/index");
        }
    }

}
