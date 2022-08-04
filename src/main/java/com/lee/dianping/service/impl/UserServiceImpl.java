package com.lee.dianping.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dianping.entity.User;
import com.lee.dianping.mapper.UserMapper;
import com.lee.dianping.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户业务处理接口实现
 * @Author 61671
 * @Date 2022/7/24 11:04
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User getUser(int id) {
        return this.getById(id);
    }


}
