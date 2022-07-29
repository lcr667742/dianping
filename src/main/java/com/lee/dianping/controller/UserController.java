package com.lee.dianping.controller;

import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.CommonError;
import com.lee.dianping.common.CommonRes;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.model.UserModel;
import com.lee.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 用户入口
 * @Author 61671
 * @Date 2022/7/23 22:40
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param id: 用户id
     * @return UserModel
     * @author 61671
     * @description 根据用户id获取用户
     * @date 2022/7/24 11:08
     */
    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name = "id") int id) throws BusinessException {

        UserModel user = this.userService.getUser(id);

        if(user == null){
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        }

        return CommonRes.create(user);
    }

    /**
     * @return String
     * @author 61671
     * @description TODO
     * @date 2022/7/23 22:57
     */
    @RequestMapping("/test")
    @ResponseBody
    public ModelAndView test() {

        String name = "Test";

        ModelAndView modelAndView = new ModelAndView("/test.html");

        modelAndView.addObject("name", name);

        return modelAndView;
    }
}
