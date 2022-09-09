package com.lee.dianping.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.dianping.common.AdminPermission;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Shop;
import com.lee.dianping.request.PageQuery;
import com.lee.dianping.request.ShopCreateReq;
import com.lee.dianping.service.IShopService;
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
 * @Description 门店管理入口
 * @Author 61671
 * @Date 2022/9/5 16:23
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/admin/shop")
@Api(tags = "门店管理入口")
public class ShopController {

    @Resource
    private IShopService shopService;

    @Resource
    private HttpServletResponse httpServletResponse;

    /**
     * 门店管理首页
     *
     * @param pageQuery 分页参数
     * @return 门店管理首页
     */
    @AdminPermission
    @RequestMapping("/index")
    @ApiOperation(value = "门店管理首页", httpMethod = "GET")
    public ModelAndView index(PageQuery pageQuery){

        PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());

        List<Shop> shops = this.shopService.getAllWithAssociation();

        PageInfo<Shop> pageInfo = new PageInfo<>(shops);

        ModelAndView modelAndView = new ModelAndView("/admin/shop/index");

        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","index");
        modelAndView.addObject("data", pageInfo);

        return modelAndView;
    }

    /**
     * 门店新增页面
     *
     * @return 分类新增页面
     */
    @AdminPermission
    @RequestMapping("/createPage")
    @ApiOperation(value = "分类新增页面", httpMethod = "GET")
    public ModelAndView createPage(){

        ModelAndView modelAndView = new ModelAndView("/admin/shop/create");

        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","create");

        return modelAndView;
    }

    /**
     * 门店新建
     *
     * @param req 门店新建参数
     * @param bindingResult 参数校验
     * @throws BusinessException 业务异常
     */
    @ApiOperation(value = "门店新建", httpMethod = "POST")
    @RequestMapping("/create")
    public void create(@Valid ShopCreateReq req, BindingResult bindingResult) throws BusinessException, IOException {

        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processBindingResult(bindingResult));
        }

        Shop shop = new Shop();
        shop.setName(req.getName());
        shop.setAddress(req.getAddress());
        shop.setCategoryId(req.getCategoryId());
        shop.setIconUrl(req.getIconUrl());
        shop.setEndTime(req.getEndTime());
        shop.setStartTime(req.getStartTime());
        shop.setLatitude(req.getLatitude());
        shop.setLongitude(req.getLongitude());
        shop.setSellerId(req.getSellerId());
        shop.setPricePerMan(req.getPricePerMan());

        int rev = this.shopService.create(shop);

        if(rev == 1){
            this.httpServletResponse.sendRedirect("/admin/shop/index");
        }

    }

}
