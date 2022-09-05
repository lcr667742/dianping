package com.lee.dianping.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Category;
import com.lee.dianping.mapper.CategoryMapper;
import com.lee.dianping.service.ICategoryService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 分类服务实现
 * @Author 61671
 * @Date 2022/9/5 10:37
 * @Version 1.0.0
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public int create(Category category) throws BusinessException {

        boolean result = false;

        try {
            result = this.save(category);
        }catch (DuplicateKeyException e){
            throw new BusinessException(EmBusinessError.CATEGORY_DUP_FAIL);
        }

        return result ? 1 : 0;
    }

    @Override
    public List<Category> getAll() {

        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");

        return this.list(wrapper);
    }

    @Override
    public List<Category> getListByFlag(int flag) {

        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq(flag != -1,"disabled_flag", flag)
               .orderByDesc("sort");

        return this.list(wrapper);
    }
}
