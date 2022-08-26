package com.lee.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.entity.User;
import com.lee.dianping.request.LoginReq;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description 用户业务处理接口
 * @Author 61671
 * @Date 2022/7/24 11:03
 * @Version 1.0.0
 */
public interface IUserService extends IService<User> {

    /**
     * @param id: 用户id
     * @return UserModel
     * @author 61671
     * @description 根据用户id获取用户
     * @date 2022/7/24 11:06
     */
    User getUser(int id);

    /**
     * 用户注册
     * @param user
     * @return
     */
    User register(User user) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 用户登录
     *
     * @param loginReq
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws BusinessException
     */
    User login(LoginReq loginReq) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;

    /**
     * 统计已注册用户
     * @return
     */
    int countAllUsr();
}
