package com.lee.dianping.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.User;
import com.lee.dianping.mapper.UserMapper;
import com.lee.dianping.service.IUserService;
import com.lee.dianping.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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


    @Override
    public User register(User user) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //加密用户密码
        user.setPassword(CommonUtil.encodeByMd5(user.getPassword()));

        try {
            //保存数据
            this.save(user);
        } catch (DuplicateKeyException ex) {
            throw new BusinessException(EmBusinessError.REGISTER_DUP_FAIL);
        }

        return user;
    }
}
