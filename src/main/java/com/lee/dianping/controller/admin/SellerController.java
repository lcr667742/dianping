package com.lee.dianping.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.dianping.common.AdminPermission;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.CommonRes;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Seller;
import com.lee.dianping.request.PageQuery;
import com.lee.dianping.request.SellerCreateReq;
import com.lee.dianping.service.ISellerService;
import com.lee.dianping.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Description 商家运营管理员入口
 * @Author 61671
 * @Date 2022/8/30 10:37
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/admin/seller")
@Api(tags = "运营管理员入口")
public class SellerController {

    @Resource
    private ISellerService sellerService;

    @Resource
    private HttpServletResponse httpServletResponse;

    /**
     * 商家管理首页
     *
     * @param pageQuery 分页参数
     * @return 商家管理首页
     */
    @AdminPermission
    @RequestMapping("/index")
    @ApiOperation(value = "运营首页", httpMethod = "GET")
    public ModelAndView index(PageQuery pageQuery){

        PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());

        List<Seller> allSeller = this.sellerService.getAllSeller();

        PageInfo<Seller> pageInfo = new PageInfo<>(allSeller);

        ModelAndView modelAndView = new ModelAndView("/admin/seller/index");

        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");
        modelAndView.addObject("data", pageInfo);

        return modelAndView;
    }

    /**
     * 商家新增页面
     *
     * @return
     */
    @AdminPermission
    @RequestMapping("/createPage")
    @ApiOperation(value = "商家新增页面", httpMethod = "GET")
    public ModelAndView createPage(){

        ModelAndView modelAndView = new ModelAndView("/admin/seller/create");

        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","create");

        return modelAndView;
    }

    /**
     * 商家新建
     *
     * @param req
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "商家新建", httpMethod = "POST")
    @RequestMapping("/create")
    public void create(@Valid SellerCreateReq req, BindingResult bindingResult) throws BusinessException, IOException {

        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processBindingResult(bindingResult));
        }

        Seller seller = new Seller();
        seller.setName(req.getName());

        this.sellerService.create(seller);

        this.httpServletResponse.sendRedirect("/admin/seller/index");
    }

    /**
     * 商家启用
     *
     * @param id 商家id
     * @return
     */
    @ApiOperation(value = "商家启用", httpMethod = "POST")
    @RequestMapping("/up")
    public CommonRes up(@RequestParam int id) throws BusinessException {

        int rev = this.sellerService.changeStatus(id, 0);

        return CommonRes.create(rev);
    }

    /**
     * 商家禁用
     *
     * @param id 商家id
     * @return
     */
    @ApiOperation(value = "商家禁用", httpMethod = "POST")
    @RequestMapping("/down")
    public CommonRes down(@RequestParam int id) throws BusinessException {

        int rev = this.sellerService.changeStatus(id, 1);

        return CommonRes.create(rev);
    }
}
