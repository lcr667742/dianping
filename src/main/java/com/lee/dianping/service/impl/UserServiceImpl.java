package com.lee.dianping.service.impl;

import com.lee.dianping.dao.UserModelMapper;
import com.lee.dianping.model.UserModel;
import com.lee.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户业务处理接口实现
 * @Author 61671
 * @Date 2022/7/24 11:04
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(int id) {
        return this.userModelMapper.selectByPrimaryKey(id);
    }
}
