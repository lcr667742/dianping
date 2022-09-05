package com.lee.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.entity.Category;

import java.util.List;

/**
 * @Description 分类服务
 * @Author 61671
 * @Date 2022/9/5 10:37
 * @Version 1.0.0
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 新建分类
     *
     * @param category 分类
     * @return 结果条数
     */
    int create(Category category) throws BusinessException;

    /**
     * 获取分类列表
     *
     * @return 分类列表
     */
    List<Category> getAll();

    /**
     * 获取指定标识下的列表
     *
     * @param flag 0-启用 1-禁用
     * @return
     */
    List<Category> getListByFlag(int flag);

}
