package com.lee.dianping.controller.admin;

import com.lee.dianping.common.AdminPermission;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.CommonRes;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.request.AdminLoginReq;
import com.lee.dianping.service.IUserService;
import com.lee.dianping.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description 运营管理员入口
 * @Author 61671
 * @Date 2022/8/26 11:08
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/admin/admin")
@Api(tags = "运营管理员入口")
public class AdminController {

    /**
     * 管理员登录会话标识
     */
    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    /**
     * 管理员账号
     */
    @Value("${admin.email}")
    private String email;

    /**
     * 管理员密码
     */
    @Value("${admin.encryptPassword}")
    private String encrptyPassord;

    @Resource
    private IUserService userService;

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private HttpServletResponse httpServletResponse;

    /**
     * 运营首页
     *
     * @return
     */
    @AdminPermission
    @RequestMapping("/index")
    @ApiOperation(value = "运营首页", httpMethod = "GET")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");

        //获取用户数量
        int userCount = this.userService.countAllUsr();

        modelAndView.addObject("userCount", userCount);
        modelAndView.addObject("CONTROLLER_NAME","admin");
        modelAndView.addObject("ACTION_NAME","index");

        return modelAndView;
    }

    /**
     * 运营登录页
     *
     * @return
     */
    @ApiOperation(value = "运营登录页", httpMethod = "GET")
    @RequestMapping("/loginPage")
    public ModelAndView loginPage(){

        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");

        return modelAndView;
    }

    /**
     * 管理员登录
     *
     * @param req
     * @param bindingResult
     * @return
     * @throws BusinessException
     */
    @ApiOperation(value = "管理员登录", httpMethod = "POST")
    @RequestMapping("/login")
    public void login(@Valid AdminLoginReq req, BindingResult bindingResult) throws BusinessException, IOException, NoSuchAlgorithmException {

        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processBindingResult(bindingResult));
        }

        //比较邮箱和密码
        if(this.email.equals(req.getEmail()) && this.encrptyPassord.equals(CommonUtil.encodeByMd5(req.getPassword()))){
            //登录成功，将信息存入会话
            this.httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION, req.getEmail());

            this.httpServletResponse.sendRedirect("/admin/admin/index");

        } else {
            throw new BusinessException(EmBusinessError.ADMIN_LOGIN_FAIL);
        }

    }
}
