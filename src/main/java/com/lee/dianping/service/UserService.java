package com.lee.dianping.service;

import com.lee.dianping.model.UserModel;

/**
 * @Description 用户业务处理接口
 * @Author 61671
 * @Date 2022/7/24 11:03
 * @Version 1.0.0
 */
public interface UserService {

    /**
     * @param id: 用户id
     * @return UserModel
     * @author 61671
     * @description 根据用户id获取用户
     * @date 2022/7/24 11:06
     */
    UserModel getUser(int id);
}
