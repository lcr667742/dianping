package com.lee.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.entity.Shop;

import java.util.List;

/**
 * @Description 门店服务
 * @Author 61671
 * @Date 2022/9/5 16:21
 * @Version 1.0.0
 */
public interface IShopService extends IService<Shop> {

    /**
     * 新建门店
     *
     * @param shop 门店
     * @return 结果条数
     */
    int create(Shop shop) throws BusinessException;

    /**
     * 获取门店列表
     *
     * @return 门店列表
     */
    List<Shop> getAllWithAssociation();

}
